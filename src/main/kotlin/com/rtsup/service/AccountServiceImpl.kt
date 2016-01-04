package com.rtsup.service

import com.rtsup.data.Account
import com.rtsup.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open public class AccountServiceImpl : AccountService {

    @Autowired
    lateinit var accountRepository: AccountRepository

    override public fun registerNewAccount(acc: Account): Account {
        val oldAcc = accountRepository.findByName(acc.name)
        if (oldAcc == null) {
            acc.id = null;
            return accountRepository.save(acc);
        } else {
            throw Exception("Account for name `${acc.name}` already exist")
        }

    }
}