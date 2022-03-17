package com.example.reterofitmvvm.util

import com.example.reterofitmvvm.modal.reterofit.RetrofitService
import dagger.Binds
import dagger.Module


@Module
abstract   class BindModule
{
    @Binds
    abstract fun getRetrofitOnstance( retrofitService: RetrofitService): RetrofitService?
}