package com.example.mertkesgin.weatherapp.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageHelper : IImageProcess {

    private val mPicassoInstance = Picasso.get()

    override fun loadUrl(url: String, imageView: ImageView) {
        mPicassoInstance.load(url).into(imageView)
    }
}