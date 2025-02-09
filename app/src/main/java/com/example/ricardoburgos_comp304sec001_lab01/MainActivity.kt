package com.example.ricardoburgos_comp304sec001_lab01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main_screen", builder = {
                    composable("main_screen"){
                        MainScreen(navController)
                    }
                    composable("Create_Notes"){
                        CreateNoteScreen(navController)
                    }
                    composable("Edit_Notes"){
                        EditNoteScreen(navController)
                    }
                })
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    val notes = remember { mutableStateListOf<String>() }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("Create_Notes") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
            }
        },
        content = { padding ->
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(notes) { note ->
                    Text(text = note, modifier = Modifier.padding(8.dp))
                }
            }
        }
    )
}
