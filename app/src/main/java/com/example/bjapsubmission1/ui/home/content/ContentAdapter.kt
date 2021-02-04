package com.example.bjapsubmission1.ui.home.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bjapsubmission1.R
import com.example.bjapsubmission1.model.DataModel
import kotlinx.android.synthetic.main.activity_detail.view.img_poster
import kotlinx.android.synthetic.main.item_list.view.*

class ContentAdapter (private val callback: ContentCallback) : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    private val listData = ArrayList<DataModel>()

    fun setListData(list: List<DataModel>) {
        listData.clear()
        listData.addAll(list)
    }

    inner class ContentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataModel) {
            with(itemView) {
                Glide.with(context)
                    .load(data.imgPoster)
                    .into(img_poster)
//                tv_title.text = data.title

                item_list.setOnClickListener { callback.onItemClicked(data) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContentViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}