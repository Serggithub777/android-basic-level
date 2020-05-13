package com.example.heraldic;

import java.io.Serializable;

public class Parcel implements Serializable {
    private int imageIndex;
    private String cityName;

    public Parcel(int imageIndex, String cityName) {
        this.imageIndex = imageIndex;
        this.cityName = cityName;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public String getCityName() {
        return cityName;
    }

}
