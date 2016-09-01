package com.klissman20.punto2p2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText evalor,evalor2,eRes;
    Button bCalcular;
    RadioButton rSuma,rResta,rMult,rDiv;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        evalor = (EditText) findViewById(R.id.evalor);
        evalor2 = (EditText) findViewById(R.id.evalor2);
        eRes = (EditText)  findViewById(R.id.eResultado);
        rSuma = (RadioButton) findViewById(R.id.rSuma);
        rResta = (RadioButton) findViewById(R.id.rResta);
        rMult = (RadioButton) findViewById(R.id.rMultiplicacion);
        rDiv = (RadioButton) findViewById(R.id.rDivision);
        bCalcular = (Button) findViewById(R.id.Btnconvertir);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valor,valor2,res=0;
                valor = Double.parseDouble(evalor.getText().toString());
                valor2 = Double.parseDouble(evalor2.getText().toString());


                if (flag==0)
                    Toast.makeText(MainActivity.this, "Seleccione operacion", Toast.LENGTH_SHORT).show();
                if (flag==1)
                    res = valor + valor2;
                if (flag==2)
                    res = valor - valor2;
                if (flag==3)
                    res = valor * valor2;
                if (flag==4)
                    res = valor / valor2;

                eRes.setText(String.valueOf(res));
            }
        });
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rSuma:
                if (checked)
                    flag = 1;
                break;
            case R.id.rResta:
                if (checked)
                    flag = 2;
                break;
            case R.id.rMultiplicacion:
                if (checked)
                    flag = 3;
                break;
            case R.id.rDivision:
                if (checked)
                    flag = 4;
                break;
        }
    }
}
