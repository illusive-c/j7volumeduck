# J7 Volume Duck

A tiny, offline Android app for the **Jaecoo J7** (Chery/Desay Android 11 head
unit, SA8155) that automatically lowers the music volume when a door is opened
and smoothly brings it back when the door closes.

- Opens any door or the trunk → media volume drops to **40%** of its current
  level.
- All doors closed again → volume ramps back to the previous level over
  **1 second**.
- If **you** change the volume while a door is open (or during the ramp), the
  app backs off and keeps your value.

No UI, no settings, no network access. The APK does not even request the
`INTERNET` permission.

## Requirements

- A Jaecoo J7 (or similar Chery/Desay IVI) head unit running Android 11 with
  the Desay VDS vehicle data service. The app subscribes to the `CAR_INFO`
  door/trunk items (15–19) through the vehicle's VDB bus — the same mechanism
  proven by the J7Recon / J7Toolkit projects.
- To install APKs: a USB stick, or the ADB-enabled setup you used for other
  apps.

## Install

1. Copy `j7volumeduck_v1.apk` to a USB stick (or transfer it however you
   installed your other apps).
2. Install it from the head unit's file manager, or with:

   ```bash
   adb install -r j7volumeduck_v1.apk
   ```

3. Start it once: tap the **J7 Volume Duck** icon if your launcher shows it,
   or launch it from ADB:

   ```bash
   adb shell am start -n com.j7volumeduck/.BootstrapActivity
   ```

   The activity is invisible; it just starts the foreground service. You will
   see a silent "J7 Volume Duck active" notification.

## Auto start at boot

The app contains a `BOOT_COMPLETED` receiver, but on this head unit the
reliable autostart path is the **DSA app (JCarTools / "Driver Settings")**
that most J7 owners already run:

1. Open DSA.
2. Add a *boot start* entry for the app and point it at
   `com.j7volumeduck/.BootstrapActivity` (this is the same trick the J7
   Toolkit service uses, confirmed working on the car).
3. Reboot and check the notification appears.

The service is `START_STICKY`, so Android also restarts it if the system kills
it.

## Behavior details

| Aspect | Value |
|---|---|
| Monitored inputs | VDB `CAR_INFO` read-only items 15–19 (driver, passenger, rear L/R, trunk) |
| Audio stream | `AudioManager.STREAM_MUSIC` only |
| Duck target | 40% of the pre-open volume (60% reduction) |
| Restore | Linear ramp, 10 steps × 100 ms = 1 s |
| Manual override | Any volume change that isn't the app's own cancels the restore and keeps your value |
| Config | None — fixed at build time |

The app never writes to the vehicle bus (`get`/`subscribe` only) and only ever
sets the media stream volume.

## Build it yourself

Linux with bash + a host JDK. The build script uses a plain Android SDK
layout:

```text
/opt/android/
  jdk/                 # JDK 11+ (JAVA_HOME)
  sdk/build-tools/34.0.0/
  sdk/platform-tools/
  sdk/platforms/android-30/android.jar
```

```bash
./build.sh
# -> releases/j7volumeduck_v1.apk
```

Signing defaults to the author's keystore path and password; provide your own:

```bash
J7VD_KEYSTORE=/path/to/your.keystore \
J7VD_KS_PASS=yourpass \
J7VD_KS_ALIAS=youralias \
./build.sh
```

The `vdb/src` directory contains the Desay VDB client classes (event
definitions and binder stubs) needed to talk to the car's data bus. They are
build-time only; the app is fully offline.

## Troubleshooting

- Uncaught exceptions are appended to the app's private `crash.txt`
  (`/data/data/com.j7volumeduck/files/`), readable over ADB with
  `run-as com.j7volumeduck` on debuggable builds, or included in a bug report.
- If ducking never happens, the head unit's VDS `CAR_INFO` service is most
  likely not reachable from third-party apps on your firmware version.

## Disclaimer

Unofficial, community-made. Not affiliated with Chery, Jaecoo, or Desay. Use
at your own risk.
