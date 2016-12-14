package personal.proyectofinal.appmodules.citydetail.presenter;

import personal.proyectofinal.appmodules.citydetail.CityDetailContract;
import personal.proyectofinal.model.City;

/**
 * Created by RIVARA on 12/10/2016.
 */

public class CityDetailPresenter implements CityDetailContract.Presenter {

    private CityDetailContract.View mCityDetailView;

    public CityDetailPresenter(CityDetailContract.View cityDetailView){
        mCityDetailView = cityDetailView;
    }

    @Override
    public void loadCityInfo(City city) {
        mCityDetailView.showCityInfo(city.getName(), String.valueOf(city.getMain().getTemp()));
    }
}
