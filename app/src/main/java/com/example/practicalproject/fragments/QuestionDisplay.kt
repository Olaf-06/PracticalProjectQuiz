package com.example.practicalproject.fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.practicalproject.Data
import com.example.practicalproject.MainActivity
import com.example.practicalproject.MainActivity.Companion.sharedPreferences
import com.example.practicalproject.R
import com.example.practicalproject.Screens

class QuestionDisplay : Fragment(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var imageView: ImageView
    private lateinit var imageButtonForward: ImageButton
    private lateinit var radioGroup: RadioGroup
    private lateinit var radiobutton1: RadioButton
    private lateinit var radiobutton2: RadioButton
    private lateinit var radiobutton3: RadioButton
    private lateinit var tvQuestion: TextView

    val editor: SharedPreferences.Editor = sharedPreferences.edit()

    var j: Int = sharedPreferences.getInt("CRA", 1)   //счётчик правильных ответов

    var i: Int = sharedPreferences.getInt("CQ", 1)   //хранит в себе номер текущего вопроса

    var correctness: Boolean = false  //содержит в себе правильность ответа

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_question, container, false)

        imageButtonForward = view.findViewById(R.id.imgBtnForward) as ImageButton
        imageButtonForward.setOnClickListener(this)

        radioGroup = view.findViewById(R.id.rg) as RadioGroup
        radioGroup.setOnCheckedChangeListener(this)

        radiobutton1 = view.findViewById(R.id.rb1) as RadioButton
        radiobutton2 = view.findViewById(R.id.rb2) as RadioButton
        radiobutton3 = view.findViewById(R.id.rb3) as RadioButton

        tvQuestion = view.findViewById(R.id.tvQuestion) as TextView

        imageView = view.findViewById(R.id.imgQuestion) as ImageView

        if(i <= 9) setData() //Заполняет фрагмент данными (текста для вопросов и ответов, изображения)

        return view
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.rb1 -> correctness = Data.correctAnswers[i][0]
            R.id.rb2 -> correctness = Data.correctAnswers[i][1]
            R.id.rb3 -> correctness = Data.correctAnswers[i][2]
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgBtnForward -> {
                j = if (correctness) j + 1 else j
                editor.putInt("CRA", j).apply()
                editor.putInt("CQ", i + 1).apply()
                if(i > 8) MainActivity.router.navigateTo(Screens.endDisplay())
                else MainActivity.router.replaceScreen(Screens.questionDisplay())
            }
        }
    }

    //Заполняет фрагмент данными (текста для вопросов и ответов, изображения)
    fun setData() {
        radiobutton1.text = Data.answers[i][0]
        radiobutton2.text = Data.answers[i][1]
        radiobutton3.text = Data.answers[i][2]

        tvQuestion.text = Data.questions[i]

        imageView.setImageResource(Data.imageId[i])
    }
}