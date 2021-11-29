package com.axis.parkingapp.model

import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document(collection = "parking")
data class Parking(
        @Id
        var _id:Int,
        var name:String,
        var address:String,
        var country:String,
        var state:String,
        var city:String,
        var price:Float,
        var totalslots:Int,
        var availableslots:Int,
        @DocumentReference
        var user: User?
)