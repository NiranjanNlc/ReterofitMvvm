package com.example.reterofitmvvm.util

import android.app.Application


class TestApp  : Application() {

    private var component: ViewModalComponent? = null

    override fun onCreate()
    {
        super.onCreate()
        println(" hello from the topof all application")
        component = DaggerViewModalComponent.create()
    }

    fun  getViewModal(): ViewModalComponent? = component


}