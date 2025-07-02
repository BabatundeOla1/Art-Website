package com.theezy.theezyart.data.repositories;

import com.theezy.theezyart.data.model.Artwork;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtworkRepository extends MongoRepository<Artwork, String> {

}

