package personal.proyectofinal.appmodules.citieslist.interactor;

import personal.proyectofinal.appmodules.citieslist.CitiesContract;
import personal.proyectofinal.dataaccess.CityDAO;
import personal.proyectofinal.model.City;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by RIVARA on 12/09/2016.
 */

public class GenerateCitiesInteractor implements CitiesContract.GenerateCitiesInteractor {

    private CityDAO mCityDao;

    public GenerateCitiesInteractor(Realm realm){
        mCityDao = new CityDAO(realm);
    }

    @Override
    public void generateCitiesInDatabase() {
        if(!mCityDao.areCitiesAvailable())
            mCityDao.saveCitiesList(generateRandomCitiesList());
    }

    private ArrayList<City> generateRandomCitiesList(){
        ArrayList<City> citiesList = new ArrayList<>();

        for(int counter = 0; counter < 10; counter++){
            City city = new City(counter, "Name " + counter);
            citiesList.add(city);
        }

        return citiesList;
    }
}
