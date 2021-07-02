package com.example.reterofitmvvm.viewmodal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.reterofitmvvm.modal.repo.UniversityRepo

class ViewModalFactory(private val repository:UniversityRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        println(" Inn view odal factory")
        if (modelClass.isAssignableFrom(UniversityViewModal::class.java)) {
            println("Assighnabke class")
            @Suppress("UNCHECKED_CAST")
            return  UniversityViewModal(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
