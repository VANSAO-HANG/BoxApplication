# Running Box Application in VS Code

This guide will help you set up and run the Box Subscription Management Android project in Visual Studio Code.

## Prerequisites

### 1. Install Required Software

#### Java Development Kit (JDK 11 or higher)

```bash
# macOS - using Homebrew
brew install openjdk@11

# Verify installation
java -version
```

#### Android SDK

```bash
# macOS - using Homebrew
brew install --cask android-sdk

# Or download Android Command Line Tools from:
# https://developer.android.com/studio#command-tools
```

#### Gradle (Optional - project includes wrapper)

The project includes Gradle wrapper, so you don't need to install Gradle separately.

### 2. Set Environment Variables

Add to your `~/.zshrc` or `~/.bash_profile`:

```bash
# Android SDK
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/emulator
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin

# Java
export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-11.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH
```

Then reload:

```bash
source ~/.zshrc  # or source ~/.bash_profile
```

### 3. Install Android SDK Components

```bash
# Accept licenses
yes | sdkmanager --licenses

# Install required SDK components
sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"
sdkmanager "system-images;android-34;google_apis;x86_64"
```

### 4. Install VS Code Extensions

Open VS Code and install these extensions:

1. **Kotlin Language** (by mathiasfrohlich)
   - Extension ID: `mathiasfrohlich.Kotlin`

2. **Android iOS Emulator** (by DiemasMichiels)
   - Extension ID: `DiemasMichiels.emulate`

3. **Gradle for Java** (by Microsoft)
   - Extension ID: `vscjava.vscode-gradle`

4. **Extension Pack for Java** (by Microsoft)
   - Extension ID: `vscjava.vscode-java-pack`

Install via command palette or terminal:

```bash
code --install-extension mathiasfrohlich.Kotlin
code --install-extension DiemasMichiels.emulate
code --install-extension vscjava.vscode-gradle
code --install-extension vscjava.vscode-java-pack
```

## Project Setup

### 1. Clone and Open Project

```bash
cd /Users/vansaohang/StudioProjects/BoxApplication
code .
```

### 2. Configure Project Files

#### Create `local.properties`

Create a file at the project root:

```properties
# Path to Android SDK
sdk.dir=/Users/YOUR_USERNAME/Library/Android/sdk

# API Keys (replace with your actual keys)
STRIPE_PUBLISHABLE_KEY=pk_test_your_stripe_key
GOOGLE_CLOUD_API_KEY=your_google_cloud_key
```

#### Download Firebase Config

1. Go to [Firebase Console](https://console.firebase.google.com)
2. Select your project
3. Download `google-services.json`
4. Place it in `app/` directory

#### Update API Constants

Edit `app/src/main/java/com/aeu/boxapplication/core/utils/Constants.kt`:

```kotlin
const val BASE_URL = "https://your-cloud-function-url.com/"
const val STRIPE_PUBLISHABLE_KEY = "your_stripe_publishable_key"
```

### 3. Sync and Build Project

Open VS Code integrated terminal (`Ctrl + ~` or `Cmd + ~`):

```bash
# Make gradlew executable
chmod +x gradlew

# Sync project
./gradlew build

# Or clean and build
./gradlew clean build
```

## Running the Application

### Option 1: Using Android Emulator

#### Create an Emulator (First Time Only)

```bash
# Create AVD (Android Virtual Device)
avdmanager create avd \
  -n Pixel_5_API_34 \
  -k "system-images;android-34;google_apis;x86_64" \
  -d "pixel_5"

# List available AVDs
emulator -list-avds
```

#### Start Emulator and Run App

```bash
# Start emulator in background
emulator -avd Pixel_5_API_34 &

# Wait for device to boot (check with)
adb devices

# Install and run the app
./gradlew installDebug

# Or build and install in one command
./gradlew build installDebug
```

### Option 2: Using Physical Device

1. Enable Developer Options on your Android device:
   - Go to Settings > About Phone
   - Tap "Build Number" 7 times

2. Enable USB Debugging:
   - Settings > Developer Options > USB Debugging

3. Connect device via USB

4. Verify connection:

```bash
adb devices
```

1. Install and run:

```bash
./gradlew installDebug
```

### Option 3: Using VS Code Tasks (Recommended)

#### Create `.vscode/tasks.json`

```json
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "Build App",
      "type": "shell",
      "command": "./gradlew",
      "args": ["build"],
      "group": {
        "kind": "build",
        "isDefault": true
      },
      "problemMatcher": []
    },
    {
      "label": "Clean Build",
      "type": "shell",
      "command": "./gradlew",
      "args": ["clean", "build"],
      "problemMatcher": []
    },
    {
      "label": "Install Debug",
      "type": "shell",
      "command": "./gradlew",
      "args": ["installDebug"],
      "problemMatcher": []
    },
    {
      "label": "Run on Device",
      "type": "shell",
      "command": "./gradlew",
      "args": ["installDebug"],
      "dependsOn": ["Build App"],
      "problemMatcher": []
    },
    {
      "label": "Uninstall App",
      "type": "shell",
      "command": "adb",
      "args": ["uninstall", "com.aeu.boxapplication"],
      "problemMatcher": []
    },
    {
      "label": "View Logs",
      "type": "shell",
      "command": "adb",
      "args": ["logcat", "-s", "BoxApp"],
      "isBackground": true,
      "problemMatcher": []
    }
  ]
}
```

Run tasks with:

- `Cmd+Shift+B` (Build App)
- `Cmd+Shift+P` → "Tasks: Run Task" → Select task

#### Create `.vscode/launch.json` (Optional)

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Debug Android App",
      "request": "attach",
      "hostName": "localhost",
      "port": 5005
    }
  ]
}
```

## Useful VS Code Commands

### Build Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Clean build
./gradlew clean

# Run tests
./gradlew test

# Run Android instrumentation tests
./gradlew connectedAndroidTest
```

