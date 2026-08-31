# Face Detection Attendance System

An Android-based attendance project that uses **Kotlin**, **Android SDK**, **Google ML Kit Face Detection**, and local storage to demonstrate an automated attendance workflow.

> **Important:** This GitHub version is a clean portfolio/demo implementation based on the project document. Google ML Kit Face Detection detects faces and facial landmarks; it does **not by itself identify a person's identity**. For production-grade face recognition, a separate embedding/recognition model and secure biometric storage are required.

## Features

- Student registration
- Camera permission handling
- Google ML Kit face detector initialization
- Attendance marking with timestamp
- Local storage for demo student/attendance data
- Simple Android UI suitable for GitHub portfolio presentation

## Technology Stack

- Kotlin
- Android Studio
- Android SDK 35
- Google ML Kit Face Detection
- Material 3
- SharedPreferences for this demo

The original project document describes Android Studio, Kotlin/XML, SQLite, Google ML Kit and TensorFlow Lite as the intended technology stack. It also describes modules for onboarding, admin login, student registration, face verification and today's attendance. 

## Project Flow

```text
Welcome / Main Screen
        |
        +----> Student Registration
        |
        +----> Take Attendance
                    |
                    v
             Face Detection
                    |
                    v
            Student Verification*
                    |
                    v
          Attendance + Timestamp
```

`*` The supplied demo currently separates face detection from identity recognition. Do not claim biometric identity recognition unless a recognition model is actually integrated.

## Folder Structure

```text
Face-Detection-Attendance-System/
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/faceattendance/
│       │   ├── MainActivity.kt
│       │   ├── RegisterActivity.kt
│       │   └── AttendanceActivity.kt
│       └── res/
│           ├── layout/
│           └── values/
├── screenshots/
│   ├── 01_home.png
│   ├── 02_registration.png
│   └── 03_attendance.png
├── requirements.txt
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

## How to Run

1. Install Android Studio.
2. Open this folder as an existing Android project.
3. Allow Gradle to sync and install the Android SDK 35 if requested.
4. Connect an Android phone or start an emulator.
5. Run the `app` configuration.
6. Grant camera permission when requested.
7. Register a student.
8. Open **Take Attendance** and test the demo workflow.

## Screenshots

The images in `screenshots/` are **UI preview/mock screenshots for the GitHub README**, not claims of a live camera result.

## Future Improvements

- CameraX live camera preview
- Real-time ML Kit frame processing
- Proper face embedding extraction
- TFLite/FaceNet-style identity recognition
- SQLite/Room database
- Secure admin login
- Today's attendance dashboard
- CSV/PDF attendance export
- QR + Face hybrid verification
- Liveness/anti-spoofing
- Encrypted biometric data storage

## Privacy Note

Do not upload real students' face images, biometric embeddings, passwords, admission numbers, or attendance records to a public GitHub repository. Use dummy/sample data only.

## Project Reference

The supplied project document describes the intended system as an automated face-attendance Android application using a mobile camera, facial processing, local SQLite storage, admin login, student registration and attendance dashboard. It also lists Google ML Kit Face Detection and Kotlin documentation among the references.
