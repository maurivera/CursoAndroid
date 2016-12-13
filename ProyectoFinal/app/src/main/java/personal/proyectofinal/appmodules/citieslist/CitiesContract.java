package personal.proyectofinal.appmodules.citieslist;

import java.util.ArrayList;

import personal.proyectofinal.model.City;

/**
 * Created by RIVARA on 12/08/2016.
 */

public interface CitiesContract {

    interface View{
        void hideSwipeRefreshLayout();
        void showErrorLoadingCitiesToast(String errorMessage);
        void showCitiesList(ArrayList<City> citiesList);
    }

    interface Presenter{
        //void generateRandomCities();
        //void loadCities();
        void getCitiesWeather();
    }

    interface GenerateCitiesInteractor{
        void generateCitiesInDatabase();
    }

    interface LoadCitiesInteractor{

        interface OnCitiesListLoaded{
            void onCitiesListLoadedSuccessful(ArrayList<City> citiesList);
            void onErrorLoadingCitiesList();
        }

        void loadCitiesFromDatabase(OnCitiesListLoaded onCitiesListLoaded);
    }
}
