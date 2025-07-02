package com.theezy.theezyart.services;

import com.theezy.theezyart.data.model.Artwork;
import com.theezy.theezyart.data.repositories.ArtworkRepository;
import com.theezy.theezyart.dto.request.SaveArtworkRequest;
import com.theezy.theezyart.dto.response.DeleteArtworkResponse;
import com.theezy.theezyart.dto.response.SaveArtworkResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArtworkServiceImpl implements ArtworkService{
    @Autowired
    private ArtworkRepository artworkRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public SaveArtworkResponse saveArtwork(SaveArtworkRequest saveArtworkRequest) {

        String imageUrl = cloudinaryService.uploadImage(saveArtworkRequest.getImagePath());
        saveArtworkRequest.setImageUrl(imageUrl);

        Artwork newArtwork = modelMapper.map(saveArtworkRequest, Artwork.class);
        Artwork savedArtwork = artworkRepository.save(newArtwork);
        return modelMapper.map(savedArtwork, SaveArtworkResponse.class);
    }

    @Override
    public DeleteArtworkResponse deleteArtwork(String title) {

       Artwork foundArtwork = artworkRepository.findArtworkByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Artwork not found"));

        cloudinaryService.deleteImage(foundArtwork.getImageUrl());
        artworkRepository.delete(foundArtwork);
        DeleteArtworkResponse response = new DeleteArtworkResponse();
        response.setMessage("'\" + title + \"' deleted successfully.");
        return response;
    }

    @Override
    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }
}
