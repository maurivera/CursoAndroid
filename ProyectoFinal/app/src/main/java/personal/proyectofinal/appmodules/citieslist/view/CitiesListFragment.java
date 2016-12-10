package personal.proyectofinal.appmodules.citieslist.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import personal.proyectofinal.R;

public class CitiesListFragment extends Fragment {

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
        return view;
    }
}
