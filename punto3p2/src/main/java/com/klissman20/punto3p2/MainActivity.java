package com.klissman20.punto3p2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int flag=0;
    View Cuadrado,Triangulo,Circulo,Rectangulo;
    Button bCalcular;
    RadioButton rb_Cuad,rb_Cir,rb_Trian,rb_Rect;
    EditText lCuad,bRect,lRect,bTrian,aTrian,rCir,et_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cuadrado = findViewById(R.id.ll_cuadrado);
        Triangulo = findViewById(R.id.ll_Triangulo);
        Rectangulo = findViewById(R.id.ll_Rectangulo);
        Circulo = findViewById(R.id.ll_circulo);
        rb_Cuad = (RadioButton) findViewById(R.id.rb_Cuadrado);
        rb_Cir = (RadioButton) findViewById(R.id.rb_Circulo);
        rb_Trian = (RadioButton) findViewById(R.id.rb_Triangulo);
        rb_Rect = (RadioButton) findViewById(R.id.rb_Rectangulo);
        bCalcular = (Button) findViewById(R.id.btn_calcular);
        lCuad = (EditText) findViewById(R.id.et_lcuadrado);
        bRect = (EditText) findViewById(R.id.et_bRectangulo);
        lRect = (EditText) findViewById(R.id.et_lRectangulo);
        bTrian = (EditText)findViewById(R.id.et_btriangulo);
        aTrian = (EditText) findViewById(R.id.et_atriangulo);
        rCir = (EditText) findViewById(R.id.et_rcirculo);
        et_res = (EditText) findViewById(R.id.et_resultado);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lcua,brec,lrec,btrian,atrian,rcir,res=0;


                if (flag==0) {
                    Toast.makeText(MainActivity.this, "Seleccione figura", Toast.LENGTH_SHORT).show();
                }
                if (flag==1) {
                    lcua = Double.parseDouble(lCuad.getText().toString());
                    res = lcua * lcua;
                }
                if (flag==2) {
                    rcir = Double.parseDouble(rCir.getText().toString());
                    res = 3.1416 * (rcir * rcir);
                }
                if (flag==3) {
                    btrian = Double.parseDouble(bTrian.getText().toString());
                    atrian = Double.parseDouble(aTrian.getText().toString());
                    res = (btrian * atrian) / 2;
                }
                if (flag==4) {
                    brec = Double.parseDouble(bRect.getText().toString());
                    lrec = Double.parseDouble(lRect.getText().toString());
                    res = brec * lrec;
                }

                et_res.setText(String.valueOf(res));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_Cuadrado:
                if (checked)
                    flag = 1;
                    mostrarCuadrado(true);
                break;
            case R.id.rb_Circulo:
                if (checked)
                    flag = 2;
                    mostrarCirculo(true);
                break;
            case R.id.rb_Triangulo:
                if (checked)
                    flag = 3;
                    mostrarTriangulo(true);
                break;
            case R.id.rb_Rectangulo:
                if (checked)
                    flag = 4;
                    mostrarRectangulo(true);
                break;
        }
    }

    public void mostrarCuadrado(boolean b) {
        Cuadrado.setVisibility(b ? View.VISIBLE : View.GONE);
        Triangulo.setVisibility(b ? View.GONE : View.VISIBLE);
        Rectangulo.setVisibility(b ? View.GONE : View.VISIBLE);
        Circulo.setVisibility(b ? View.GONE : View.VISIBLE);
    }
    public void mostrarCirculo(boolean b) {
        Circulo.setVisibility(b ? View.VISIBLE : View.GONE);
        Triangulo.setVisibility(b ? View.GONE : View.VISIBLE);
        Rectangulo.setVisibility(b ? View.GONE : View.VISIBLE);
        Cuadrado.setVisibility(b ? View.GONE : View.VISIBLE);
    }
    public void mostrarTriangulo(boolean b) {
        Triangulo.setVisibility(b ? View.VISIBLE : View.GONE);
        Circulo.setVisibility(b ? View.GONE : View.VISIBLE);
        Cuadrado.setVisibility(b ? View.GONE : View.VISIBLE);
        Rectangulo.setVisibility(b ? View.GONE : View.VISIBLE);
    }
    public void mostrarRectangulo(boolean b) {
        Rectangulo.setVisibility(b ? View.VISIBLE : View.GONE);
        Circulo.setVisibility(b ? View.GONE : View.VISIBLE);
        Cuadrado.setVisibility(b ? View.GONE : View.VISIBLE);
        Triangulo.setVisibility(b ? View.GONE : View.VISIBLE);
    }
}
