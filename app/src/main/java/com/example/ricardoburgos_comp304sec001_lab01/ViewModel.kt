package com.example.ricardoburgos_comp304sec001_lab01

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

// NotesViewModel is responsible for managing the list of notes
// and providing methods to interact with them.
// It extends ViewModel to survive configuration changes.
class NotesViewModel : ViewModel() {

    // An observable list that holds Note objects.
    // Using mutableStateListOf allows Jetpack Compose to react to changes.
    val notes = mutableStateListOf<Note>()

    /**
     * Adds a new note to the list.
     *
     * @param note The note to be added.
     */
    fun addNote(note: Note) {
        notes.add(note)
    }

    /**
     * Retrieves a note by its ID.
     *
     * @param id The unique identifier of the note.
     * @return The Note object if found, or null if not found.
     */
    fun getNoteById(id: String): Note? {
        // Searches the list for a note with the matching ID.
        return notes.find { it.id == id }
    }

    /**
     * Updates an existing note with new information.
     *
     * @param updatedNote The note object containing updated details.
     */
    fun updateNote(updatedNote: Note) {
        // Finds the index of the note to be updated.
        val index = notes.indexOfFirst { it.id == updatedNote.id }
        if (index != -1) {
            // Replaces the old note with the updated note at the same index.
            notes[index] = updatedNote
        }
    }

    /**
     * Deletes a note from the list by its ID.
     *
     * @param id The unique identifier of the note to be deleted.
     */
    fun deleteNoteById(id: String) {
        // Removes all notes that match the given ID.
        // IDs are usually unique, so this typically removes one note.
        notes.removeAll { it.id == id }
    }
}