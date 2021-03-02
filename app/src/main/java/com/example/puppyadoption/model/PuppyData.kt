package com.example.puppyadoption.model

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class PuppyData(
    var id: String? = null,
    var created: String? = null,
    var aboutme: String? = null,
    var hdurl: String? = null,
    var name: String? = null,
    var age: String? = null,
    var gender: String? = null,
    var weight: String? = null,
    var url: String? = null,
    var owner: String? = null,
    var place: String? = null
) : Serializable {
}