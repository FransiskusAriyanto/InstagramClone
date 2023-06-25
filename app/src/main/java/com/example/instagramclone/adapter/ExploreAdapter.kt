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

class ExploreAdapter(private val dataset: ArrayList<MyModel>, private val context: Context) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    inner class ExploreViewHolder(itemView : ListExploreBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        val ohId = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8"
        fun bind(myModel: MyModel) {
            with(binding) {
                Glide.with(itemView).load(myModel.image).into(imageExplore)

                cvExplore.setOnClickListener {
                    var i = Intent(context, DetailMainActivity::class.java).apply {
                        putExtra("id", myModel.id)
                    }
                    context.startActivity(i)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        return ExploreViewHolder(ListExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bind(dataset[position])
    }
}