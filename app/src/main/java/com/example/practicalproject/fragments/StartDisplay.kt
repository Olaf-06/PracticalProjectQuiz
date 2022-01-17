package com.example.practicalproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.practicalproject.MainActivity.Companion.router
import com.example.practicalproject.MyRouter
import com.example.practicalproject.R
import com.example.practicalproject.Screens

class StartDisplay : Fragment(), View.OnClickListener {

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_start_display, container, false)

        button = view.findViewById(R.id.btnStart) as Button
        button.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnStart) {
            router.navigateTo(Screens.questionDisplay())
        }
    }
}