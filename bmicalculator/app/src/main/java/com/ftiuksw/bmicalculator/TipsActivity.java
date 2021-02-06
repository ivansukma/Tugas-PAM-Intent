package com.ftiuksw.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TipsActivity extends AppCompatActivity {

    private TextView testKategori;
    private TextView kurus_1;
    private TextView kurus_2;
    private TextView kurus_3;
    private TextView kurus_4;
    private TextView kurus_5;
    private TextView kurus_6;
    private TextView kurus_7;
    private TextView kurus_8;

    public TipsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        testKategori = findViewById(R.id.textView6);
        kurus_1 = findViewById(R.id.textView7);
        kurus_2 = findViewById(R.id.textView8);
        kurus_3 = findViewById(R.id.textView9);
        kurus_4 = findViewById(R.id.textView10);
        kurus_5 = findViewById(R.id.textView11);
        kurus_6 = findViewById(R.id.textView12);
        kurus_7 = findViewById(R.id.textView13);
        kurus_8 = findViewById(R.id.textView14);

        String testAja = getIntent().getStringExtra("kategori");
        testKategori.setText(testAja);

        if (testAja == "OVERWEIGHT"){
            kurus_1.setVisibility(View.INVISIBLE);
            kurus_2.setVisibility(View.INVISIBLE);
            kurus_3.setVisibility(View.INVISIBLE);
            kurus_4.setVisibility(View.INVISIBLE);
            kurus_5.setVisibility(View.INVISIBLE);
            kurus_6.setVisibility(View.INVISIBLE);
            kurus_7.setVisibility(View.INVISIBLE);
            kurus_8.setVisibility(View.INVISIBLE);
        }
    }
}
