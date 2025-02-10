package com.example.ricardoburgos_comp304sec001_lab01

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import java.time.format.DateTimeFormatter
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

// MainActivity class serves as the entry point of the application
class MainActivity : ComponentActivity() {

    // Obtain an instance of NotesViewModel using the viewModels delegate
    private val notesViewModel: NotesViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Apply MaterialTheme to the application
            MaterialTheme {
                // Set up the navigation graph and pass the ViewModel
                NavigationDirectory(
                    notesViewModel = notesViewModel
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavController,
    notesViewModel: NotesViewModel
) {
    // Retrieve the list of notes from the ViewModel
    val notes = notesViewModel.notes

    Scaffold(
        // Floating Action Button to navigate to the CreateNoteScreen
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("CreateNoteScreen") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
            }
        },
        // Content of the main screen
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                // Title text
                Text(
                    text = "Notes",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 5.dp)
                )

                // Instructional text
                Text(
                    text = "Tap a note to view or edit.",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                )

                // Rest of your code...
                // If there are no notes, display a message
                if (notes.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No notes yet. Add a new note using the button below.",
                            textAlign = TextAlign.Center
                        )
                    }
                } else {
                    // Display the list of notes using LazyColumn
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        // Iterate over each note and display it using NoteItem composable
                        items(notes) { note ->
                            NoteItem(
                                note = note,
                                onClick = {
                                    // Navigate to the EditNoteScreen when a note is clicked
                                    navController.navigate("EditNoteScreen/${note.id}")
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}

/**
 * NoteItem composable displays an individual note in the list, wrapped in a Card for better styling.
 *
 * @param note The note data to display.
 * @param onClick The action to perform when the note is clicked.
 */
@Composable
fun NoteItem(
    note: Note,
    onClick: () -> Unit
) {
    val formattedDate = remember(note.date) {
        val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
        note.date.format(formatter)
    }

    // Wrap the content inside a Card
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp) // Add vertical padding between cards
            .clickable { onClick() }, // Handle click on the entire card
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), // Adjust padding inside the card
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f) // Allow text to take up available space
            ) {
                // Display the note title in bold font
                Text(
                    text = note.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                // Display the note content
                Text(
                    text = note.content,
                    fontSize = 14.sp
                )
            }
            // Display the formatted date on the right
            Text(
                text = formattedDate,
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp) // Space between text and date
            )
        }
    }
}