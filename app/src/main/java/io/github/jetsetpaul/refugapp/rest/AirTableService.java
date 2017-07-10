package io.github.jetsetpaul.refugapp.rest;

import io.github.jetsetpaul.refugapp.model.LocationsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pauljoiner on 7/9/17.
 */

public interface AirTableService {
    @GET("appM5n8ocv9GexBFR/Locations?")
    public Call<LocationsResponse> listLocations();
}
