package personal.asignacion2.Fibonacci;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import personal.asignacion2.R;

public class FibonacciLayoutFragment extends Fragment {

    public FibonacciLayoutFragment() {
        // Required empty public constructor
    }

    public static FibonacciLayoutFragment newInstance() {
        FibonacciLayoutFragment fragment = new FibonacciLayoutFragment();
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
        return inflater.inflate(R.layout.fragment_fibonacci_layout, container, false);
    }
}
