package io.github.jetsetpaul.refugapp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pauljoiner on 7/9/17.
 */

public class LocationsResponse {
    @SerializedName("records")
    List<Locale> locales;
    public LocationsResponse(){
        locales = new ArrayList<Locale>();
    }

    public static LocationsResponse parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        LocationsResponse locationsResponse = gson.fromJson(response, LocationsResponse.class);
        return locationsResponse;
    }
}
