package com.axis.parkingapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User (
        @Id
        var _id:Int,
        var name:String,
        var mobileNo:String,
        var email:String,
        var password:String

)