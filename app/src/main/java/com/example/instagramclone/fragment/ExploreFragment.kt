package com.example.instagramclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instagramclone.adapter.ExploreAdapter
import com.example.instagramclone.databinding.FragmentExploreBinding
import com.example.instagramclone.model.MyModel
import com.example.instagramclone.service.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreFragment : Fragment() {
    private var _binding : FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<MyModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvExplore.setHasFixedSize(true)
        binding.rvExplore.layoutManager = GridLayoutManager(context, 2)

        Repository.instance.gelAllData().enqueue(object : Callback<List<MyModel>> {
            override fun onResponse(call: Call<List<MyModel>>, response: Response<List<MyModel>>) {
                response.body()?.let { list.addAll(it) }
                val exploreAdapter = ExploreAdapter(list, requireContext())
                binding.rvExplore.adapter = exploreAdapter
            }

            override fun onFailure(call: Call<List<MyModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}