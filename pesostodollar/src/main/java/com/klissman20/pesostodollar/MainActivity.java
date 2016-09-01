package com.klissman20.pesostodollar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText evalor,eresultado;
    Button bCalcular;
    RadioButton rPaD,rDaP;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        evalor = (EditText) findViewById(R.id.valor);
        eresultado = (EditText) findViewById(R.id.resultado);
        rPaD = (RadioButton) findViewById(R.id.rPaD);
        rDaP = (RadioButton) findViewById(R.id.rDaP);
        bCalcular = (Button) findViewById(R.id.Btnconvertir);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valor,res=0;
                valor = Double.parseDouble(evalor.getText().toString());

                if (flag==0)
                    Toast.makeText(MainActivity.this, "Seleccione conversion", Toast.LENGTH_SHORT).show();
                if (flag==1)
                    res = valor * 3000;
                if (flag==2)
                    res = valor / 3000;

                eresultado.setText(String.valueOf(res));
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rDaP:
                if (checked)
                    flag = 1;
                    break;
            case R.id.rPaD:
                if (checked)
                    flag = 2;
                    break;
        }
    }

}
