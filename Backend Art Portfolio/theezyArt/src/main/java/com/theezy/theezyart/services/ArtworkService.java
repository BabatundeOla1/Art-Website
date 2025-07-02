package com.theezy.theezyart.services;

import com.theezy.theezyart.dto.request.SaveArtworkRequest;
import com.theezy.theezyart.dto.response.SaveArtworkResponse;
import org.springframework.stereotype.Service;

@Service
public interface ArtworkService {

    SaveArtworkResponse saveArtwork(SaveArtworkRequest saveArtworkRequest);
//    List<Artwork> getAllArtworks();
//    Optional<Artwork> getArtworkById(String artworkId);

//    DeleteArtWorkResponse deleteArtwork(String artworkId);
}
