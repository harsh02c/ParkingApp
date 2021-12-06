package com.axis.parkingapp.service

import com.axis.parkingapp.model.Parking
import java.util.*

interface IParkingService {
    //    fun addParking(parking: Parking):Parking?
    fun addParking(parking: Parking):Any?
    fun getAllParking(parking:Parking): MutableList<Parking?>
    fun getParkingById(Id: String): Optional<Parking?>
    fun updateParking(id: String, parking:Parking):Any?
    fun deleteParking(id: String):String
}