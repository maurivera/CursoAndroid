package personal.proyectofinal.networking;

import personal.proyectofinal.model.WeatherApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RIVARA on 12/11/2016.
 */

public interface CitiesWeatherService {
    @GET("find")
    Call<WeatherApiResponse> getCitiesWeather(@Query("lat") double latValue,
                                              @Query("lon") double lonValue,
                                              @Query("cnt") int cntValue,
                                              @Query("APPID") String appIdValue,
                                              @Query("units") String unit);
}
