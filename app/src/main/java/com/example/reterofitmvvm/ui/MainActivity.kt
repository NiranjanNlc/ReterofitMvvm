package com.example.reterofitmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reterofitmvvm.R
import com.example.reterofitmvvm.databinding.ActivityMainBinding
import com.example.reterofitmvvm.modal.repo.UniversityRepo
import com.example.reterofitmvvm.modal.reterofit.RetrofitService
import com.example.reterofitmvvm.util.DaggerViewModalComponent
import com.example.reterofitmvvm.util.ViewModalComponent
import com.example.reterofitmvvm.viewmodal.UniversityViewModal
import com.example.reterofitmvvm.viewmodal.ViewModalFactory
import dagger.internal.DaggerGenerated
import javax.inject.Inject


class MainActivity : AppCompatActivity()
{

    @Inject
   lateinit var repository:UniversityRepo
    private lateinit var binding: ActivityMainBinding
    private lateinit var sampleViewModal: UniversityViewModal
    private val adapter: Adapter = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding   = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindData()
        initRecyclerView()
        observeChange()
    }

    private fun initRecyclerView()
    {
        print(" recycler view initiated")
        binding.uniRecycler.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        binding.uniRecycler.setHasFixedSize(true)
        binding.uniRecycler.adapter=   adapter
        adapter.submitList(sampleViewModal.university.value)
    }

    private fun observeChange()
    {
     sampleViewModal.university.observe(this, Observer
     {
         adapter.submitList(it)
     })
    }

    private fun bindData()
    { initialiseSampleViewModal()
        println(" Sample ViewModal  views "+ sampleViewModal.university)
         binding.lifecycleOwner=this
    }

    private fun initialiseSampleViewModal()
    {
        val component =DaggerViewModalComponent.create();
       // val repository =UniversityRepo(RetrofitService.getInstance())
       // val repository= component.getRepo()
        sampleViewModal= ViewModalFactory( repository).create(UniversityViewModal::class.java)
    }
}
