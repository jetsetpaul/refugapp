package io.github.jetsetpaul.refugapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pauljoiner on 7/10/17.
 */

public class AirTableClient {
    public static final String BASE_URL = "https://api.airtable.com/v0/appM5n8ocv9GexBFR/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
