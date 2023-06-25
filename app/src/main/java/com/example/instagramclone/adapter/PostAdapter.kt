package com.example.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.databinding.ListPostBinding
import com.example.instagramclone.model.MyModel

class PostAdapter(private val dataset: ArrayList<MyModel>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: ListPostBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(myModel: MyModel) {
            with(binding) {
                Glide.with(itemView).load(myModel.image).into(imagePost)
                Glide.with(itemView).load(myModel.image).into(profileImage)

                accountNameTopPost.text = myModel.name
                accountNameBottomPost.text = myModel.name
                captionBottomPost.text = myModel.house
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ListPostBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(dataset[position])
    }
}