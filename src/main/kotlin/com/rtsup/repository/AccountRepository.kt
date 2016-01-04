package com.rtsup.repository

import com.rtsup.data.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
interface AccountRepository : MongoRepository<Account, String> {

    fun findByName(name: String): Account?
}