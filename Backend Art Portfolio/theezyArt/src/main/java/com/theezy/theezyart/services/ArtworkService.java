package com.theezy.theezyart.services;

import com.theezy.theezyart.data.model.Artwork;
import com.theezy.theezyart.dto.request.SaveArtworkRequest;
import com.theezy.theezyart.dto.response.DeleteArtworkResponse;
import com.theezy.theezyart.dto.response.SaveArtworkResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtworkService {

    SaveArtworkResponse saveArtwork(SaveArtworkRequest saveArtworkRequest);
    DeleteArtworkResponse deleteArtwork(String title);
    List<Artwork> getAllArtworks();

}
