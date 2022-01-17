package com.example.practicalproject

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import kotlin.reflect.KParameter

class MainActivity : AppCompatActivity() {

    private val myRouter: MyRouter = MyRouter()

    val SETTING: String = "mySetting"

    lateinit var editor: SharedPreferences.Editor

    companion object {

        internal lateinit var router: Router

        internal lateinit var sharedPreferences: SharedPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences(SETTING, MODE_PRIVATE)
        myRouter.router.newRootScreen(Screens.startDisplay())
        router = myRouter.router
        editor = sharedPreferences.edit()
    }

    override fun onResume() {
        super.onResume()
        myRouter.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        myRouter.navigatorHolder.removeNavigator()
        editor.putInt("CRA", 0).apply()
        editor.putInt("CQ", 0).apply()
    }

    override fun onBackPressed() {
        editor.putInt("CRA", 0).apply()
        editor.putInt("CQ", 0).apply()
        router.navigateTo(Screens.startDisplay())
    }

    private val navigator: Navigator = AppNavigator(this, R.id.container)
}