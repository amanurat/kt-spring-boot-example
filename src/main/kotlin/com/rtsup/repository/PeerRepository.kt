package com.rtsup.repository

import com.rtsup.data.Peer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "peers", path = "peers")
interface PeerRepository : MongoRepository<Peer, String> {}