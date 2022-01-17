package com.example.practicalproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.example.practicalproject.MainActivity.Companion.router
import com.example.practicalproject.MainActivity.Companion.sharedPreferences
import com.example.practicalproject.R
import com.example.practicalproject.Screens

class EndDisplay : Fragment(), View.OnClickListener  {

    lateinit var tvResult: TextView
    lateinit var btnRestart: ImageButton

    val editor = sharedPreferences.edit()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_end_display, container, false)

        val result: Int = sharedPreferences.getInt("CRA", 0)

        tvResult = view.findViewById(R.id.tvResult) as TextView
        tvResult.text = "$result/10"

        btnRestart = view.findViewById(R.id.imgBtnRestart) as ImageButton
        btnRestart.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.imgBtnRestart) {
            editor.putInt("CRA", 0).apply()
            editor.putInt("CQ", 0).apply()
            router.navigateTo(Screens.startDisplay())
        }
    }
}