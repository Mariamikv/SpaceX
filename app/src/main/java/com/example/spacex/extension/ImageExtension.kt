package com.example.spacex.extension

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.spacex.R

fun ImageView.setImageUrl(url: Uri?){
    if(url != null){
        Glide.with(context).load(url)
            .placeholder(R.drawable.capture)
            .into(this)
    }else{
        setImageResource(R.drawable.capture)
    }

}