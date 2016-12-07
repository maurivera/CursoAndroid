package personal.proyectofinal.About;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.TextView;

import personal.proyectofinal.R;

public class AboutFragment extends Fragment  {

    public long numeroacalcular;
    public long miresultado;

    Button btnCalculate;
    EditText editTextNumeroACalcular;
    TextView textViewResultado;

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
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

        final View view = inflater.inflate(R.layout.fragment_about, container, false);


        //btnCalculate = (Button) view.findViewById(R.id.btnCalculate);
        //editTextNumeroACalcular = (EditText) view.findViewById(R.id.editTextNumeroACalcular);
        //textViewResultado = (TextView) view.findViewById(R.id.textViewResultado);

        /*btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumeroACalcular.getText().toString().matches("")) {
                    // Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                    return;
                }

                numeroacalcular = Long.parseLong(editTextNumeroACalcular.getText().toString());
                FactorialClass miCalculadora = new FactorialClass(numeroacalcular);

                miresultado = miCalculadora.calculateFactorial();

                textViewResultado.setText(Long.toString(miresultado));

            }
        });*/
        return view;
    }

}
