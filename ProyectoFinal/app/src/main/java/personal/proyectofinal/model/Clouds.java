package personal.proyectofinal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RIVARA on 12/08/2016.
 */

public class Clouds {

    @SerializedName("all")
    @Expose
    private Integer all;

    /**
     *
     * @return
     *     The all
     */
    public Integer getAll() {
        return all;
    }

    /**
     *
     * @param all
     *     The all
     */
    public void setAll(Integer all) {
        this.all = all;
    }

}
