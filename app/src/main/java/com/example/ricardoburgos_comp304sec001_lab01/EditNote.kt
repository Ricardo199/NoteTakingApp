package com.example.ricardoburgos_comp304sec001_lab01

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.TextField
import androidx.compose.material3.*
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteScreen(
    navController: NavController,
    notesViewModel: NotesViewModel,
    noteId: String
) {
    // Retrieve the note from the ViewModel using the provided noteId
    val note = notesViewModel.getNoteById(noteId)

    if (note == null) {
        // If the note isn't found, display an error message and return
        Text("Note not found")
        return
    }

    // State variables to hold the current title and content of the note
    var title by remember { mutableStateOf(note.title) }
    var content by remember { mutableStateOf(note.content) }

    // Scaffold provides the basic layout structure with a TopAppBar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Note") },
                navigationIcon = {
                    // Back button to navigate back to the previous screen
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        // Content of the screen
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding) // Apply padding from the Scaffold
                    .padding(16.dp)  // Additional padding around the content
            ) {
                // TextField for editing the note's title
                TextField(
                    value = title,
                    onValueChange = { title = it }, // Update the title state when changed
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp)) // Space between title and content fields
                // TextField for editing the note's content
                TextField(
                    value = content,
                    onValueChange = { content = it }, // Update the content state when changed
                    label = { Text("Content") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Set a fixed height for the content field
                )
                Spacer(modifier = Modifier.height(16.dp)) // Space before the Update button
                // Button to save the updated note
                Button(
                    onClick = {
                        // Create an updated note with the new title and content
                        val updatedNote = note.copy(
                            title = title,
                            content = content,
                            date = LocalDate.now() // Update the date to the current date
                        )
                        // Update the note in the ViewModel
                        notesViewModel.updateNote(updatedNote)
                        // Navigate back to the previous screen
                        navController.popBackStack()
                    },
                    modifier = Modifier.align(Alignment.End) // Align the button to the end (right side)
                ) {
                    Text("Update")
                }
            }
        }
    )
}