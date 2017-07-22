package io.github.jetsetpaul.refugapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.jetsetpaul.refugapp.R;
import io.github.jetsetpaul.refugapp.model.Locale;


/**
 * Created by pauljoiner on 7/10/17.
 */

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.MyViewHolder> {
    private List<Locale> localeList;
    private Context mContext;

    public LocationsAdapter(Context mContext, List<Locale> localeList) {
        this.mContext = mContext;
        this.localeList = localeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.locations_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LocationsAdapter.MyViewHolder viewHolder, int i) {
        String locationName = localeList.get(i).getName();
        String locationCountry = localeList.get(i).getCountry();
        viewHolder.name.setText(locationName);
        viewHolder.country.setText(locationCountry);

    }

    @Override
    public int getItemCount() {
        return localeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView country;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            country = (TextView) itemView.findViewById(R.id.country);
        }
    }
}
