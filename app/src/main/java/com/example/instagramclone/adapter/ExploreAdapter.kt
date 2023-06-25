package com.example.instagramclone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.DetailMainActivity
import com.example.instagramclone.databinding.ListExploreBinding
import com.example.instagramclone.model.MyModel

class ExploreAdapter(private val dataset: ArrayList<MyModel>, private val context: Context) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    inner class ExploreViewHolder(itemView: ListExploreBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(myModel: MyModel) {
            with(binding) {
                Glide.with(itemView).load(myModel.image).into(imageExplore)

                cvExplore.setOnClickListener {
                    var charHouse = Intent(context, DetailMainActivity::class.java).apply {
                        putExtra("house", myModel.house)
                    }
                    context.startActivity(charHouse)
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        return ExploreViewHolder(
            ListExploreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bind(dataset[position])
    }
}