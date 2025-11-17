# Java-Android Projects Collection

A collection of Android applications built with Java and Gradle, demonstrating various Android development concepts and features.

## 📱 Projects Overview

### 1. **AppAeroporto**
An airport management application featuring modern Android architecture and Material Design components.
- **Target SDK**: 33
- **Min SDK**: 24
- **Technologies**: AndroidX, Material Design, ConstraintLayout
- **Features**: Airport data management and ticketing

### 2. **Conta Pessoas**
A people/contacts management application with person counting and tracking capabilities.
- **Target SDK**: Latest
- **Features**: Contact management, data counting
- **User Interface**: Custom Android layouts

### 3. **Duas Telas**
A multi-screen Android application demonstrating navigation between different screens and activities.
- **Type**: Two-screen navigation sample
- **Features**: Activity transitions, screen navigation patterns

### 4. **JoKemPo**
A game application implementing the classic Rock-Paper-Scissors (Jo-Ken-Po) game.
- **Features**: Game logic, random decision generation, score tracking
- **Type**: Interactive game application

### 5. **Lista de Cartões** (Card List)
A card listing and management application for displaying and organizing card information.
- **Features**: Card collection management, list display

### 6. **Lista de Tarefas** (Task List)
A task management application for creating, organizing, and tracking to-do items.
- **Min SDK**: 21
- **Features**: Task creation, list management, item tracking

### 7. **Quizz**
A quiz application designed for educational content delivery and testing knowledge.
- **Features**: Quiz questions, answer validation, score calculation

### 8. **RoomWordSample**
A sample application demonstrating Android Room database integration with LiveData and ViewModel architecture.
- **Key Components**:
  - Room Database for local data persistence
  - ViewModel for lifecycle-aware data management
  - LiveData for reactive UI updates
  - MVVM Architecture pattern
- **Technologies**: 
  - AndroidX Room
  - Lifecycle Components
  - Architecture Components
- **Use Case**: Reference implementation for database operations in Android

## 🛠 Project Structure

Each project follows the standard Android Gradle project structure:

```
ProjectName/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/          # Source code
│   │   │   ├── res/           # Resources (layouts, strings, etc.)
│   │   │   └── AndroidManifest.xml
│   │   ├── test/              # Unit tests
│   │   └── androidTest/       # Instrumented tests
│   ├── build.gradle           # App-level build configuration
│   └── proguard-rules.pro     # Obfuscation rules
├── gradle/
│   └── wrapper/               # Gradle wrapper files
├── build.gradle               # Project-level build configuration
├── settings.gradle            # Gradle settings
└── gradle.properties          # Gradle properties
```

## 📋 Requirements

- **Java**: 1.8 (Java 8)
- **Android SDK**: Compilation SDK 34
- **Gradle**: 8.x (via wrapper)
- **Android Studio**: Latest stable version recommended

## 🚀 Getting Started

### Prerequisites
- Android Studio installed
- Android SDK with API level 24-34 installed
- Java Development Kit (JDK) 8+

### Building a Project

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd java-android
   ```

2. **Navigate to a project**:
   ```bash
   cd ProjectName
   ```

3. **Build the project**:
   ```bash
   ./gradlew build
   ```

4. **Run tests**:
   ```bash
   ./gradlew test              # Unit tests
   ./gradlew connectedAndroidTest  # Instrumented tests
   ```

5. **Install on device/emulator**:
   ```bash
   ./gradlew installDebug
   ```

## 🔧 Common Gradle Commands

- `./gradlew clean` - Clean build artifacts
- `./gradlew build` - Build the project
- `./gradlew assemble` - Assemble APK
- `./gradlew connectedAndroidTest` - Run instrumented tests
- `./gradlew test` - Run unit tests
- `./gradlew installDebug` - Install debug APK on device

## 📚 Key Dependencies

### Common Across Projects:
- **AndroidX AppCompat**: `androidx.appcompat:appcompat:1.7.0+`
- **Material Design**: `com.google.android.material:material:1.12.0+`
- **ConstraintLayout**: `androidx.constraintlayout:constraintlayout:2.1.4+`
- **JUnit**: `junit:junit:4.13.2+`

### RoomWordSample Specific:
- **Room Database**: Local persistence with type-safe database access
- **ViewModel**: MVVM architecture component
- **LiveData**: Observable data holder with lifecycle awareness

## 🧪 Testing

Each project includes test configurations:

- **Unit Tests**: Located in `src/test/`
- **Instrumented Tests**: Located in `src/androidTest/`
- **Test Runner**: AndroidX Test Runner

## 📝 Build Configuration

All projects use Gradle as the build system with the following common settings:

- **Compile SDK**: 34
- **Minimum SDK**: 24 (varies by project)
- **Target SDK**: 33-34 (varies by project)
- **Java Compatibility**: Java 8

## 🎯 Project Features Summary

| Project | Purpose | Key Tech |
|---------|---------|----------|
| AppAeroporto | Airport management | Material Design |
| Conta Pessoas | Contact tracking | Android Framework |
| Duas Telas | Multi-screen navigation | Activities |
| JoKemPo | Rock-paper-scissors game | Game Logic |
| Lista de Cartões | Card management | List Views |
| Lista de Tarefas | Task management | RecyclerView/Database |
| Quizz | Quiz/education | Question Logic |
| RoomWordSample | Database reference | Room DB, MVVM |

## 📱 Target Platforms

- **Minimum Android Version**: API 21 (Android 5.0)
- **Maximum Android Version**: API 34 (Android 14)
- **Target Devices**: Phones and Tablets

## 🐛 Troubleshooting

### Build Issues
- Ensure JDK 8+ is installed
- Run `./gradlew clean` before rebuilding
- Check Android SDK Manager for required API levels

### Runtime Issues
- Test on Android API 24+ devices/emulators
- Check logcat for detailed error messages
- Verify AndroidManifest.xml permissions

## 📄 License

This project collection is available for educational and development purposes.

## 👤 Author

[Breno Kern]

---

**Note**: This is a learning and development project collection. Each app demonstrates different Android development patterns and best practices.
