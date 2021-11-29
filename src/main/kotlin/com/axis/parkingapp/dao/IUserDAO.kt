package com.axis.parkingapp.dao

import com.axis.parkingapp.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserDAO :MongoRepository<User,Int>{
}
