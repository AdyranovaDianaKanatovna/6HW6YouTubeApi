package com.example.a6hw6youtubeapi.remote

import com.example.a6hw6youtubeapi.model.Playlist
import com.example.a6hw6youtubeapi.model.PlaylistItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {

    @GET("playlists")
    suspend fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResult: String,
        @Query("key") apiKey: String
    ): Response<Playlist>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("part") part: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResults: String,
        @Query("playlistId") playlistId: String
    ): Response<PlaylistItems>
}