package io.github.jetsetpaul.refugapp.rest;

import io.github.jetsetpaul.refugapp.model.LocationsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pauljoiner on 7/9/17.
 */

public interface AirTableService {
    @GET("/v0/appM5n8ocv9GexBFR/Locations")
    Call<LocationsResponse> listLocations(@Query("api_key") String apiKey);

}
