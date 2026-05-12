# NoteTakingApp

NoteTakingApp is an Android application for creating and managing personal notes. It is built with Kotlin and Jetpack Compose, with a simple interface for creating, viewing, editing, and deleting notes.

## Core Functionality

- Create notes with a title and content
- View notes in a scrollable list
- Open a note to edit existing content
- Delete notes from the list
- Store the current date for each note

## Technology

- Kotlin
- Jetpack Compose
- Material 3
- Android ViewModel
- Navigation Compose
- Gradle (Kotlin DSL)

## Requirements

- Android Studio (recent stable release)
- Android SDK 34 or higher
- JDK 17 or higher

## Build and Run

1. Clone the repository:

   ```bash
   git clone https://github.com/Ricardo199/NoteTakingApp.git
   ```

2. Open the project in Android Studio.
3. Sync Gradle dependencies.
4. Run the app on an emulator or physical device.

## Project Structure

```text
app/src/main/java/com/example/ricardoburgos_comp304sec001_lab01/
├── MainActivity.kt      # App entry point and main list UI
├── Navigation.kt        # Navigation graph and routes
├── Routes.kt            # Route constants
├── Note.kt              # Note data model
├── ViewModel.kt         # Note state and CRUD operations
├── CreateNotes.kt       # Create note screen
└── EditNote.kt          # Edit note screen
```

## License

See [LICENSE](LICENSE).
