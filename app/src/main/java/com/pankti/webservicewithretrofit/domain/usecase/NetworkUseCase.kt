package com.pankti.webservicewithretrofit.domain.usecase

import com.pankti.webservicewithretrofit.domain.entities.PostDataModel
import com.pankti.webservicewithretrofit.domain.repo.NetworkDataRepository
import kotlinx.coroutines.flow.Flow


class NetworkUseCase(var repo: NetworkDataRepository) {
    suspend fun getPosts(): Flow<List<PostDataModel>> = repo.getPosts()
    suspend fun getPost(id: String): Flow<PostDataModel> = repo.getPost(id)

}