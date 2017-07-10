package io.github.jetsetpaul.refugapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pauljoiner on 7/9/17.
 */

public class Locale {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private  String country;
    @SerializedName("geocoordinates")
    @Expose
    private String geocoordinates;
}
