package com.rtsup.api

import com.rtsup.data.Account
import com.rtsup.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController {

    @Autowired
    lateinit var accountService: AccountService

    @RequestMapping(value = "/accounts/register", method = arrayOf(RequestMethod.POST))
    fun registerNew(@RequestBody acc: Account): Account {
        return accountService.registerNewAccount(acc)
    }
}