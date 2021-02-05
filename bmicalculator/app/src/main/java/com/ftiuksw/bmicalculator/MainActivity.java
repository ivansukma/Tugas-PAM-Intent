package com.ftiuksw.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("BUTTON DICLICK");
                int status = is_user_valid(username.getText().toString(), password.getText().toString());

                if (status==1){
                    Intent i = new Intent(MainActivity.this, CalculatorActivity.class);
                    i.putExtra("username", username.getText().toString());
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Login Succesful",Toast.LENGTH_LONG).show();
                }
                else if (status == 2) {
                    Toast.makeText(getApplicationContext(),"Username/ Password salah!",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Server Bermasalah, silahkan coba lagi!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public int is_user_valid(String username, String password){
        String data = "";
        try {
            InputStream stream = getAssets().open("user.txt");
            HashMap<String, String> map = new HashMap<String, String>();

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();

            data = new String(buffer);

            String[] arr_data = data.split(",");

            for (int i = 0; i < arr_data.length; i++) {
                String[] temp = arr_data[i].split("=");
                map.put(temp[0], temp[1]);
//                System.out.println(map.get(temp[0]));
            }

            if ((map.get(username)==null) || !(map.get(username).equalsIgnoreCase(password))){
                return 2;
            }

            return 1;
        } catch (IOException e) {
            return 5;
        }

    }

}