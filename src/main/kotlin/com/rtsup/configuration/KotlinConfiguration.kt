package com.rtsup.configuration

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class KotlinConfiguration {

    @Bean
    open public fun kotlinModule(): KotlinModule {
        return KotlinModule()
    }

    /*@Bean
    open public fun jacksonBuilder(): Jackson2ObjectMapperBuilder {
        return Jackson2ObjectMapperBuilder()
                .findModulesViaServiceLoader(true)
    }*/

}