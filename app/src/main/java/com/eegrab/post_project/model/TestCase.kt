package com.eegrab.post_project.model

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName


private class TestCase {
    @SerializedName("test")
    private val field: String? = null


    var val1 = "[{test: \"test\"}]"

    val gsonBuilder = GsonBuilder()
    val gson = gsonBuilder.create()

    var testCase = gson.fromJson(val1, Array<TestCase>::class.java)
}