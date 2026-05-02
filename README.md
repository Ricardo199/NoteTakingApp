# NoteTakingApp

A clean, lightweight Android note-taking application built with **Kotlin** and **Jetpack Compose**. NoteTakingApp lets you quickly capture, review, and update your notes with a modern Material Design 3 interface.

---

## Features

- 📝 **Create notes** – Add a new note with a title and body in seconds
- 📋 **Browse notes** – Scrollable list of all your notes with title, preview, and date
- ✏️ **Edit notes** – Tap any note to update its title or content
- 🗑️ **Delete notes** – Remove notes you no longer need
- 📅 **Auto-dated** – Each note is automatically stamped with the current date

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI toolkit | Jetpack Compose |
| Design system | Material Design 3 |
| Navigation | Navigation Compose |
| State management | ViewModel + `mutableStateListOf` |
| Build system | Gradle (Kotlin DSL) |

---

## Requirements

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK 34+
- JDK 11

---

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/Ricardo199/NoteTakingApp.git
   ```

2. **Open in Android Studio**
   - Select *File → Open* and navigate to the cloned directory.

3. **Run the app**
   - Connect a physical device or start an emulator (API 34+).
   - Click the **Run** button (▶) or press `Shift + F10`.

---

## Project Structure

```
app/src/main/java/.../
├── MainActivity.kt      # Entry point; hosts the navigation graph and note list screen
├── Navigation.kt        # NavHost setup and route definitions
├── Routes.kt            # Route constants
├── Note.kt              # Note data class (Parcelable)
├── ViewModel.kt         # NotesViewModel – add, get, update, delete notes
├── CreateNotes.kt       # Create-note screen
└── EditNote.kt          # Edit-note screen
```

---

## License

This project is licensed under the terms of the [LICENSE](LICENSE) file included in this repository.
