package personal.proyectofinal.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RIVARA on 12/08/2016.
 */

public class Coord implements Parcelable {

    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;

    /**
     *
     * @return
     *     The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     *     The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     *
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
