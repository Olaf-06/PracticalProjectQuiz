package com.example.practicalproject

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

//Создаём роутер из cicerone библиотеки

class MyRouter {
    private val cicerone: Cicerone<Router> = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()
}