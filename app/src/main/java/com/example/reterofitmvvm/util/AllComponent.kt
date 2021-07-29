package com.example.reterofitmvvm.util

import com.example.reterofitmvvm.ui.MainActivity
import dagger.Component


@ActivityAnnoation
@Component(dependencies = [ViewModalComponent::class], modules = [OurModule::class])
interface AllComponent
{

    fun inject(activity: MainActivity)
    interface Builder
    {

        fun viewModalComponent( viewModalComponent: ViewModalComponent):Builder
        fun build():AllComponent
    }
}