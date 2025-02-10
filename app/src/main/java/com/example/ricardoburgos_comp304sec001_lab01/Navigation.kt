package com.example.ricardoburgos_comp304sec001_lab01

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
/**
 * NavigationDirectory sets up the navigation graph for the app, handling navigation between screens
 * and providing global UI components like the Scaffold and SnackbarHost.
 *
 * @param notesViewModel The shared ViewModel that holds the list of notes and manages data operations.
 */
@Composable
fun NavigationDirectory(notesViewModel: NotesViewModel) {
    // Create an instance of NavController to handle navigation actions.
    val navController = rememberNavController()

    // SnackbarHostState manages the state of the Snackbar, allowing messages to be shown.
    val snackbarHostState = remember { SnackbarHostState() }

    // Provides a CoroutineScope that is tied to the composition.
    val coroutineScope = rememberCoroutineScope()

    // Scaffold provides the basic layout structure for the app, including material design components.
    Scaffold(
        // Set up the SnackbarHost to show Snackbar messages.
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        // NavHost defines the navigation graph, specifying the start destination and routes.
        NavHost(
            navController = navController,
            startDestination = "MainScreen",
            // Apply padding from the Scaffold to avoid UI overlapping with system UI elements.
            modifier = Modifier.padding(paddingValues)
        ) {
            // Define the composable for the MainScreen route.
            composable("MainScreen") {
                // Display the MainScreen, passing the NavController and ViewModel.
                MainScreen(navController = navController, notesViewModel = notesViewModel)
            }
            // Define the composable for the CreateNoteScreen route.
            composable("CreateNoteScreen") {
                // Display the CreateNoteScreen.
                CreateNoteScreen(navController = navController, notesViewModel = notesViewModel)
            }
            // Define the composable for the EditNoteScreen route with a noteId parameter.
            composable(
                route = "EditNoteScreen/{noteId}",
                arguments = listOf(navArgument("noteId") { type = NavType.StringType })
            ) { backStackEntry ->
                // Retrieve the noteId from the navigation arguments.
                val noteId = backStackEntry.arguments?.getString("noteId")
                if (noteId != null) {
                    // If noteId is not null, display the EditNoteScreen for the specified note.
                    EditNoteScreen(
                        navController = navController,
                        notesViewModel = notesViewModel,
                        noteId = noteId
                    )
                } else {
                    // If noteId is null, show a Snackbar message and navigate back to the previous screen.
                    // LaunchedEffect ensures this side effect runs when the composable enters the composition.
                    LaunchedEffect(Unit) {
                        coroutineScope.launch {
                            // Show a Snackbar with an error message.
                            snackbarHostState.showSnackbar("Note not found")
                            // Navigate back to the previous screen.
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}