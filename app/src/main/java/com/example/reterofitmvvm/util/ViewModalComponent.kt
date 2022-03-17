package com.example.reterofitmvvm.util

import com.example.reterofitmvvm.modal.repo.UniversityRepo
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [OurModule::class])
interface ViewModalComponent {


     fun  getRepo():UniversityRepo
}