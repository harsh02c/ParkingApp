package com.axis.parkingapp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.axis.parkingapp.dao.IParkingDAO
import com.axis.parkingapp.dao.IUserDAO
import com.axis.parkingapp.model.Parking
import org.bson.types.ObjectId
import org.springframework.data.domain.Sort
import java.util.*
import kotlin.jvm.Throws

@Service
class ParkingServiceImpl :IParkingService {

    @Autowired
    private lateinit var iParkingDAO: IParkingDAO
    @Autowired
    private lateinit var iUserDAO: IUserDAO


    override fun addParking(parking: Parking): Any? {
        return if(iUserDAO.existsById(parking.user!!._id.toString()))
        {
            iParkingDAO.save(parking)
        }else {
            "User with id not found"
        }
    }
    override fun getAllParking(parking: Parking): MutableList<Parking?> {
//        return iParkingDAO.findAll()

        return iParkingDAO.getAllParking(parking.name,parking.country,parking.state,parking.city,parking.address)
    }

    override fun getParkingById(Id: String): Optional<Parking?> {
        return iParkingDAO.findById(Id)
    }

    @Throws(Exception::class)
    override fun updateParking(id: String, parking: Parking): Any? {


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
            return if(iUserDAO.existsById(parking.user!!._id.toString()))
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

    override fun deleteParking(id: String): String {
        return if(iParkingDAO.existsById(id))
        {
            iParkingDAO.deleteById(id)
            "Parking id deleted"
        }
        else {
            "Parking with id $id not found"
        }
    }

    override fun getUserParking(id: ObjectId): MutableList<Parking?> {
        return iParkingDAO.getUserParking(id)
    }


}