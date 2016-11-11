package personal.layoutsexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RelativeLayoutFragment extends Fragment {

    public RelativeLayoutFragment() {
        // Required empty public constructor
    }

    public static RelativeLayoutFragment newInstance() {
        RelativeLayoutFragment fragment = new RelativeLayoutFragment();
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
        return inflater.inflate(R.layout.fragment_relative_layout, container, false);
    }
}
