package com.example.baitaptuan1


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.baitaptuan1.databinding.ActivityListRestaurantBinding
import com.example.baitaptuan1.restaurant.Restaurant
import com.example.baitaptuan1.restaurant.RestaurantAdapter
import com.example.baitaptuan1.restaurant.RestaurantViewModel
import com.example.baitaptuan1.restaurant.getDataSet
import kotlinx.android.synthetic.main.activity_list_restaurant.*


class listRestaurant : AppCompatActivity() {

    private lateinit var binding : ActivityListRestaurantBinding
    private lateinit var viewModel: RestaurantViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_list_restaurant)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)


        val adapter = RestaurantAdapter();
        binding.rcList.adapter = adapter
        adapter.listener = object : RestaurantAdapter.RestaurantAdapterListener{
            override fun onClickItem(restaurant: Restaurant) {
                TODO("Not yet implemented")
                Log.e(">>>>>", "name: ${restaurant.name}")

            }
        }
        adapter.submitList(getDataSet())
    }
}