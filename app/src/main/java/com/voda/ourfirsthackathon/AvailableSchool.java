package com.voda.ourfirsthackathon;

public class AvailableSchool {

    private int price;
    private String name;
    private String location;
    private int image;

    public AvailableSchool(int price, String name, String location, int image) {
        this.price = price;
        this.name = name;
        this.location = location;
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImageurl() {
        return image;
    }

    public void setImageurl(String imageurl) {
        this.image = image;
    }
}
