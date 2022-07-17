package com.example.a6hw6youtubeapi.ui.playList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.a6hw6youtubeapi.R
import com.example.a6hw6youtubeapi.databinding.ItemPlaylistBinding
import com.example.a6hw6youtubeapi.extensions.load
import com.example.a6hw6youtubeapi.model.Items


class PlaylistAdaptor(private var playlist: ArrayList<Items>) : RecyclerView.Adapter<PlaylistAdaptor
.PlayListViewHolder>() {
    private lateinit var onItemClickListener: ItemClickListener

    fun setListener(listener: ItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder(
           ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount() = playlist.size


    inner class PlayListViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(items: Items) {
            binding.ivPlayList.load(items.snippet.thumbnails.medium.url)
            binding.tvPlaylistTitle.text = items.snippet.title
            binding.tvVideoCounter.text =
                itemView.context.getString(
                    R.string.video_series,
                    items.contentDetails.itemCount
                )
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(
                    items.id,
                    items.snippet.title,
                    items.snippet.description
                )

            }
        }
    }
}


interface ItemClickListener {
    fun onItemClick(id: String, title: String, description: String)
}

