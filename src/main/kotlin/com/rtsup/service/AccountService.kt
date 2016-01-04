package com.rtsup.service

import com.rtsup.data.Account

interface AccountService {

    fun registerNewAccount(acc: Account): Account
}