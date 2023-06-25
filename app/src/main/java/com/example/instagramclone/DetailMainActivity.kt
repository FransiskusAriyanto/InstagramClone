package com.example.instagramclone

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.instagramclone.databinding.ActivityDetailMainBinding
import com.example.instagramclone.model.MyModel
import com.example.instagramclone.service.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMainBinding
    private var bundle: Bundle? = null
    private var dataId = MyModel()
    var imageUrl = "https://ik.imagekit.io/hpapi/harry.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle = intent.extras
        val id = bundle?.getString("id")

        Log.d(TAG, id.toString())

        Repository.instance.gelAllDetail(id).enqueue(object : Callback<MyModel> {
            override fun onResponse(call: Call<MyModel>, response: Response<MyModel>) {
                binding.accountNameTopDetail.text = response.body()?.name
                binding.accountNameBottomDetail.text = response.body()?.name
                binding.captionBottomDetail.text = response.body()?.actor

                Glide.with(this@DetailMainActivity).load(imageUrl).into(binding.imageDetail)
                Glide.with(this@DetailMainActivity).load(imageUrl).into(binding.profileImage)
            }

            override fun onFailure(call: Call<MyModel>, t: Throwable) {

            }


        })
    }
}