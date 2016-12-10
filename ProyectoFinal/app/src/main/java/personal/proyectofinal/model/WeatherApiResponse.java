package personal.proyectofinal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by RIVARA on 12/08/2016.
 */
public class WeatherApiResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("list")
    @Expose
    private List<City> list = null;

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return The list
     */
    public List<City> getList() {
        return list;
    }

    /**
     * @param list The list
     */
    public void setList(List<City> list) {
        this.list = list;
    }

}
