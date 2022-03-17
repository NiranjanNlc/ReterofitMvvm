package com.example.reterofitmvvm.util

import com.example.reterofitmvvm.modal.reterofit.RetrofitService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OurModule
{
    @Provides
    @Singleton
    fun getRetrofitOnstance(): RetrofitService {
        return RetrofitService.getInstance()
    }
}