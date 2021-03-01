package com.example.puppyadoption.base

import android.content.Context
import androidx.annotation.RawRes
import java.io.BufferedReader
import java.io.InputStreamReader

object BaseImageLocalService {

     fun  fromJsonRes(context: Context, @RawRes id: Int): BufferedReader {
        return getLocalJsonReader(context, id)
    }

    private fun getLocalJsonReader(context: Context, @RawRes id: Int): BufferedReader {
        return BufferedReader(InputStreamReader(context.resources.openRawResource(id)))
    }

}