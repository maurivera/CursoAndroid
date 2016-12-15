package personal.proyectofinal.appmodules.citydetail.presenter;

import personal.proyectofinal.appmodules.citydetail.CityDetailContract;
import personal.proyectofinal.model.City;

import personal.proyectofinal.networking.WeatherApiConstants;

/**
 * Created by RIVARA on 12/10/2016.
 */

public class CityDetailPresenter implements CityDetailContract.Presenter {

    private CityDetailContract.View mCityDetailView;

    public CityDetailPresenter(CityDetailContract.View cityDetailView) {
        mCityDetailView = cityDetailView;
    }

    @Override
    public void loadCityInfo(City city) {

        String description = "";

        if (city.getWeather().size() > 0) {
            description += city.getWeather().get(0).getDescription();
        }

        mCityDetailView.showCityInfo(
                city.getName(),
                String.valueOf(city.getMain().getTemp()) + WeatherApiConstants.UNIT_CHARACTER,
                String.valueOf(city.getMain().getHumidity()) + WeatherApiConstants.UNIT_PERCENTAGE,
                String.valueOf(city.getWind().getSpeed()),
                description);
    }
}
