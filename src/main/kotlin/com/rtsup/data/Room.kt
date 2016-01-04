package com.rtsup.data

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

// curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "Test2",  "address" : "Test Address",  "status": "busy" }' http://localhost:8080/rooms
public class Room(
        @Id var id: String?,
        var name: String,
        var address: String?,
        var description: String?,
        var userLockId: String?,
        var status: RoomStatus) {

}

public enum class RoomStatus() {
    @JsonProperty("free")
    FREE,
    @JsonProperty("busy")
    BUSY,
    @JsonProperty("inactive")
    INACTIVE
}
