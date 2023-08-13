package com.pankti.webservicewithretrofit.domain.entities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankti.webservicewithretrofit.domain.usecase.NetworkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkDataViewModel @Inject constructor(val useCase: NetworkUseCase) : ViewModel(){

    private var _postList = MutableLiveData<List<PostDataModel>>()
    var postList: LiveData<List<PostDataModel>> = _postList

    var errorMessage = MutableLiveData("")
    var isLoading = MutableLiveData(false)

    fun getPosts() {
        viewModelScope.launch {

            isLoading.value = true

            useCase.getPosts().catch { error ->
                errorMessage.value = error.message?:""
                isLoading.value = false
            }.collect {
                _postList.postValue(it)
                isLoading.value = false
            }
        }
    }

    fun getPost(id: String) {
        viewModelScope.launch {
            isLoading.value = true

            useCase.getPost(id).catch {error ->
                errorMessage.value = error.message?:""
                isLoading.value = false

            }.collect {
                _postList.postValue(arrayListOf(it))
                isLoading.value = false
            }
        }
    }

}