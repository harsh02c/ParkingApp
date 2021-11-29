package com.axis.parkingapp.dao

import com.axis.parkingapp.model.Parking
import org.springframework.data.mongodb.repository.MongoRepository

interface IParkingDAO :MongoRepository<Parking,Int> {
}