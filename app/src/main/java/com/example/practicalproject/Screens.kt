package com.example.practicalproject


import com.example.practicalproject.fragments.EndDisplay
import com.example.practicalproject.fragments.QuestionDisplay
import com.example.practicalproject.fragments.StartDisplay
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun questionDisplay() = FragmentScreen {
        QuestionDisplay()
    }

    fun startDisplay() = FragmentScreen {
        StartDisplay()
    }

    fun endDisplay() = FragmentScreen {
        EndDisplay()
    }
}