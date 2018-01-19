package com.wipro.test.models;

import com.wipro.test.Utils;

/**
 * Created by Vishwajit on 19/01/18
 */

public class FactsModel {

    private String title;
    private String description;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isEmpty() {
        return Utils.isEmptyOrNull(title) && Utils.isEmptyOrNull(description) && Utils.isEmptyOrNull(imageUrl);
    }
}
