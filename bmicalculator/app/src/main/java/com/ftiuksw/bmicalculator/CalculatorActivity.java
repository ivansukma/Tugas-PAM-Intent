package com.ftiuksw.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    public String extra_kategori;

    private EditText edtBerat;
    private EditText edtTinggi;
    private Button btnHitung;
    private Button tips_activity;
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
        tips_activity = findViewById(R.id.BtnTips);

        String welcome_message = "Welcome, " + getIntent().getStringExtra("username") + " :) ";
        welcome_user.setText(welcome_message);


        btnHitung.setOnClickListener(this);
        tips_activity.setOnClickListener(this);

    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String inputBerat = edtBerat.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();
            double imb = Double.valueOf(inputBerat) / (Double.valueOf(inputTinggi) * Double.valueOf(inputTinggi) / 10000);
            String kategori = "IDEAL";
            if (imb >= 25.1) {
                kategori = "OVERWEIGHT";
            } else if (imb < 18.5) {
                kategori = "UNDERWEIGHT";
            }

            String result_message = String.format("%.2f", imb) + " (" + kategori + ")";
            tvHasil.setText(result_message);
            extra_kategori = kategori;
        }

        if (v.getId()==R.id.BtnTips){
            Intent i = new Intent(CalculatorActivity.this, TipsActivity.class);
            i.putExtra("kategori", extra_kategori);
            startActivity(i);
        }
    }
}