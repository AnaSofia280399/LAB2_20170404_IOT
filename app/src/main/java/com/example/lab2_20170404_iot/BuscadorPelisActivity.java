package com.example.lab2_20170404_iot;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_20170404_iot.R;

public class BuscadorPelisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_pelis);


    }

    public boolean hayinternet(){
        ConnectivityManager manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        boolean tieneInternet = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        Log.d("msg-test","Internet: " + tieneInternet);
        return tieneInternet;
    }
}
