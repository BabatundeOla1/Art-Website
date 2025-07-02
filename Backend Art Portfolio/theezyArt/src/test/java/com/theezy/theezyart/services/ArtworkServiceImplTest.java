package com.theezy.theezyart.services;

import com.theezy.theezyart.data.model.Artwork;
import com.theezy.theezyart.data.repositories.ArtworkRepository;
import com.theezy.theezyart.dto.request.SaveArtworkRequest;
import com.theezy.theezyart.dto.response.DeleteArtworkResponse;
import com.theezy.theezyart.dto.response.SaveArtworkResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@SpringBootTest
class ArtworkServiceImplTest {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);


    @Autowired
    private ArtworkService artworkService;

    @Autowired
    private ArtworkRepository artworkRepository;

    @BeforeEach
    void clearArtworkDatabase(){
        artworkRepository.deleteAll();
    }

    void setUpArtwork(SaveArtworkRequest saveArtworkRequest){
        saveArtworkRequest.setYear(2025);
        saveArtworkRequest.setMedium("Acrylic on Canvas");
        saveArtworkRequest.setImagePath("C:\\Users\\DELL USER\\Pictures\\my works\\A Guide To life_grid2.png");
        saveArtworkRequest.setTitle("Memories");
        saveArtworkRequest.setSize("70cm by 70cm");
    }
    void setUpSecondArtwork(SaveArtworkRequest secondArtwork){
        secondArtwork.setYear(2025);
        secondArtwork.setMedium("Acrylic on Canvas");
        secondArtwork.setImagePath("C:\\Users\\DELL USER\\Pictures\\my works\\Pinterest\\download (1).jpg");
        secondArtwork.setTitle("Moment of reflection");
        secondArtwork.setSize("40cm by 70cm");
    }

    @Test
    void testThatArtworkCanBeSaved() {
        SaveArtworkRequest saveArtworkRequest = new SaveArtworkRequest();
        setUpArtwork(saveArtworkRequest);

        SaveArtworkResponse savedResponse = artworkService.saveArtwork(saveArtworkRequest);

        assertEquals("Memories", savedResponse.getTitle());
        assertEquals("70cm by 70cm", savedResponse.getSize());
        assertThat(savedResponse).isNotNull();
        assertThat(savedResponse.getImageUrl()).isNotEmpty();
        assertEquals(1, artworkRepository.count());
        System.out.println(savedResponse.getImageUrl());
    }

    @Test
    void TestThatArtworkCanBeDeleted(){
        SaveArtworkRequest saveArtworkRequest = new SaveArtworkRequest();
        setUpArtwork(saveArtworkRequest);

        SaveArtworkResponse savedResponse = artworkService.saveArtwork(saveArtworkRequest);

        assertThat(savedResponse).isNotNull();
        assertEquals(1, artworkRepository.count());

        DeleteArtworkResponse deletedArtwork = artworkService.deleteArtwork(saveArtworkRequest.getTitle());
        assertEquals(0, artworkRepository.count());
        assertThat(deletedArtwork).isNotNull();
    }

    @Test
    void testThatListOfArtworksCanBeViewed(){
        SaveArtworkRequest firstArtworkRequest = new SaveArtworkRequest();
        setUpArtwork(firstArtworkRequest);
        SaveArtworkResponse firstResponse = artworkService.saveArtwork(firstArtworkRequest);

        SaveArtworkRequest secondArtworkRequest = new SaveArtworkRequest();
        setUpSecondArtwork(secondArtworkRequest);
        SaveArtworkResponse secondResponse = artworkService.saveArtwork(secondArtworkRequest);

        assertNotNull(firstResponse);
        assertNotNull(secondResponse);
        assertThat(firstArtworkRequest).isNotNull();
        assertThat(secondResponse).isNotNull();
        assertEquals(2, artworkRepository.count());

        List<Artwork> allArtworks = artworkService.getAllArtworks();
        assertEquals(2, allArtworks.size());
        assertTrue(allArtworks.stream().anyMatch(art -> art.getTitle().equals(firstArtworkRequest.getTitle())));
        assertTrue(allArtworks.stream().anyMatch(art -> art.getTitle().equals(secondArtworkRequest.getTitle())));

        try {
            String json = objectMapper.writeValueAsString(allArtworks);
            System.out.println("All artworks in JSON:\n" + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}