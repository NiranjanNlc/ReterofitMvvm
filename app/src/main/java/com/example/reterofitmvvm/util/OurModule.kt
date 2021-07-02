package com.example.reterofitmvvm.util

import com.example.reterofitmvvm.modal.reterofit.RetrofitService
import dagger.Module
import dagger.Provides

@Module
public  class OurModule
{
    @Provides
    fun getRetrofitOnstance(): RetrofitService {
        return RetrofitService.getInstance()
    }
}