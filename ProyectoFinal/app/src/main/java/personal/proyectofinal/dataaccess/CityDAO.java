package personal.proyectofinal.dataaccess;

import java.util.ArrayList;

import io.realm.Realm;
import personal.proyectofinal.model.City;
import personal.proyectofinal.networking.CitiesWeatherService;
import personal.proyectofinal.networking.WeatherApiConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RIVARA on 12/10/2016.
 */

public class CityDAO  {

    private Realm mRealm;

    public CityDAO(Realm realm) {
        mRealm = realm;
    }

    /*public void saveCitiesList(final ArrayList<City> citiesList) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (City city : citiesList) {
                    City realmContact = realm.createObject(City.class);
                    realmContact.setId(city.getId());
                    realmContact.setName(city.getName());
                    //realmContact.setEmail(contact.getEmail());
                    //realmContact.setTelephone(contact.getTelephone());
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {

            }
        });
    }*/

    /*public ArrayList<City> getCitiesList() {
        ArrayList<City> citiesList = new ArrayList<>(mRealm.where(City.class).findAll());
        return citiesList;
    }*/

    /*public boolean areCitiesAvailable() {
        return mRealm.where(City.class).count() > 0;
    }*/

}
