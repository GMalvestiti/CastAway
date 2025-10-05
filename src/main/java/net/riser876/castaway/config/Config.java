package net.riser876.castaway.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {

    @Expose
    @SerializedName("enabled")
    public boolean ENABLED = true;

    @Expose
    @SerializedName("water_level")
    public int WATER_LEVEL = 1;

    @Expose
    @SerializedName("water_falling")
    public boolean WATER_FALLING = false;
}
