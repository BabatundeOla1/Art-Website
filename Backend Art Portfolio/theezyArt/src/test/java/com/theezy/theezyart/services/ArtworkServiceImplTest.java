package com.theezy.theezyart.services;

import com.theezy.theezyart.data.model.Artwork;
import com.theezy.theezyart.data.repositories.ArtworkRepository;
import com.theezy.theezyart.dto.request.SaveArtworkRequest;
import com.theezy.theezyart.dto.response.SaveArtworkResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArtworkServiceImplTest {

    @Autowired
    private ArtworkService artworkService;

    @Autowired
    private ArtworkRepository artworkRepository;

    @BeforeEach
    void clearArtworkDatabase(){
        artworkRepository.deleteAll();
    }

    @Test
    void testThatYouCanSaveAnArtwork() {
        SaveArtworkRequest saveArtworkRequest = new SaveArtworkRequest();
        saveArtworkRequest.setYear(2025);
        saveArtworkRequest.setMedium("Acrylic on Canvas");
        saveArtworkRequest.setImagePath("C:\\Users\\DELL USER\\Pictures\\my works\\A Guide To life_grid2.png");
        saveArtworkRequest.setTitle("Memories");
        saveArtworkRequest.setSize("70cm by 70cm");

        SaveArtworkResponse savedResponse = artworkService.saveArtwork(saveArtworkRequest);

        assertEquals("Memories", savedResponse.getTitle());
        assertEquals("70cm by 70cm", savedResponse.getSize());
        assertThat(savedResponse).isNotNull();
        assertThat(savedResponse.getImageUrl()).isNotEmpty();
        assertEquals(1, artworkRepository.count());
        System.out.println(savedResponse.getImageUrl());
    }
}