package com.axis.parkingapp.controller

import com.axis.parkingapp.model.Parking
import com.axis.parkingapp.service.IParkingService
import com.axis.parkinglogin.dto.Message
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/parking")
class ParkingController {
    @Autowired
    private lateinit var iParkingService: IParkingService

    @PostMapping("/addParking")
    fun addParking(@RequestBody @Valid parking: Parking, bindingResult:BindingResult):ResponseEntity<Any?>{

        if (bindingResult.hasErrors()) {
            println("some error occured")
            val errors = bindingResult.fieldErrors
            val errorList: MutableList<String?> = ArrayList()
            for (f in errors) {
                errorList.add(f.defaultMessage)
            }
            return ResponseEntity(errorList, HttpStatus.OK)
        }
        var addParking = iParkingService.addParking(parking)
        return ResponseEntity(addParking, HttpStatus.OK)
    }

    @PostMapping("/getAllParking")
    fun getAllParking(@RequestBody   parking: Parking):ResponseEntity<MutableList<Parking?>>
    {

        var parkinglist = iParkingService.getAllParking(parking)
        return ResponseEntity(parkinglist,HttpStatus.OK)
    }

    @GetMapping("/getParkingById/{id}")
    fun getParkingById(@PathVariable id:String):ResponseEntity<Optional<Parking?>>{

        var parkingDetails = iParkingService.getParkingById(id)
        return ResponseEntity(parkingDetails,HttpStatus.OK)
    }

    @Throws(Exception::class)
    @PutMapping("/updateParkingById/{id}")
    fun updateParking(@PathVariable id: String, @RequestBody @Valid parking: Parking, bindingResult:BindingResult):ResponseEntity<Any?>
    {
        if (bindingResult.hasErrors()) {
            println("some error occured")
            val errors = bindingResult.fieldErrors
            val errorList: MutableList<String?> = ArrayList()
            for (f in errors) {
                errorList.add(f.defaultMessage)
            }
            return ResponseEntity(errorList, HttpStatus.OK)
        }
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
    fun deleteParkingById(@PathVariable id: String):ResponseEntity<String?>
    {
        var deleteParking = iParkingService.deleteParking(id)
        return ResponseEntity(deleteParking,HttpStatus.OK)
    }
}