#!/bin/bash
# Build J7VolumeDuck (com.j7volumeduck) — single APK, Android 11 / API 30,
# raw aapt2/javac/d8/apksigner toolchain, same proven pipeline as J7Toolkit.
# Signing defaults to the shared J7 keystore (../keystore/recon.keystore,
# pass: android, alias: j7recon); override with env vars for your own key.
set -euo pipefail
TOOLCHAIN=/opt/android
export JAVA_HOME=$TOOLCHAIN/jdk
export PATH=$JAVA_HOME/bin:$TOOLCHAIN/sdk/build-tools/34.0.0:$TOOLCHAIN/sdk/platform-tools:$PATH
# Keep javac/d8 from exhausting a small VM (4 GiB cgroup).
export JAVA_TOOL_OPTIONS="${JAVA_TOOL_OPTIONS:-} -Xms64m -Xmx768m -XX:MaxMetaspaceSize=192m -XX:+UseSerialGC -XX:ActiveProcessorCount=2"
SDK=$TOOLCHAIN/sdk
PLATFORM=$SDK/platforms/android-30/android.jar
APP="$(cd "$(dirname "$0")" && pwd)"
BUILD=$TOOLCHAIN/build
WORK=$BUILD/j7volumeduck
APK=releases/j7volumeduck_v1.apk
KS="${J7VD_KEYSTORE:-$APP/../keystore/recon.keystore}"
KS_PASS="${J7VD_KS_PASS:-android}"
KS_ALIAS="${J7VD_KS_ALIAS:-j7recon}"
cd "$APP"
rm -rf "$WORK"
mkdir -p "$WORK/gen" "$WORK/classes" "$WORK/dex" releases

echo "== aapt2 compile"
aapt2 compile --dir app/res -o "$WORK/res.zip"

echo "== aapt2 link"
aapt2 link -o "$WORK/app.unsigned.apk" \
  -I "$PLATFORM" \
  --manifest app/AndroidManifest.xml \
  --java "$WORK/gen" \
  "$WORK/res.zip"

echo "== javac"
SOURCES=$(find app/src vdb/src -name '*.java')
R_FILES=$(find "$WORK/gen" -name 'R.java')
javac --release 8 -encoding UTF-8 \
  -cp "$PLATFORM:$WORK/gen" \
  -d "$WORK/classes" \
  $SOURCES $R_FILES

echo "== d8"
d8 --release --lib "$PLATFORM" \
  --output "$WORK/dex" $(find "$WORK/classes" -name '*.class')

echo "== add dex"
cp "$WORK/app.unsigned.apk" "$WORK/app.unaligned.apk"
python3 - <<EOF
import zipfile
with zipfile.ZipFile('$WORK/app.unaligned.apk', 'a') as z:
    z.write('$WORK/dex/classes.dex', 'classes.dex')
EOF

echo "== zipalign"
zipalign -f 4 "$WORK/app.unaligned.apk" "$WORK/app.aligned.apk"

echo "== sign with $KS (alias $KS_ALIAS)"
apksigner sign --ks "$KS" \
  --ks-pass "pass:$KS_PASS" --key-pass "pass:$KS_PASS" \
  --ks-key-alias "$KS_ALIAS" --v4-signing-enabled true \
  --out "$APK" "$WORK/app.aligned.apk"

echo "== verify"
apksigner verify --print-certs "$APK"

# Sanity gate: this app must never ship with INTERNET.
if aapt2 dump badging "$APK" | grep -q "uses-permission:.*android.permission.INTERNET"; then
  echo "ERROR: APK requests INTERNET - this must stay an offline app" >&2
  exit 1
fi

ls -la "$APK" "$APK.idsig"
