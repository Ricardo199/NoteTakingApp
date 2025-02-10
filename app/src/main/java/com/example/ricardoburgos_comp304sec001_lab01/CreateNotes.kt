package com.example.ricardoburgos_comp304sec001_lab01

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Create
import java.time.LocalDate

/**
 * CreateNoteScreen allows the user to create a new note by entering a title and content.
 *
 * @param navController Handles navigation actions between composables.
 * @param notesViewModel Manages the list of notes and data operations.
 */
@Composable
fun CreateNoteScreen(
    navController: NavController,
    notesViewModel: NotesViewModel
) {
    // State variables to hold the user's input for the title and content fields.
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    // Arranges the content vertically with padding.
    Column(modifier = Modifier.padding(16.dp)) {
        // OutlinedTextField for the note's title input.
        OutlinedTextField(
            value = title,
            onValueChange = { title = it }, // Updates the title state when the user types.
            label = { Text("Title") }, // Label displayed when the field is empty.
            leadingIcon = {
                // Icon displayed at the start of the text field.
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Title Icon"
                )
            },
            modifier = Modifier.fillMaxWidth() // TextField fills the available width.
        )

        // Adds space between the TextFields.
        Spacer(modifier = Modifier.height(8.dp))

        // OutlinedTextField for the note's content input.
        OutlinedTextField(
            value = content,
            onValueChange = { content = it }, // Updates the content state when the user types.
            label = { Text("Content") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = "Content Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Sets a fixed height for the content field to accommodate more text.
        )

        // Adds space before the Save button.
        Spacer(modifier = Modifier.height(16.dp))

        // Button to save the new note.
        Button(
            onClick = {
                // Creates a new Note object with a unique ID and the current date.
                val newNote = Note(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    content = content,
                    date = LocalDate.now()
                )
                // Adds the new note to the ViewModel's list.
                notesViewModel.addNote(newNote)
                // Navigates back to the previous screen.
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth() // Button fills the available width.
        ) {
            Text("Save") // Text displayed on the button.
        }
    }
}