package com.klissman20.punto4p2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{

    private int mYear;
    private int mMonth;
    private int mDay;
    int flag=0;

    TextView mDateDisplay;
    Button mPickDate,btn_sub;
    Spinner spinner1;
    TextView user,pass,email,date,lugar,hobbie,sexo;
    EditText et_user,et_pass,et_email,et_rpass;
    RadioButton rb_fem,rb_mas;
    String h="";
    CheckBox a,b,c,d,e,f;

    static final int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateDisplay = (TextView) findViewById(R.id.showMyDate);
        mPickDate = (Button) findViewById(R.id.myDatePickerButton);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        btn_sub = (Button) findViewById(R.id.btn_aceptar);
        user = (TextView) findViewById(R.id.tv_user);
        pass = (TextView) findViewById(R.id.tv_pass);
        date = (TextView) findViewById(R.id.tv_date);
        lugar = (TextView) findViewById(R.id.tv_lugar);
        email = (TextView) findViewById(R.id.tv_email);
        hobbie = (TextView) findViewById(R.id.tv_hobbie);
        sexo = (TextView) findViewById(R.id.tv_sexo);
        et_user = (EditText) findViewById(R.id.et_user);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_email = (EditText) findViewById(R.id.et_email);
        et_rpass = (EditText) findViewById(R.id.et_rpass);
        rb_fem = (RadioButton) findViewById(R.id.rb_femenino);
        rb_mas = (RadioButton) findViewById(R.id.rb_masculino);
        a = (CheckBox) findViewById(R.id.cb_1);
        b = (CheckBox) findViewById(R.id.cb_2);
        c = (CheckBox) findViewById(R.id.cb_3);
        d = (CheckBox) findViewById(R.id.cb_4);
        e = (CheckBox) findViewById(R.id.cb_5);
        f = (CheckBox) findViewById(R.id.cb_6);





        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // get the current date
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        // display the current date
        updateDisplay();

        btn_sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (et_user.getText() != null && et_pass.getText() != null && et_rpass.getText() != null
                    && et_email.getText() != null && (rb_fem.isChecked() || rb_mas.isChecked()) && spinner1.getSelectedItem() != null
                    && (a.isChecked() || b.isChecked() || c.isChecked() || d.isChecked() || e.isChecked() || f.isChecked())) {

                    if (et_pass.getText().toString().equals(et_rpass.getText().toString())) {
                        user.setText(et_user.getText().toString());
                        user.setTextSize(20);
                        pass.setText(et_pass.getText().toString());
                        pass.setTextSize(20);
                        email.setText(et_email.getText().toString());
                        email.setTextSize(20);
                        if (flag == 1) {
                            sexo.setText(rb_fem.getText());
                        }
                        if (flag == 2) {
                            sexo.setText(rb_mas.getText());
                        }
                        sexo.setTextSize(20);
                        date.setText(mYear + " / " + mMonth + " / " + mDay);
                        date.setTextSize(20);
                        lugar.setText(spinner1.getSelectedItem().toString());
                        lugar.setTextSize(20);
                        hobbie.setText(h);
                        hobbie.setTextSize(20);
                    }else{
                        Toast.makeText(MainActivity.this, "Password no coincide", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateDisplay() {
        this.mDateDisplay.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mMonth + 1).append("-")
                        .append(mDay).append("-")
                        .append(mYear).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cb_1:
                if (checked)
                    h=h+", "+a.getText();
                break;
            case R.id.cb_2:
                if (checked)
                    h=h+", "+b.getText();
                break;
            case R.id.cb_3:
                if (checked)
                    h=h+", "+c.getText();
                    break;
            case R.id.cb_4:
                if (checked)
                    h=h+", "+d.getText();
                    break;
            case R.id.cb_5:
                if (checked)
                    h=h+", "+e.getText();
                    break;
            case R.id.cb_6:
                if (checked)
                    h=h+", "+f.getText();
                    break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_femenino:
                if (checked) {
                    flag = 1;
                }
                break;
            case R.id.rb_masculino:
                if (checked) {
                    flag = 2;
                }
                break;
        }
    }
}

