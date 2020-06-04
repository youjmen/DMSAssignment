package com.example.dmsassignment.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dmsassignment.R
import com.example.dmsassignment.data.FollowersInfo
import com.example.dmsassignment.data.RepositoryInfo
import kotlinx.android.synthetic.main.followers_item.view.*
import kotlinx.android.synthetic.main.repositories_item.view.*

class FollowersAdapter(private val context : Context, private val list: List<FollowersInfo>) : RecyclerView.Adapter<FollowersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.followers_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size

    }



    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        private var view = v
        fun bind(item : FollowersInfo){

            view.followers_name.text =item.id
            Glide.with(context)
                .load(item.avatar_url)
                .into(view.followers_profile_image)



        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])


    }
}