package com.rtsup.repository

//Change to `data2` package
import com.rtsup.data2.Room
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
interface RoomRepository : MongoRepository<Room, String> {}