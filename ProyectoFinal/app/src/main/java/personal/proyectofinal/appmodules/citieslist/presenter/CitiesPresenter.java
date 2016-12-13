package personal.proyectofinal.appmodules.citieslist.presenter;

import android.content.Context;

import personal.proyectofinal.R;
import personal.proyectofinal.appmodules.citieslist.CitiesContract;
import personal.proyectofinal.appmodules.citieslist.interactor.GenerateCitiesInteractor;
import personal.proyectofinal.appmodules.citieslist.interactor.LoadCitiesInteractor;
import personal.proyectofinal.model.City;
import personal.proyectofinal.networking.CitiesWeatherService;

import java.util.ArrayList;

import personal.proyectofinal.model.WeatherApiResponse;
import personal.proyectofinal.networking.WeatherApiConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RIVARA on 12/10/2016.
 */

public class CitiesPresenter implements CitiesContract.Presenter, CitiesContract.LoadCitiesInteractor.OnCitiesListLoaded {

    private Context mContext;
    private CitiesContract.View mCitiesView;
    private LoadCitiesInteractor mLoadCitiesInteractor;
    private GenerateCitiesInteractor mGenerateCitiesInteractor;
    private CitiesWeatherService mWeatherService;

    public CitiesPresenter(Context context, CitiesContract.View citiesView,
                           LoadCitiesInteractor loadCitiesInteractor,
                           GenerateCitiesInteractor generateCitiesInteractor,
                           CitiesWeatherService weatherService) {
        mContext = context;
        mCitiesView = citiesView;
        mLoadCitiesInteractor = loadCitiesInteractor;
        mGenerateCitiesInteractor = generateCitiesInteractor;
        mWeatherService = weatherService;
    }

    //@Override
    //public void generateRandomCities() {
        //mGenerateCitiesInteractor.generateCitiesInDatabase();
    //}

    //@Override
    //public void loadCities() {
        //mLoadCitiesInteractor.loadCitiesFromDatabase(this);
    //}

    @Override
    public void getCitiesWeather() {
        Call<WeatherApiResponse> call = mWeatherService.getCitiesWeather(
                WeatherApiConstants.LAT, WeatherApiConstants.LON,
                WeatherApiConstants.CONT, WeatherApiConstants.APP_ID, WeatherApiConstants.UNIT
        );
        call.enqueue((Callback<WeatherApiResponse>) mCitiesView);
    }

    @Override
    public void onCitiesListLoadedSuccessful(ArrayList<City> citiesList) {
        mCitiesView.hideSwipeRefreshLayout();
        mCitiesView.showCitiesList(citiesList);
    }

    @Override
    public void onErrorLoadingCitiesList() {
        mCitiesView.showErrorLoadingCitiesToast(mContext.getString(R.string.cities_list_error_loading_cities_msg));
    }
}
