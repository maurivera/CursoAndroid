package personal.proyectofinal.appmodules.citydetail.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import personal.proyectofinal.R;
import personal.proyectofinal.appmodules.citydetail.CityDetailContract;
import personal.proyectofinal.appmodules.citydetail.presenter.CityDetailPresenter;
import personal.proyectofinal.appmodules.citieslist.view.CitiesActivity;
import personal.proyectofinal.model.City;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityDetailActivity extends AppCompatActivity implements CityDetailContract.View {

    @BindView(R.id.text_view_city_name_value) TextView mTextViewName;
    @BindView(R.id.text_view_city_temperature_value) TextView mTextViewTemperature;

    private CityDetailPresenter mCityDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);
        ButterKnife.bind(this);
        initPresenter();
        loadCityData();
    }

    private void initPresenter() {
        mCityDetailPresenter = new CityDetailPresenter(this);
    }

    private void loadCityData() {
        City city = getIntent().getParcelableExtra(CitiesActivity.CITY_ID_KEY);
        mCityDetailPresenter.loadCityInfo(city);
    }

    @Override
    public void showCityInfo(String name, String temperature) {
        mTextViewName.setText(name);
        mTextViewTemperature.setText(temperature);
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}
