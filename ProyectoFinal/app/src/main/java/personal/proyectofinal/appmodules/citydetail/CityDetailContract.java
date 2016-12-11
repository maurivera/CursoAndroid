package personal.proyectofinal.appmodules.citydetail;

import personal.proyectofinal.model.City;

/**
 * Created by RIVARA on 12/08/2016.
 */

public interface CityDetailContract {
    interface View{
        void showCityInfo(String name);
    }

    interface Presenter{
        void loadCityInfo(City city);
    }

}
