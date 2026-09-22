# J7 Volume Duck

Automatically lowers the music volume when a car door is opened and brings it
back when the door closes.

- Any door or the trunk opens → media volume drops to **40%** of its current
  level.
- All doors closed again → volume ramps back over **1 second**.
- If **you** change the volume while a door is open, the app keeps your value.

Tested with **Jaecoo J7 PHEV**.

## Requirements

- The **Driver Settings App (DSA)** and the **Play Store it provides**.

## Install

1. Copy `j7volumeduck_v1.apk` to a USB stick and plug it into the car.
2. In the Play Store, select **Install From USB** and install this app.
3. Once installed, open DSA and in **Auto Start Apps**, select this one.
4. Done.

While running, the app shows a silent "J7 Volume Duck active" notification.

## Behavior details

| Aspect | Value |
|---|---|
| Monitored inputs | VDB `CAR_INFO` read-only items 15–19 (driver, passenger, rear L/R, trunk) |
| Audio stream | `AudioManager.STREAM_MUSIC` only |
| Duck target | 40% of the pre-open volume (60% reduction) |
| Restore | Linear ramp, 10 steps × 100 ms = 1 s |
| Manual override | Any volume change that isn't the app's own cancels the restore and keeps your value |
| Settings | None — fixed at build time |

The app only reads door states and sets the media volume.

## Build it yourself

Linux with bash + a host JDK, and a plain Android SDK layout:

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
definitions and binder stubs) needed to talk to the car's data bus.

## Disclaimer

Unofficial, community-made. Not affiliated with Chery, Jaecoo, or Desay. Use
at your own risk.
