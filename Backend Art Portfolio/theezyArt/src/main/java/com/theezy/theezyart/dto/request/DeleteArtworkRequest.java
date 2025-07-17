package com.theezy.theezyart.dto.request;

import lombok.Data;

@Data
public class DeleteArtworkRequest {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
