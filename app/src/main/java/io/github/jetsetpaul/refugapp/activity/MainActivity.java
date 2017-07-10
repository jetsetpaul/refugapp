package io.github.jetsetpaul.refugapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

import io.github.jetsetpaul.refugapp.R;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://api.airtable.com/v0/appM5n8ocv9GexBFR/";
    private static final String API_KEY_HEADER = "Authorization: Bearer";
    private static final String airTableApiKey = "keyn1HD5MV6hQCkkT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Interceptor provideHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader(API_KEY_HEADER, airTableApiKey)
                        .build();

                return chain.proceed(request);
            }
        };
    }



}
