package com.axis.parkingapp.service

import com.axis.parkingapp.model.Parking
import java.util.*

interface IParkingService {
    //    fun addParking(parking: Parking):Parking?
    fun addParking(parking: Parking):Any?
    fun getAllParking(): MutableList<Parking?>
    fun getParkingById(Id: Int): Optional<Parking?>
    fun updateParking(id:Int,parking:Parking):Any?
    fun deleteParking(id:Int):String
}