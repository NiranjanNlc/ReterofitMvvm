package com.example.reterofitmvvm.modal.reterofit

import android.telecom.Call
import com.example.reterofitmvvm.modal.data.University
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject


public interface RetrofitService {

    @GET("search?country=Nepal")
    fun getAllUniversity(): retrofit2.Call<List<Map<String,Any>>>

    companion object {

        var retrofitService: RetrofitService? = null

        public fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://universities.hipolabs.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

//    @Inject
//    public  fun methodInjet()
//    {
//        println("Methods injected ........................")
//    }
}