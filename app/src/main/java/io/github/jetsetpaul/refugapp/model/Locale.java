package io.github.jetsetpaul.refugapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pauljoiner on 7/9/17.
 */

public class Locale {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private  String country;
    @SerializedName("geocoordinates")
    private String geocoordinates;

    public Locale(String name, String country, String geocoordinates){
        this.name = name;
        this.country = country;
        this.geocoordinates = geocoordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeocoordinates() {
        return geocoordinates;
    }

    public void setGeocoordinates(String geocoordinates) {
        this.geocoordinates = geocoordinates;
    }
}
