package personal.proyectofinal.appmodules.citieslist.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import personal.proyectofinal.R;
import personal.proyectofinal.appmodules.citieslist.CitiesContract;
import personal.proyectofinal.appmodules.citieslist.adapter.CitiesListAdapter;
import personal.proyectofinal.appmodules.citydetail.view.CityDetailActivity;
import personal.proyectofinal.appmodules.citieslist.interactor.GenerateCitiesInteractor;
import personal.proyectofinal.appmodules.citieslist.interactor.LoadCitiesInteractor;
import personal.proyectofinal.appmodules.citieslist.presenter.CitiesPresenter;
import personal.proyectofinal.model.City;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

import personal.proyectofinal.model.WeatherApiResponse;
import personal.proyectofinal.networking.CitiesWeatherService;
import personal.proyectofinal.networking.WeatherApiConstants;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CitiesListFragment extends Fragment implements CitiesContract.View, Callback<WeatherApiResponse> {

    @BindView(R.id.cities_recycler_view)
    RecyclerView mCitiesRecyclerView;
    @BindView(R.id.cities_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    CitiesWeatherService mWeatherService;
    private LinearLayoutManager mLayoutManager;
    private CitiesListAdapter mCitiesListAdapter;
    private CitiesPresenter mCitiesPresenter;
    private LoadCitiesInteractor mLoadCitiesInteractor;
    private GenerateCitiesInteractor mGenerateCitiesInteractor;
    private Realm mRealm;


    public CitiesListFragment() {
        // Required empty public constructor
    }

    public static CitiesListFragment newInstance() {
        CitiesListFragment fragment = new CitiesListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_cities_list, container, false);

        ButterKnife.bind(this.getActivity());
        mRealm = Realm.getDefaultInstance();
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.cities_swipe_refresh_layout);
        mCitiesRecyclerView = (RecyclerView) view.findViewById(R.id.cities_recycler_view);

        initWeatherService();
        initPresenter();
        initCitiesRecyclerView();
        initSwipeRefreshLayout();

        return view;
    }

    private void initPresenter() {
        mLoadCitiesInteractor = new LoadCitiesInteractor(mRealm);
        mGenerateCitiesInteractor = new GenerateCitiesInteractor(mRealm);
        mCitiesPresenter = new CitiesPresenter(this.getActivity().getApplicationContext(), this, mLoadCitiesInteractor, mGenerateCitiesInteractor, mWeatherService);
        //mCitiesPresenter.generateRandomCities();
        mCitiesPresenter.getCitiesWeather();
    }

    private void initCitiesRecyclerView() {
        mLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
        mCitiesRecyclerView.setLayoutManager(mLayoutManager);
        mCitiesListAdapter = new CitiesListAdapter(new CitiesListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(City city, ImageView cityImageView, TextView cityNameTextView) {
                startCityDetail(city, cityImageView, cityNameTextView);
            }
        });
        mCitiesRecyclerView.setAdapter(mCitiesListAdapter);
    }

    private void startCityDetail(City city, ImageView cityImageView, TextView cityNameTextView) {
        Intent intent = new Intent(this.getActivity(), CityDetailActivity.class);
        intent.putExtra(((CitiesActivity) this.getActivity()).CITY_ID_KEY, city);
        Pair<View, String> imageViewCityPair = Pair.create((View) cityImageView, getString(R.string.city_image_transition));
        Pair<View, String> textViewCityNamePair = Pair.create((View) cityNameTextView, getString(R.string.city_name_transition));
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this.getActivity(), imageViewCityPair, textViewCityNamePair);
        startActivity(intent, options.toBundle());
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeColors(ResourcesCompat.getColor(getResources(), android.R.color.holo_orange_light, null));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //mCitiesPresenter.loadCities();
                mCitiesPresenter.getCitiesWeather();

            }
        });
        //mCitiesPresenter.loadCities();
    }

    private void initWeatherService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherApiConstants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mWeatherService = retrofit.create(CitiesWeatherService.class);
    }

    @Override
    public void hideSwipeRefreshLayout() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showErrorLoadingCitiesToast(String errorMessage) {
        Toast.makeText(this.getActivity(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCitiesList(ArrayList<City> citiesList) {
        mCitiesListAdapter.setCitiesList(citiesList);
    }

    @Override
    public void onResponse(Call<WeatherApiResponse> call, Response<WeatherApiResponse> response) {
        WeatherApiResponse weatherApiResponse = response.body();
        List<City> citiesList = weatherApiResponse.getList();

        mCitiesPresenter.onCitiesListLoadedSuccessful(new ArrayList<City>(citiesList));
        }

    @Override
    public void onFailure(Call<WeatherApiResponse> call, Throwable t) {
        mCitiesPresenter.onErrorLoadingCitiesList();
    }

    //@Override
    //protected void onDestroy() {
    //super.onDestroy();
    //mRealm.close();
    //}
}
