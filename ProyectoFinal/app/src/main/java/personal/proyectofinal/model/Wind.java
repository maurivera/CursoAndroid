package personal.proyectofinal.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RIVARA on 12/08/2016.
 */

public class Wind implements Parcelable {

    public static final Creator<Wind> CREATOR = new Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };

    @SerializedName("speed")
    @Expose
    private Double speed;
    @SerializedName("deg")
    @Expose
    private Double deg;

    protected Wind(Parcel in) {
        speed = in.readDouble();
        deg = in.readDouble();
    }

    /**
     * @return The speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * @param speed The speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * @return The deg
     */
    public Double getDeg() {
        return deg;
    }

    /**
     * @param deg The deg
     */
    public void setDeg(Double deg) {
        this.deg = deg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(speed);
        parcel.writeDouble(deg);
    }
}
