package com.rtsup.configuration

import com.rtsup.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
@EnableWebSecurity
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        // @formatter:off
        http
            .authorizeRequests()
                //.antMatchers("/", "/home").permitAll()
                //.anyRequest().authenticated()
                .anyRequest().permitAll()
            .and()
                .formLogin().loginPage("/login").permitAll()
            .and()
                .logout().permitAll()
            .and()
                .csrf().disable();
        // @formatter:on
    }
}

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
open class AuthenticationSecurity : GlobalAuthenticationConfigurerAdapter() {

    @Autowired
    private lateinit var userService: AccountDetailsService

    override fun init(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService)
    }

    @Bean
    public open fun getAuthProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userService)
        authProvider.setPasswordEncoder(BCryptPasswordEncoder(10))
        return authProvider
    }
}

@Service
open class AccountDetailsService : UserDetailsService {

    @Autowired
    private lateinit var accountRepository: AccountRepository

    override fun loadUserByUsername(username: String): UserDetails? {
        val account = accountRepository.findByName(username) ?: throw UsernameNotFoundException("Account with $username not found.")

        val authorities = HashSet<SimpleGrantedAuthority>()
        for (role in account.roles) {
            authorities.add(SimpleGrantedAuthority(role))
        }

        return User(account.name, account.password, authorities)
    }
}