### ADB Commands

```bash
# List connected devices
adb devices

# Install APK manually
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Uninstall app
adb uninstall com.aeu.boxapplication

# View logs
adb logcat

# Clear app data
adb shell pm clear com.aeu.boxapplication

# Launch app manually
adb shell am start -n com.aeu.boxapplication/.presentation.MainActivity
```

### Emulator Commands

```bash
# List AVDs
emulator -list-avds

# Start emulator
emulator -avd Pixel_5_API_34

# Start emulator (no window)
emulator -avd Pixel_5_API_34 -no-window

# Stop emulator
adb emu kill
```

## Troubleshooting

### Issue: SDK not found

**Solution:**

```bash
# Set ANDROID_HOME
export ANDROID_HOME=$HOME/Library/Android/sdk

# Or create local.properties
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties
```

### Issue: Gradle build fails

**Solution:**

```bash
# Clean and rebuild
./gradlew clean build --refresh-dependencies

# Or delete build caches
rm -rf .gradle build app/build
./gradlew build
```

### Issue: Permission denied for gradlew

**Solution:**

```bash
chmod +x gradlew
```

### Issue: ADB not found

**Solution:**

```bash
# Add to PATH
export PATH=$PATH:$ANDROID_HOME/platform-tools

# Or use full path
$ANDROID_HOME/platform-tools/adb devices
```

### Issue: Emulator not starting

**Solution:**

```bash
# Check available system images
sdkmanager --list | grep system-images

# Recreate AVD
avdmanager delete avd -n Pixel_5_API_34
avdmanager create avd -n Pixel_5_API_34 -k "system-images;android-34;google_apis;x86_64"
```

### Issue: Hilt compilation errors

**Solution:**
Make sure KAPT is properly configured in `app/build.gradle.kts`:

```kotlin
plugins {
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}
```

## Development Workflow

### 1. Daily Development

```bash
# Open project
code /Users/vansaohang/StudioProjects/BoxApplication

# Start emulator (in background)
emulator -avd Pixel_5_API_34 &

# Make changes in VS Code
# Then build and install
./gradlew installDebug

# View logs
adb logcat -s BoxApp
```

### 2. Testing Changes

```bash
# Run unit tests
./gradlew test

# Run instrumentation tests
./gradlew connectedAndroidTest

# Generate coverage report
./gradlew jacocoTestReport
```

### 3. Building Release

```bash
# Build release APK
./gradlew assembleRelease

# APK location
# app/build/outputs/apk/release/app-release-unsigned.apk
```

## Performance Tips

### 1. Enable Gradle Daemon

Add to `gradle.properties`:

```properties
org.gradle.daemon=true
org.gradle.parallel=true
org.gradle.caching=true
```

### 2. Increase Gradle Memory

```properties
org.gradle.jvmargs=-Xmx4096m -XX:MaxPermSize=1024m -XX:+HeapDumpOnOutOfMemoryError
```

### 3. Use Build Cache

```bash
./gradlew build --build-cache
```

## Additional Resources

- [Android Developer Documentation](https://developer.android.com)
- [Kotlin Documentation](https://kotlinlang.org/docs)
- [Gradle Documentation](https://docs.gradle.org)
- [VS Code Java Documentation](https://code.visualstudio.com/docs/languages/java)

## Quick Reference Card

```bash
# Common Commands
./gradlew tasks                    # List all available tasks
./gradlew build                    # Build project
./gradlew installDebug             # Install debug APK
./gradlew clean                    # Clean build
adb devices                        # List devices
adb install -r app-debug.apk       # Install APK
adb logcat                         # View logs
emulator -avd <name>               # Start emulator
```

---

**Note**: While VS Code can be used for Android development, Android Studio provides better Android-specific tooling, layout editors, and debugging capabilities. Consider using Android Studio for the best development experience.
