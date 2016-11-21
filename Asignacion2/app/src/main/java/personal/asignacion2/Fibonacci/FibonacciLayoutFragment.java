package personal.asignacion2.Fibonacci;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;

import personal.asignacion2.R;

public class FibonacciLayoutFragment extends Fragment {

    Button btnCalculate;
    EditText editTextNumeroACalcular;

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
        final View view = inflater.inflate(R.layout.fragment_fibonacci_layout, container, false);

        btnCalculate = (Button) view.findViewById(R.id.btnCalculate);
        editTextNumeroACalcular = (EditText) view.findViewById(R.id.editTextNumeroACalcular);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumeroACalcular.getText().toString().matches("")) {
                    // Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                    return;
                }

                long numeroacalcular = Long.parseLong(editTextNumeroACalcular.getText().toString());
                FibonacciClass miCalculadora = new FibonacciClass(numeroacalcular);

                long miresultado = miCalculadora.calculateFibonacci();

                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Resultado");
                alertDialog.setMessage(Long.toString(miresultado));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                editTextNumeroACalcular.setText("");
                            }
                        });
                alertDialog.show();
            }
        });
        return view;


    }
}
