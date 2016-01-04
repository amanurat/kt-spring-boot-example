package com.rtsup.data2;

import com.rtsup.data.RoomStatus;
import org.springframework.data.annotation.Id;

public class Room {

    @Id
    private String id;

    private String name;
    private String description;
    private String address;
    private String userLockId;
    private RoomStatus status;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public String getUserLockId() {
        return userLockId;
    }

    public void setUserLockId(String userLockId) {
        this.userLockId = userLockId;
    }

    public String getId() {
        return id;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
