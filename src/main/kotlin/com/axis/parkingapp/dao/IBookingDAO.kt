package com.axis.parkingapp.dao

import com.axis.parkingapp.model.Booking
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface IBookingDAO : MongoRepository<Booking, String> {
}