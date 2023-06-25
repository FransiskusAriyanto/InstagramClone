package com.example.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.databinding.ListStoryBinding
import com.example.instagramclone.model.MyModel

class StoryAdapter(private val dataset: ArrayList<MyModel>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    inner class StoryViewHolder(itemView: ListStoryBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(myModel: MyModel) {
            with(binding) {
                Glide.with(itemView).load(myModel.image).into(profileImageStory)
                listAccountStory.text = myModel.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(
            ListStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(dataset[position])
    }
}