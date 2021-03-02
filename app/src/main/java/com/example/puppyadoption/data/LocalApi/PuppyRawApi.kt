package com.example.puppyadoption.data.LocalApi

import android.content.Context
import com.example.puppyadoption.R
import com.example.puppyadoption.base.BaseImageLocalService
import com.example.puppyadoption.model.PuppyData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


object PuppyRawApi {

    fun getPuppyRawApi(context: Context): List<PuppyData>? {
        val imageDataContent = BaseImageLocalService.fromJsonRes(context, R.raw.puppies)
        val imageList = imageDataContent.readText()
        val moshi: Moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, PuppyData::class.java)
        val adapter: JsonAdapter<List<PuppyData>> = moshi.adapter(listType)
        val movie = adapter.fromJson(imageList)
//        listOf(movie).get(1)
//        return adapter.fromJson(imageList)
        return movie
    }

    fun getPuppyDetail(context: Context, id: Int): PuppyData? {
        val imageDataContent = BaseImageLocalService.fromJsonRes(context, R.raw.puppies)
        val imageList = imageDataContent.readText()
        val moshi: Moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, PuppyData::class.java)
        val adapter: JsonAdapter<List<PuppyData>> = moshi.adapter(listType)
        val movie = adapter.fromJson(imageList)
//        return adapter.fromJson(imageList)
        return movie?.get(id)
    }

}
