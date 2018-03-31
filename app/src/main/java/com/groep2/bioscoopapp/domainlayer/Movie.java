package com.groep2.bioscoopapp.domainlayer;

import java.io.Serializable;

/**
 * Created by Kevin van Loon on 27-3-2018.
 */

public class Movie implements Serializable{
    private String title;
    private String smallImageUrl;
    private String bigImageUrl;
    private String description;

    public Movie( ){

    }

    public Movie(String title, String imageUrl, String bigImageUrl, String description) {
        this.title = title;
        this.smallImageUrl = imageUrl;
        this.bigImageUrl = bigImageUrl;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String imageUrl) {
        this.smallImageUrl = imageUrl;
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
