package io.github.jetsetpaul.refugapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pauljoiner on 7/9/17.
 */

public class LocationsResponse {
    @SerializedName("records")
    private List<Locale> locales;

    public List<Locale> getLocales(){return locales;}

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }
}
