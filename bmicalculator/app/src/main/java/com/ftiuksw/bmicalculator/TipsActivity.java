package com.ftiuksw.bmicalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TipsActivity extends AppCompatActivity {

    private TextView testKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        testKategori = findViewById(R.id.textView6);

        String testAja = getIntent().getStringExtra("kategori");
        testKategori.setText(testAja);
    }
}
