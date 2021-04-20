package com.example.baitaptuan1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemrestaurants.view.*

class RecyclerAdapter(private val layoutManager: GridLayoutManager? = null,
                      private var titles: List<String>,
                      private var details: List<String>,
                      private var image: List<Int>
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    enum class ViewType {
        SMALL,
        DETAILED
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitles: TextView = itemView.itemTitle
        val itemDetail: TextView = itemView.itemDetail
        val itemImage: ImageView? = itemView.itemImage

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You clicked on item # ${position + 1}",
                    Toast.LENGTH_LONG
                ).show()

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val v: View=LayoutInflater.from(parent.context).inflate(R.layout.itemrestaurants,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitles.text=titles[position]
        holder.itemDetail.text=details[position]
        holder.itemImage?.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    override fun getItemViewType(position: Int): Int {
        return if (layoutManager?.spanCount == 1) ViewType.DETAILED.ordinal
        else ViewType.SMALL.ordinal
    }

}