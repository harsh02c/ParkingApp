package com.axis.parkingapp.service

import com.axis.parkingapp.dao.IBookingDAO
import com.axis.parkingapp.dao.IParkingDAO
import com.axis.parkingapp.dao.IUserDAO
import com.axis.parkingapp.model.Booking
import com.axis.parkingapp.model.Parking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookingServiceImpl:IBookingService {
    @Autowired
    private lateinit var iBookingDAO: IBookingDAO
    @Autowired
    private lateinit var iParkingDAO: IParkingDAO
    @Autowired
    private lateinit var iUserDAO: IUserDAO

    override fun addBooking(booking: Booking): Any? {
        var getParking = iParkingDAO.findById(booking.parking!!._id.toString()).get()

        if(getParking.availableslots<=0){
            return "No slots available"
        }
        return if(!iParkingDAO.existsById(booking.parking!!._id.toString()))
        {
            "Parking with this id not found"
        }else if(!iUserDAO.existsById(booking.user!!._id.toString())){
            "User with this id not found"
        }else{
            iBookingDAO.save(booking)
            //Decrease count of available slots
            var acc = iParkingDAO.findById(booking.parking!!._id.toString()).get()
            acc.availableslots = acc.availableslots -1;
            iParkingDAO.save(acc)
        }
    }

    override fun getAllBooking(): MutableList<Booking?> {
        return iBookingDAO.findAll()
    }


}