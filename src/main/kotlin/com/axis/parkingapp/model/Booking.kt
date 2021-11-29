package com.axis.parkingapp.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import java.util.*

@Document(collection="booking")
data class Booking(
        @Id
        var _id:Int,
        @DocumentReference
        var user:User,
        @DocumentReference
        var parking:Parking,
        @JsonFormat(pattern="yyyy-MM-dd")
        var bookingStartTime:Date,
        var bookingEndTime:Date
)