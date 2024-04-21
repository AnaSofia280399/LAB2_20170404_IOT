package com.example.lab2_20170404_iot;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contador);
        Toast.makeText(this, "Se encuentra en: " + getClass().getSimpleName(), Toast.LENGTH_SHORT).show();






    }
}
