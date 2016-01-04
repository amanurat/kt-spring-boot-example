package com.rtsup.data

import org.springframework.data.annotation.Id

public class Account(@Id var id: String?,
                     var name: String,
                     var password: String,
                     var roles: List<String>,
                     var active: Boolean = true) {

    // Add default constructor. Account created, but field id is empty
    //constructor() : this("", "", "", listOf(), true)
}