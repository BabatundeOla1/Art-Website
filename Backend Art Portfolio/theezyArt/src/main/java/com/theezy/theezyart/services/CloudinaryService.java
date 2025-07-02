package com.theezy.theezyart.services;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(@Value("${cloudinary.cloud-name}") String cloudName, @Value("${cloudinary.api-key}") String apiKey, @Value("${cloudinary.api-secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    public String uploadImage(String filePath) {
        try {
            File file = new File(filePath);
            Map<?, ?> response = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return response.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Upload to Cloudinary failed", e);
        }
    }

    public boolean deleteImage(String imageUrl) {
        try {
            String publicId = extractPublicId(imageUrl);
            Map<?, ?> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            return "ok".equals(result.get("result"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image from Cloudinary", e);
        }
    }

    private String extractPublicId(String url) {
        try {
            String[] parts = url.split("/");
            int uploadIndex = -1;

            for (int index = 0; index < parts.length; index++) {
                if (parts[index].equals("upload")) {
                    uploadIndex = index;
                    break;
                }
            }

            if (uploadIndex == -1 || uploadIndex + 2 >= parts.length) {
                throw new IllegalArgumentException("Invalid Cloudinary URL: " + url);
            }

            StringBuilder publicIdBuilder = new StringBuilder();
            for (int element = uploadIndex + 2; element < parts.length; element++) {
                publicIdBuilder.append(parts[element]);
                if (element < parts.length - 1) publicIdBuilder.append("/");
            }

            String publicIdWithExtension = publicIdBuilder.toString();
            int dotIndex = publicIdWithExtension.lastIndexOf('.');
            return (dotIndex == -1) ? publicIdWithExtension : publicIdWithExtension.substring(0, dotIndex);
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract public ID from Cloudinary URL", e);
        }
    }


}
