package com.example.reterofitmvvm.modal.repo

import androidx.lifecycle.MutableLiveData
import com.example.reterofitmvvm.modal.data.University
import com.example.reterofitmvvm.modal.reterofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UniversityRepo @Inject constructor(private  val service: RetrofitService)
{
    var universities =MutableLiveData<List<University>>()
    private val allUniversity  = service.getAllUniversity()

    fun getUniversities()
    {
        allUniversity.enqueue(object :Callback<List<Map<String,Any>>>
        {


            private fun getListOfUniversity(body: List<Map<String,Any>>?) : List<University>
            {
                println(" rterofit instance $service")
                val universities: MutableList<University> = mutableListOf()
                body?.forEach {
                    universities.add(University(it["name"].toString()))
                }
                return universities
            }

            override fun onResponse(
                call: Call<List<Map<String, Any>>>,
                response: Response<List<Map<String, Any>>>
            ) {
                universities.value=getListOfUniversity(response.body())
            }

            override fun onFailure(call: Call<List<Map<String, Any>>>, t: Throwable) {
                 println(" Failure implementes ..................")
            }


        })


    }

}
