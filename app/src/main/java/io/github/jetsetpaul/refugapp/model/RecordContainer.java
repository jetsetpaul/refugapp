package io.github.jetsetpaul.refugapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pauljoiner on 7/17/17.
 */

public class RecordContainer {
    @SerializedName("fields")
    private Locale locale;

    public Locale getLocale(){return locale;}

    public void setLocale(Locale locale){
        this.locale = locale;
    }
}
