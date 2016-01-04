package com.rtsup.configuration

import com.rtsup.data.Peer
import com.rtsup.data.Room
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

@Configuration
open class DataRepositoryConfig : RepositoryRestMvcConfiguration() {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        config?.exposeIdsFor(Room::class.java)
    }
}