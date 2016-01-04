package com.rtsup.data

import org.springframework.data.annotation.Id

data public class Peer(
        @Id var id: String?,
        var roomId: String,
        var peerId: String,
        var isAdmin: Boolean = false) {
}