package com.axis.parkingapp.controller

import com.axis.parkingapp.model.Parking
import com.axis.parkingapp.service.IParkingService
import org.bson.types.ObjectId
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import javax.validation.Valid

@CrossOrigin
@RestController
@RequestMapping("/parking")
class ParkingController {
    @Autowired
    private lateinit var iParkingService: IParkingService

    private var root: Path = Paths.get("parkingapp/uploads")

    @PostMapping("/addParking")
    fun addParking(@RequestBody @Valid parking: Parking,  bindingResult:BindingResult):ResponseEntity<Any?>{
//        Parking(_id=null, name=Test Parking, address=Test address, country=India, state=Maharashtra, city=Nashik, price=5000.0, images=null, totalslots=15, availableslots=15, user=User(_id=61adbb07ea1b48376588620b, name=test, mobileNo=123123123, email=test8@gmail.com, password=12))

//    fun addParking(@RequestParam(required=false,name="postData")  parking: Any, @RequestParam("file")  file: MultipartFile):ResponseEntity<Any?>{

        //Code to create folder START
//        try {
////            Files.createDirectory(root)
//        } catch (e: IOException) {
//            throw RuntimeException("Could not initialize folder for upload!")
//        }
        //Code to create folder END

//        if (bindingResult.hasErrors()) {
//            val errors = bindingResult.fieldErrors
//            val errorList: MutableList<String?> = ArrayList()
//            for (f in errors) {
//                errorList.add(f.defaultMessage)
//            }
//            return ResponseEntity(errorList, HttpStatus.OK)
//        }

        //Upload file code START
//        try {
//            Files.copy(file.inputStream, this.root.resolve(file.originalFilename))
//
//        } catch (e: Exception) {
//            println(e)
//            throw RuntimeException("Could not store the file. Error: " + e.message)
//        }
        //Upload file code END
        var addParking = iParkingService.addParking(parking)
        return ResponseEntity(addParking, HttpStatus.OK)
    }


    @PostMapping("/getAllParking")
    fun getAllParking(@RequestBody parking: Parking):ResponseEntity<MutableList<Parking?>>
    {

        var parkinglist = iParkingService.getAllParking(parking)

        return ResponseEntity(parkinglist,HttpStatus.OK)
    }

    @PostMapping("/getUserParking/{id}")
    fun getUserParking(@PathVariable id:ObjectId): ResponseEntity<MutableList<Parking?>>
    {
        var parkinglist = iParkingService.getUserParking(id)
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
