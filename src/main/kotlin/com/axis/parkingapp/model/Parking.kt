package com.axis.parkingapp.model

import org.bson.types.ObjectId
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Document(collection = "parking")
data class Parking(
        @Id
        var _id:String?=null,
        @field:NotBlank(message = "Name field is mandatory")
        var name:String?=null,
        @field:NotBlank(message = "Address field is mandatory")
        var address:String?=null,
        @field:NotBlank(message = "Country field is mandatory")
        var country:String?=null,
        @field:NotBlank(message = "State field is mandatory")
        var state:String?=null,
        @field:NotBlank(message = "City field is mandatory")
        var city:String?=null,
        var price:Float?=null,
        var images:String?=null,
        var totalslots:Int?=0,
        var availableslots:Int?=0,
        @DocumentReference
        var user: User?=null
)