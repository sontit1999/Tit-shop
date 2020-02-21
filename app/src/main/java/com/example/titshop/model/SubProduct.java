package com.example.titshop.model;

public class SubProduct {
    private String name;
    private String imageUrl;
    private String price;
    private String description;
    private String type;
    private boolean isNew;
    private float rating;

    public SubProduct(String name, String imageUrl, String price, String description, String type, boolean isNew, float rating) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.type = type;
        this.isNew = isNew;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public boolean isNew() {
        return isNew;
    }

    public float getRating() {
        return rating;
    }
}
