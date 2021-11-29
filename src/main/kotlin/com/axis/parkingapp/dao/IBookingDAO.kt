package com.axis.parkingapp.dao

import com.axis.parkingapp.model.Booking
import org.springframework.data.mongodb.repository.MongoRepository

interface IBookingDAO : MongoRepository<Booking,Int> {
}