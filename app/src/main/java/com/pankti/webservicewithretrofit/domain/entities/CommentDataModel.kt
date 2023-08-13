package com.pankti.webservicewithretrofit.domain.entities

data class CommentDataModel(
    var postId:Int = 0,
    var id:Int = 0,
    var name:String = "",
    var email:String = "",
    var body:String = ""
)