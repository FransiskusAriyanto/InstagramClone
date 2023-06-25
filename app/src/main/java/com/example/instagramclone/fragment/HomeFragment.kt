package com.example.instagramclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagramclone.adapter.PostAdapter
import com.example.instagramclone.adapter.StoryAdapter
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.model.MyModel
import com.example.instagramclone.service.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val list = ArrayList<MyModel>()
    lateinit var postAdapter: PostAdapter
    lateinit var storyAdapter: StoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPost.setHasFixedSize(true)
        binding.rvPost.layoutManager = LinearLayoutManager(context)

        Repository.instances.gelAllData().enqueue(object : Callback<List<MyModel>>{
            override fun onResponse(call: Call<List<MyModel>>, response: Response<List<MyModel>>) {
                response.body()?.let { list.addAll(it) }
                postAdapter = PostAdapter(list)
                binding.rvPost.adapter = postAdapter

                response.body()?.let { list.addAll(it) }
                storyAdapter = StoryAdapter(list)
                binding.rvStory.adapter = storyAdapter
            }

            override fun onFailure(call: Call<List<MyModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}