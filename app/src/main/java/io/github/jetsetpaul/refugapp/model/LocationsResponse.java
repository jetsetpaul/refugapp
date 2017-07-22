package io.github.jetsetpaul.refugapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pauljoiner on 7/9/17.
 */

public class LocationsResponse {
    @SerializedName("records")
    private List<RecordContainer> records;


    public List<RecordContainer> getRecords(){return records;}

    public void setRecords (List<RecordContainer> records){this.records = records;}

}
