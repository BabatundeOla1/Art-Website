package com.theezy.theezyart.controller;

import com.theezy.theezyart.data.model.Artwork;
import com.theezy.theezyart.dto.request.DeleteArtworkRequest;
import com.theezy.theezyart.dto.request.SaveArtworkRequest;
import com.theezy.theezyart.dto.response.DeleteArtworkResponse;
import com.theezy.theezyart.dto.response.SaveArtworkResponse;
import com.theezy.theezyart.services.AdminService;
import com.theezy.theezyart.services.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin/")
@RestController
public class ArtworkController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ArtworkService artworkService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("saveArtwork")
    public ResponseEntity<SaveArtworkResponse> saveArtwork(@RequestBody SaveArtworkRequest saveArtworkRequest){
        SaveArtworkResponse response = artworkService.saveArtwork(saveArtworkRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("deleteArtwork")
    public ResponseEntity<DeleteArtworkResponse> deleteArtwork(@RequestParam String title){
        DeleteArtworkResponse deleteResponse = artworkService.deleteArtwork(title);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }
}
