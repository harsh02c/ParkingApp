package com.axis.parkingapp.service

import com.axis.parkingapp.model.Booking
import com.axis.parkingapp.model.Parking

interface IBookingService {
    fun addBooking(booking: Booking): Any?
    fun getAllBooking(): MutableList<Booking?>
}