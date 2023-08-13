package com.pankti.webservicewithretrofit.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pankti.webservicewithretrofit.R
import com.pankti.webservicewithretrofit.databinding.ActivityMainBinding
import com.pankti.webservicewithretrofit.domain.entities.NetworkDataViewModel
import com.pankti.webservicewithretrofit.domain.entities.PostDataModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private val viewModel : NetworkDataViewModel by viewModels()

    private var postList = arrayListOf<PostDataModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        observeData()
        setClickListeners()
    }

    private fun observeData() {
        viewModel.postList.observe(this) {
            postList.clear()
            postList.addAll(it)

            if (postList.isNotEmpty()){
                binding.rvUserData.visibility = View.VISIBLE
                setPostAdapter()
            }else{
                binding.rvUserData.visibility = View.GONE
                binding.ivNoDataFound.visibility = View.VISIBLE
            }
        }

        viewModel.isLoading.observe(this) {_isLoading ->
            if (_isLoading) binding.progressbar.visibility = View.VISIBLE
            else binding.progressbar.visibility = View.GONE
        }
    }

    private fun setPostAdapter() {
        val adapter = PostListAdapter(postList)
        binding.rvUserData.adapter = adapter
    }


    private fun setClickListeners() {
        binding.btnFetchPost.setOnClickListener { viewModel.getPost("1") }
        binding.btnFetchPosts.setOnClickListener { viewModel.getPosts() }
    }
}