package com.axis.parkingapp.controller

import com.axis.parkingapp.model.Booking
import com.axis.parkingapp.model.Parking
import com.axis.parkingapp.service.IBookingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("parking")
class BookingController {
    @Autowired
    private lateinit var iBookingService: IBookingService
    @PostMapping("/addBooking")
    fun addBooking(@RequestBody booking: Booking ): ResponseEntity<Any?> {
        var addBooking = iBookingService.addBooking(booking)
        return ResponseEntity(addBooking, HttpStatus.OK)
    }

    @GetMapping("/getAllBooking")
    fun getAllBooking():ResponseEntity<MutableList<Booking?>>
    {
        var bookinglist = iBookingService.getAllBooking()
        return ResponseEntity(bookinglist,HttpStatus.OK)
    }


}