package com.axis.parkingapp.dao

import com.axis.parkingapp.model.Parking
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.awt.Dialog
import java.util.*

interface IParkingDAO :MongoRepository<Parking,String> {
     override fun existsById(_id: String): Boolean

     @Query("{ 'name':  {\$regex: ?0 }, 'country': {\$regex: ?1 },'state': {\$regex: ?2 },'city': {\$regex: ?3 },'address': {\$regex: ?4 }}")
     fun getAllParking(name: String?, country: String?, state: String?, city: String?, address: String?): MutableList<Parking?>
}