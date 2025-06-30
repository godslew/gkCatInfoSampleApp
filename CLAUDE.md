# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Kotlin Multiplatform (KMP) project using Compose Multiplatform for shared UI across Android and iOS platforms. The project name is "gkCatInfoSampleApp" and appears to be a sample application related to cat information.

## Build and Development Commands

### Building the Project
```bash
# Build all modules
./gradlew build

# Build Android APK
./gradlew assembleDebug    # Debug build
./gradlew assembleRelease  # Release build

# Install on Android device/emulator
./gradlew installDebug
```

### Running Tests
```bash
# Run all tests
./gradlew allTests

# Run Android unit tests
./gradlew testDebugUnitTest

# Run iOS tests
./gradlew iosSimulatorArm64Test  # For iOS Simulator
./gradlew iosX64Test             # For x64 iOS
```

### Code Quality
```bash
# Run lint checks
./gradlew lint

# Run all verification tasks
./gradlew check
```

## Architecture

### Module Structure
- **Single module project**: `:composeApp` contains all the code
- **Package**: `org.godslew.gkcatinfosampleapp`

### Source Set Organization
- **commonMain**: Shared code across all platforms
  - `App.kt`: Main composable UI entry point
  - `Greeting.kt`: Business logic component
  - `Platform.kt`: Platform-specific interface definition
- **androidMain**: Android-specific implementations
  - `MainActivity.kt`: Android app entry point
  - `Platform.android.kt`: Android platform implementation
- **iosMain**: iOS-specific implementations
  - `MainViewController.kt`: iOS view controller
  - `Platform.ios.kt`: iOS platform implementation

### Key Technologies
- **Kotlin Multiplatform**: Version 2.2.0
- **Compose Multiplatform**: Version 1.8.2
- **Android SDK**: compileSdk 35, minSdk 24, targetSdk 35
- **JVM Target**: Java 11
- **Dependency Injection**: AndroidX Lifecycle ViewModels

### Build Configuration
- Version catalog in `gradle/libs.versions.toml`
- Android namespace: `org.godslew.gkcatinfosampleapp`
- iOS framework name: `ComposeApp` (static framework)