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
import kotlinx.android.synthetic.main.activity_list_restaurant.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class listRestaurant : AppCompatActivity() {
    private lateinit var binding: ActivityListRestaurantBinding
    private lateinit var viewModel: RestaurantViewModel
    private var layoutManager: GridLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title="menu Restaurants"

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_restaurant)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        layoutManager = GridLayoutManager(this, 1)
        rcList.layoutManager = layoutManager

        rcList.adapter =RestaurantAdapter(layoutManager as GridLayoutManager)

        val restaurantsList: ArrayList<Restaurant> = ArrayList()
        try {
            // As we have JSON object, so we are getting the object
            //Here we are calling a Method which is returning the JSON object
            val obj = JSONObject(getJSONFromAssets()!!)
            // fetch JSONArray named restaurants by using getJSONArray
            val restaurantsArray = obj.getJSONArray("restaurants")
            // Get the restaurants data using for loop i.e. id, name, email and so on

            for (i in 0 until restaurantsArray.length()) {
                // Create a JSONObject for fetching single restaurant's Data
                val restaurant = restaurantsArray.getJSONObject(i)
                // Fetch id,name,address,picturepath store it in variables
                val id = restaurant.getInt("Id")
                val name = restaurant.getString("Name")
                val address=restaurant.getString("Address")
                val picturepath = restaurant.getString("PicturePath")
                // Now add all the variables to the data model class and the data model class to the array list.
                val restaurantDetails =
                    Restaurant(id, name,address,picturepath)
                // add the details in the list
                restaurantsList.add(restaurantDetails)
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }
        val adapter = RestaurantAdapter();
        binding.rcList.adapter = adapter
        adapter.submitList(restaurantsList)
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
                    item.icon = getDrawable(R.drawable.listicon)

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
    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myRestaurantsJSONFILE = assets.open("Restaurants.json")
            val size = myRestaurantsJSONFILE.available()
            val buffer = ByteArray(size)
            myRestaurantsJSONFILE.read(buffer)
            myRestaurantsJSONFILE.close()
            json = String(buffer, charset)

        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
