package com.axis.parkingapp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.axis.parkingapp.dao.IParkingDAO
import com.axis.parkingapp.model.Parking
import java.util.*
import kotlin.jvm.Throws

@Service
class ParkingServiceImpl :IParkingService {

    @Autowired
    private lateinit var iParkingDAO: IParkingDAO

    override fun addParking(parking: Parking): Any? {
        return if(iParkingDAO.existsById(parking.user!!._id))
        {
            iParkingDAO.save(parking)
        }else {
            "User with id not found"
        }
    }
    override fun getAllParking(): MutableList<Parking?> {
        return iParkingDAO.findAll()
    }

    override fun getParkingById(Id: Int): Optional<Parking?> {
        return iParkingDAO.findById(Id)
    }

    @Throws(Exception::class)
    override fun updateParking(id: Int, parking: Parking): Any? {

        return if(iParkingDAO.existsById(id)){
            var acc = iParkingDAO.findById(id).get()
            acc.name =  parking.name
            acc.address = parking.address
            acc.country = parking.country
            acc.city = parking.city
            acc.state = parking.state
            acc.price = parking.price
            acc.totalslots = parking.totalslots
            acc.availableslots = parking.availableslots
//            iParkingDAO.save(acc)
            return if(iParkingDAO.existsById(parking.user!!._id))
            {
                iParkingDAO.save(parking)
            }else {
                "User with id not found"
            }
        } else
        {
            throw Exception("parking id not found")
        }
    }

    override fun deleteParking(id: Int): String {
        return if(iParkingDAO.existsById(id))
        {
            iParkingDAO.deleteById(id)
            "Parking id deleted"
        }
        else {
            "Parking with id $id not found"
        }
    }


}