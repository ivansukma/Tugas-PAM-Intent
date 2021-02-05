package com.ftiuksw.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtBerat;
    private EditText edtTinggi;
    private Button btnHitung;
    private TextView tvHasil;
    private TextView welcome_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edtBerat = findViewById(R.id.edt_berat);
        edtTinggi = findViewById(R.id.edt_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        welcome_user = findViewById(R.id.welcome_user);

        String welcome_message = "Welcome, " + getIntent().getStringExtra("username") + " :) ";
        welcome_user.setText(welcome_message);

        btnHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String inputBerat = edtBerat.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();

            double imb = Double.valueOf(inputBerat) / (Double.valueOf(inputTinggi) * Double.valueOf(inputTinggi) / 10000);
            tvHasil.setText(String.valueOf(imb));
        }
    }
}