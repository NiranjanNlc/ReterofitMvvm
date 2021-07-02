package com.example.reterofitmvvm.viewmodal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reterofitmvvm.modal.data.University
import com.example.reterofitmvvm.modal.repo.UniversityRepo

class UniversityViewModal(repository: UniversityRepo) :ViewModel()
{

    val university : LiveData<List<University>> = repository.universities
    init {
        repository.getUniversities()
    }
}