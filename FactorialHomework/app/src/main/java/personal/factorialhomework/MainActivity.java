package personal.factorialhomework;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button btnCalculate;
    EditText editTextNumeroACalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        editTextNumeroACalcular = (EditText) findViewById(R.id.editTextNumeroACalcular);

        btnCalculate.setOnClickListener(MainActivity.this);
    }
    @Override
    public void onClick(View v) {

        if (editTextNumeroACalcular.getText().toString().matches("")) {
           // Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }

        int numeroacalcular = Integer.parseInt(editTextNumeroACalcular.getText().toString());
        FactorialClass miCalculadora = new FactorialClass(numeroacalcular);

       int miresultado = miCalculadora.calculateFactorial();

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Resultado");
        alertDialog.setMessage(Integer.toString(miresultado));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        editTextNumeroACalcular.setText("");
                    }
                });
        alertDialog.show();
        //Your Logic




    }

}
