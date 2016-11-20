package personal.asignacion2.Factorial;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import personal.asignacion2.R;

public class FactorialLayoutFragment extends Fragment {

    public FactorialLayoutFragment() {
        // Required empty public constructor
    }

    public static FactorialLayoutFragment newInstance() {
        FactorialLayoutFragment fragment = new FactorialLayoutFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_factorial_layout, container, false);
    }
}
