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
    private lateinit var binding: ActivityListRestaurantBinding
    private lateinit var viewModel: RestaurantViewModel
    private var layoutManager: GridLayoutManager? = null
    private var titlesList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_restaurant)
        title="menu Restaurants"

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_restaurant)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)


        layoutManager = GridLayoutManager(this, 1)
        rcList.layoutManager = layoutManager


        rcList.adapter =RestaurantAdapter(layoutManager as GridLayoutManager)

        val adapter = RestaurantAdapter();
        binding.rcList.adapter = adapter
        adapter.listener = object : RestaurantAdapter.RestaurantAdapterListener {
            override fun onClickItem(restaurant: Restaurant) {
                TODO("Not yet implemented")
                Log.e(">>>>>", "name: ${restaurant.name}")

            }
        }
        adapter.submitList(getDataSet())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item?.itemId) {
            R.id.menu1 -> {
                if (layoutManager?.spanCount == 1) {
                    layoutManager?.spanCount = 3
                    item.title = "list"
                    item.icon = getDrawable(R.drawable.list)

//                            list.setImageDrawable();
                } else {
                    layoutManager?.spanCount = 1
                    item.title = "grid"
//                        item.icon=  icongrid
                    item.icon = getDrawable(R.drawable.icongrid)

                }
                rcList.adapter?.notifyItemRangeChanged(0, rcList.adapter?.itemCount ?: 0)
            }

        }
        return super.onOptionsItemSelected(item)
    }
    ///////////////////////////////////////////////


//    private var titlesList = mutableListOf<String>()
//    private var detailsList = mutableListOf<String>()
//    private var imageList = mutableListOf<Int>()
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_list_restaurant)
//        postToList()
//
//        layoutManager = GridLayoutManager(this, 1)
//        list_resraurant.layoutManager = layoutManager
//
//        list_resraurant.adapter =
//            RecyclerAdapter(layoutManager as GridLayoutManager, titlesList, detailsList, imageList)
//
//
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.nav_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when (item?.itemId) {
//            R.id.menu1 -> {
//                if (layoutManager?.spanCount == 1) {
//                    layoutManager?.spanCount = 3
//                    item.title = "list"
//                    item.icon=getDrawable(R.drawable.list)
//
////                            list.setImageDrawable();
//                } else {
//                    layoutManager?.spanCount = 1
//                    item.title = "grid"
////                        item.icon=  icongrid
//                    item.icon=getDrawable(R.drawable.icongrid)
//
//                }
//                list_resraurant.adapter?.notifyItemRangeChanged(0, list_resraurant.adapter?.itemCount ?: 0)
//            }
//
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    private fun addToList(title: String, detail: String, image: Int) {
//        titlesList.add(title)
//        detailsList.add(detail)
//        imageList.add(image)
//
//    }
////
//    private fun postToList() {
//        val a=getDataSet()
//
//        for (i in 0..19) {
//
//
//            addToList( a[i].name.toString(),  a[i].address.toString(), R.mipmap.ic_launcher)
//
//        }
//    }
}