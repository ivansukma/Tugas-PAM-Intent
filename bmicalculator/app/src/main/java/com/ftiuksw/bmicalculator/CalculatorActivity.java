package com.ftiuksw.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

//    public static final String EXTRA_KATEGORI = "extra_kategori";
    public String throwKategori;

    private EditText edtBerat;
    private EditText edtTinggi;
    private Button btnHitung;
    private Button tips_activity;
    private TextView tvHasil;
    private TextView welcome_user;
    private View background;
    public String tema;
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
        background = findViewById(R.id.background);

        tema= getIntent().getStringExtra("tema");

        if (tema.equalsIgnoreCase("blue")){
            tips_activity.setTextColor(Color.parseColor("#5D7F98"));
            btnHitung.setTextColor(Color.parseColor("#5D7F98"));
            background.setBackgroundResource(R.drawable.bgblue);
        } else {
            tips_activity.setTextColor(Color.parseColor("#D5A55D"));
            btnHitung.setTextColor(Color.parseColor("#D5A55D"));
            background.setBackgroundResource(R.drawable.bgorange);
        }

        background.setScaleX(3);
        background.setScaleY(3);

        String welcome_message = "Welcome, " + getIntent().getStringExtra("username") + " :) ";
        welcome_user.setText(welcome_message);
        tips_activity.setVisibility(View.INVISIBLE);

        btnHitung.setOnClickListener(this);
        tips_activity.setOnClickListener(this);

    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String inputBerat = edtBerat.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();
            boolean isEmpetyFields = false;
            boolean isNotZero = false;

            if (TextUtils.isEmpty(inputBerat)) {
                isEmpetyFields = true;
                edtBerat.setError("Mohon isikan value");
            }

            if (TextUtils.isEmpty(inputTinggi)) {
                isEmpetyFields = true;
                edtTinggi.setError("Mohon isikan value");
            }

            if (inputTinggi.equals("0")) {
                isNotZero = true;
                edtTinggi.setError("Tidak bisa dibagi 0");
            }

            if(!isEmpetyFields && !isNotZero) {
                double imb = Double.valueOf(inputBerat) / (Double.valueOf(inputTinggi) * Double.valueOf(inputTinggi) / 10000);
                String kategoriIMB = "IDEAL";
                if (imb >= 25.1) {
                    kategoriIMB = "OVERWEIGHT";
                } else if (imb < 18.5) {
                    kategoriIMB = "UNDERWEIGHT";
                }
                throwKategori = kategoriIMB;

                String result_message = String.format("%.2f", imb) + " (" + kategoriIMB + ")";
                tvHasil.setText(result_message);

                if (throwKategori.equals("IDEAL")) {
                    tips_activity.setVisibility(View.INVISIBLE);
                } else {
                    tips_activity.setVisibility(View.VISIBLE);
                }
            }
        }

        if (v.getId()==R.id.BtnTips){
            Intent i = new Intent(CalculatorActivity.this, TipsActivity.class);
            i.putExtra("kategori", throwKategori);
            i.putExtra("tema", tema);
            startActivity(i);
        }
    }
}