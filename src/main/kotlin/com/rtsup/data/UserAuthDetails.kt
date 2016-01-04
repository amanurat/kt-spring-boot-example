package com.rtsup.data

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

open class UserAuthDetails(username: String?, password: String?, authorities: Set<GrantedAuthority>?) : User(username, password, authorities) {

}
