package com.axis.parkingapp.service

import com.axis.parkingapp.model.Parking
import org.bson.types.ObjectId
import java.util.*

interface IParkingService {
    //    fun addParking(parking: Parking):Parking?
    fun addParking(parking: Parking):Any?
    fun getAllParking(parking:Parking): MutableList<Parking?>
    fun getParkingById(id: String): Optional<Parking?>
    fun updateParking(id: String, parking:Parking):Any?
    fun deleteParking(id: String):String
    fun getUserParking(id: ObjectId): MutableList<Parking?>
}