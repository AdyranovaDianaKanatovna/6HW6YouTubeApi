package com.example.a6hw6youtubeapi.ui.playList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a6hw6youtubeapi.App
import com.example.a6hw6youtubeapi.model.Playlist
import retrofit2.Response

class PlayListViewModel: ViewModel() {

    fun getPlaylist(): LiveData<Response<Playlist>> {
        return App.repository.getPlaylists()
    }
}