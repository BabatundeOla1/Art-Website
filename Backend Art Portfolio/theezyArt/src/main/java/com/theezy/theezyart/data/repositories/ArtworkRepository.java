package com.theezy.theezyart.data.repositories;

import com.theezy.theezyart.data.model.Artwork;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArtworkRepository extends MongoRepository<Artwork, String> {
        Optional<Artwork> findArtworkByTitle(String title);
}

