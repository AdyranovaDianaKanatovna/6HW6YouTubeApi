package com.example.a6hw6youtubeapi.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}