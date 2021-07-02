package com.example.reterofitmvvm.util

import com.example.reterofitmvvm.modal.repo.UniversityRepo
import dagger.Component


@Component(modules = [OurModule::class])
public interface ViewModalComponent {

     public fun  getRepo():UniversityRepo;
}