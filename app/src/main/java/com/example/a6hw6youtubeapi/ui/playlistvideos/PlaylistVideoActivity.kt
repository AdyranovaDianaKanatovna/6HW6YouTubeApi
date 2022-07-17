package com.example.a6hw6youtubeapi.ui.playlistvideos

import androidx.lifecycle.ViewModelProvider
import com.example.a6hw6youtubeapi.core.BaseActivity
import com.example.a6hw6youtubeapi.databinding.ActivityPlaylistVidepsBinding
import com.example.a6hw6youtubeapi.extensions.gone
import com.example.a6hw6youtubeapi.extensions.visible
import com.example.a6hw6youtubeapi.model.Items

class PlaylistVideosActivity : BaseActivity<ActivityPlaylistVidepsBinding>() {

    private val viewModel by lazy { ViewModelProvider(this)[PlaylistItemsViewModel::class.java] }
    private var videos: ArrayList<Items>? = arrayListOf()
    private val playlistVideosAdaptor by lazy { videos?.let { PlaylistVideosAdapter(it) } }

    override fun inflateViewBinding(): ActivityPlaylistVidepsBinding {
        return ActivityPlaylistVidepsBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        val playlistId = intent.getStringExtra("id")
        binding.progressBar.visible()
        if (playlistId != null)
            viewModel.getPlaylistItems(playlistId).observe(this) { response ->
                if (response.isSuccessful && response.body() != null){
                    binding.progressBar.gone()
                    videos = response.body()?.items
                    binding.rvVideos.adapter = playlistVideosAdaptor
                    binding.tvPlaylistTitle.text = intent.getStringExtra("title")
                    binding.tvPlaylistDescription.text = intent.getStringExtra("description")
                }
            }
    }

    override fun checkInternet() {
    }

    override fun initClickListener() {
    }

    override fun setUI() {
    }
}