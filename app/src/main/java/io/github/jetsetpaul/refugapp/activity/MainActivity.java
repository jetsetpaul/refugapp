package io.github.jetsetpaul.refugapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.jetsetpaul.refugapp.R;
import io.github.jetsetpaul.refugapp.adapter.LocationsAdapter;
import io.github.jetsetpaul.refugapp.model.Locale;
import io.github.jetsetpaul.refugapp.model.LocationsResponse;
import io.github.jetsetpaul.refugapp.model.RecordContainer;
import io.github.jetsetpaul.refugapp.rest.AirTableClient;
import io.github.jetsetpaul.refugapp.rest.AirTableService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY_HEADER = "Authorization: Bearer";
    private static final String AIR_TABLE_API_KEY = "keyn1HD5MV6hQCkkT";
    private RecyclerView recyclerView;
    private LocationsAdapter adapter;
    private List<Locale> localeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadJSON();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        localeList = new ArrayList<>();
        adapter = new LocationsAdapter(this, localeList);
        recyclerView.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();

    }

    private void loadJSON(){

        try{
            if (AIR_TABLE_API_KEY.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please obtain API Key first from airtable.com", Toast.LENGTH_SHORT).show();
                return;
            }

            AirTableClient Client = new AirTableClient();
            AirTableService apiService =
                    Client.getClient().create(AirTableService.class);
            Call<LocationsResponse> call = apiService.listLocations(AIR_TABLE_API_KEY);
            call.enqueue(new Callback<LocationsResponse>() {
                @Override
                public void onResponse(Call<LocationsResponse> call, Response<LocationsResponse> response) {
                    List<RecordContainer> records = response.body().getRecords();
                    for(int i = 0; i< records.size(); i++){
                        localeList.add(records.get(i).getLocale());
                    }
                    response.code();
                    recyclerView.setAdapter(new LocationsAdapter(getApplicationContext(), localeList));
                    recyclerView.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<LocationsResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();

                }
            });
        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
//    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//    logging.setLevel(Level.BASIC);
//    OkHttpClient client = new OkHttpClient.Builder()
//            .addInterceptor(logging)
//            .build();
}
