package com.pankti.webservicewithretrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pankti.webservicewithretrofit.R
import com.pankti.webservicewithretrofit.databinding.ListItemPostBinding
import com.pankti.webservicewithretrofit.domain.entities.PostDataModel

class PostListAdapter(var postList: ArrayList<PostDataModel>) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ListItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.list_item_post,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList)
    }

    override fun getItemCount(): Int  = postList.size

    class ViewHolder(val binding: ListItemPostBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(postList: ArrayList<PostDataModel>) {
            binding.tvTitle.text = postList[adapterPosition].title
            binding.tvDescription.text = postList[adapterPosition].description


            if (adapterPosition == (postList.size-1)) binding.viewline.visibility = View.GONE
            else binding.viewline.visibility = View.VISIBLE
        }
    }

}