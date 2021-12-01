package com.axis.parkingapp.dao

import com.axis.parkingapp.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface IUserDAO :MongoRepository<User,String>{
     override fun existsById(_id: String): Boolean
}
