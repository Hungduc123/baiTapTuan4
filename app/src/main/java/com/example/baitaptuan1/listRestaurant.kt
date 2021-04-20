package com.example.baitaptuan1


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_list_restaurant.*


class listRestaurant : AppCompatActivity() {
    private var layoutManager: GridLayoutManager? = null
    private var titlesList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_restaurant)
        postToList()

       layoutManager = GridLayoutManager(this, 1)
        list_resraurant.layoutManager = layoutManager

        list_resraurant.adapter = RecyclerAdapter(layoutManager as GridLayoutManager,titlesList, detailsList, imageList)

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
                     item.icon=getDrawable(R.drawable.list)

//                            list.setImageDrawable();
                    } else {
                        layoutManager?.spanCount = 1
                        item.title = "grid"
//                        item.icon=  icongrid
                        item.icon=getDrawable(R.drawable.icongrid)

                    }
                    list_resraurant.adapter?.notifyItemRangeChanged(0, list_resraurant.adapter?.itemCount ?: 0)
                }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun addToList(title: String, detail: String, image: Int) {
        titlesList.add(title)
        detailsList.add(detail)
        imageList.add(image)

    }

    private fun postToList() {
        for (i in 1..25) {
            addToList("Title $i", "detail $i", R.mipmap.ic_launcher)

        }
    }
}