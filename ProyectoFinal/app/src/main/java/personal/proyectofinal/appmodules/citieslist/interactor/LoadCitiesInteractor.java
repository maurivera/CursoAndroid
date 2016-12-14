package personal.proyectofinal.appmodules.citieslist.interactor;

import personal.proyectofinal.appmodules.citieslist.CitiesContract;
import personal.proyectofinal.dataaccess.CityDAO;
import personal.proyectofinal.model.City;

import java.util.ArrayList;

import io.realm.Realm;


/**
 * Created by RIVARA on 12/10/2016.
 */

public class LoadCitiesInteractor implements CitiesContract.LoadCitiesInteractor {

    private OnCitiesListLoaded mOnCitiesListLoaded;
    private CityDAO mCitiesDao;

    public LoadCitiesInteractor(Realm realm){
        mCitiesDao = new CityDAO(realm);
    }

    @Override
    public void loadCitiesFromDatabase(OnCitiesListLoaded onCitiesListLoaded) {
        /*mOnCitiesListLoaded = onCitiesListLoaded;
        ArrayList<City> citiesList = mCitiesDao.getCitiesList();

        if(citiesList != null && citiesList.size() > 0)
            mOnCitiesListLoaded.onCitiesListLoadedSuccessful(citiesList);
        else
            mOnCitiesListLoaded.onErrorLoadingCitiesList();*/
    }
}
