package com.punk.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.punk.PunkApplication
import com.punk.viewmodels.HomeViewModel
import com.punk.R
import com.punk.factory.HomeViewModelFactory
import com.punk.models.PunkBeer
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        (application as PunkApplication).applicationComponent.inject(this)

        homeViewModel = ViewModelProvider(this,homeViewModelFactory).get(HomeViewModel::class.java)

        homeViewModel.beersLiveData.observe(this, Observer {
            rvPunkBeers.layoutManager = LinearLayoutManager(this)
            val yourAdapter = PunkBeerAdapter(this, it as ArrayList<PunkBeer>)
            rvPunkBeers.adapter = yourAdapter
        })
    }

}



















