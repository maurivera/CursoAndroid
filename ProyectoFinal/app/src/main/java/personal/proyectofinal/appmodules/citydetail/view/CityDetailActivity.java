package personal.proyectofinal.appmodules.citydetail.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import personal.proyectofinal.appmodules.citydetail.CityDetailContract;

import personal.proyectofinal.R;

public class CityDetailActivity extends AppCompatActivity implements CityDetailContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);
    }

    @Override
    public void showCityInfo(String name, String email, String telephone) {

    }
}
