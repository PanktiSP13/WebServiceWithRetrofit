package com.pankti.webservicewithretrofit.domain.repo

import com.pankti.webservicewithretrofit.domain.entities.PostDataModel
import kotlinx.coroutines.flow.Flow


interface NetworkDataRepository {
    suspend fun getPosts(): Flow<List<PostDataModel>>
    suspend fun getPost(id: String): Flow<PostDataModel>
}