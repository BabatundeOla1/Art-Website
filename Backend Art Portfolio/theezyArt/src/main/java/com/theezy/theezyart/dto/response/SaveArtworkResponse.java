package com.theezy.theezyart.dto.response;


public class SaveArtworkResponse {

//    private String id;
    private String title;
    private String medium;
    private int year;
    private String size;

    private String cloudImageUrl;
    private String imagePath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imagePath;
    }

    public void setImageUrl(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCloudImageUrl() {
        return cloudImageUrl;
    }

    public void setCloudImageUrl(String cloudImageUrl) {
        this.cloudImageUrl = cloudImageUrl;
    }
}
