package com.example.dmsassignment.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dmsassignment.R
import com.example.dmsassignment.data.RepositoryInfo
import kotlinx.android.synthetic.main.repositories_item.view.*

class RepositoryAdapter(private val context : Context,private val list: List<RepositoryInfo>) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repositories_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size

    }



    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        private var view = v
        fun bind(item : RepositoryInfo){

            view.owner_name.text =item.owner.login
            view.repositories_name.text=item.name
            view.repositories_description.text=item.description
            view.repositories_language.text=item.language
            view.repositories_stargazers_count.text=item.stargazers_count.toString()
            Glide.with(context)
                .load(item.owner.avatar_url)
                .into(view.owner_profile_image)


        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])


    }
}