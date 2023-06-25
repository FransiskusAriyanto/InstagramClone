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
    private var b: Bundle? = null
    var imageUrl = "https://ik.imagekit.io/hpapi/harry.jpg"
    var myId = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8"
    var name = "Harry Potter"
    var house = "Gryffindor"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        b = intent?.extras
        val i = b?.getString("id")
//        val id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8"

        Log.d(TAG, i.toString())
        Log.d("Log Bundle", b.toString())



        Repository.instances.getDetail(i).enqueue(object : Callback<MyModel> {
            override fun onResponse(call: Call<MyModel>, response: Response<MyModel>) {
//                binding.accountNameTopDetail.text = response.body()?.id
//                binding.accountNameBottomDetail.text = response.body()?.id
//                binding.captionBottomDetail.text = response.body()?.id

                binding.accountNameTopDetail.text = name
                binding.accountNameBottomDetail.text = name
                binding.captionBottomDetail.text = house

                Glide.with(this@DetailMainActivity).load(imageUrl).into(binding.imageDetail)
                Glide.with(this@DetailMainActivity).load(imageUrl).into(binding.profileImage)


            }

            override fun onFailure(call: Call<MyModel>, t: Throwable) {

            }

        })

    }
}