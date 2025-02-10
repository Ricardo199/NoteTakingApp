package com.example.ricardoburgos_comp304sec001_lab01

// Routes.kt

// The 'Routes' object defines constants and functions for navigation routes used throughout the app.
object Routes {

    // Constant representing the route name for the MainScreen.
    const val MainScreen = "MainScreen"

    // Constant representing the route name for the CreateNoteScreen.
    const val CreateNoteScreen = "CreateNoteScreen"

    // Constant representing the base route name for the EditNoteScreen.
    const val EditNoteScreen = "EditNoteScreen"

    /**
     * Builds the navigation route string for the EditNoteScreen with a specific note ID.
     *
     * @param noteId The unique identifier of the note to be edited.
     * @return A string representing the full navigation route to the EditNoteScreen for the given note ID.
     */
    fun editNoteRoute(noteId: Long) = "$EditNoteScreen/$noteId"
}