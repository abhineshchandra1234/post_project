package com.eegrab.post_project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinesh.getretrofit.model.Post
import com.eegrab.post_project.model.Post1
import com.eegrab.post_project.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post1>> = MutableLiveData()



    fun pushPost3(code: String, type: String) {
        viewModelScope.launch {
            val response = repository.pushPost3(code, type)
            myResponse.value = response
        }
    }
}