package personal.proyectofinal.appmodules.citydetail;

/**
 * Created by RIVARA on 12/08/2016.
 */

public interface CityDetailContract {
    interface View{
        void showCityInfo(String name, String email, String telephone);
    }

    interface Presenter{
        //void loadContactInfo(Contact contact);
    }
}
