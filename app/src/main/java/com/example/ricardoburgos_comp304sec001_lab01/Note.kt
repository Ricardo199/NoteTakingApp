package com.example.ricardoburgos_comp304sec001_lab01
// Note.kt

// Import statements
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

// The @Parcelize annotation automatically generates the Parcelable implementation
@Parcelize
data class Note(
    val id: String,         // Unique identifier for the note
    val title: String,      // Title of the note
    val content: String,    // Content/body of the note
    val date: LocalDate     // Date associated with the note
) : Parcelable              // Implements Parcelable for passing between components
