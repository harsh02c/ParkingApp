package com.axis.parkingapp.controller

import com.axis.parkingapp.model.Parking
import com.axis.parkingapp.service.IParkingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/parking")
class ParkingController {
    @Autowired
    private lateinit var iParkingService: IParkingService

    @PostMapping("/addParking")
    fun addParking(@RequestBody parking: Parking):ResponseEntity<Any?>{
        var addParking = iParkingService.addParking(parking)
        return ResponseEntity(addParking, HttpStatus.OK)
    }

    @GetMapping("/getAllParking")
    fun getAllParking():ResponseEntity<MutableList<Parking?>>
    {
        var parkinglist = iParkingService.getAllParking()
        return ResponseEntity(parkinglist,HttpStatus.OK)
    }

    @GetMapping("/getParkingById/{id}")
    fun getParkingById(@PathVariable id:Int):ResponseEntity<Optional<Parking?>>{
        var parkingDetails = iParkingService.getParkingById(id)
        return ResponseEntity(parkingDetails,HttpStatus.OK)
    }

    @Throws(Exception::class)
    @PutMapping("/updateParkingById/{id}")
    fun updateParking(@PathVariable id: Int,@RequestBody parking: Parking):ResponseEntity<Any?>
    {
        try {
            var updateParking=   iParkingService.updateParking(id,parking)
            return ResponseEntity(updateParking,HttpStatus.OK)
        }
        catch (e:Exception)
        {
            return ResponseEntity("no id found",HttpStatus.NOT_FOUND)
        }

    }

    @DeleteMapping("/deleteById/{id}")
    fun deleteParkingById(@PathVariable id: Int):ResponseEntity<String?>
    {
        var deleteParking = iParkingService.deleteParking(id)
        return ResponseEntity(deleteParking,HttpStatus.OK)
    }
}