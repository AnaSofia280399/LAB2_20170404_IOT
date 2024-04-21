package com.example.lab2_20170404_iot;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2_20170404_iot.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(hayInternet()){
            Toast.makeText(this,"Success: Tiene internet", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Error: No tiene internet", Toast.LENGTH_LONG).show();
        }

        Button contador = findViewById(R.id.button_contador);
        contador.setOnClickListener(view -> {
            Intent intent_cont = new Intent(MainActivity.this, ContadorActivity.class);
            startActivity(intent_cont);
        });


        Button buscar_pelis = findViewById(R.id.button_buscador);
        EditText editText = findViewById(R.id.ingresar_imdb);
        buscar_pelis.setOnClickListener(view -> {

            String movieId = editText.getText().toString();

            Intent intent_busc = new Intent(MainActivity.this, BuscadorPelisActivity.class);
            intent_busc.putExtra("idmb_peli", movieId);
            startActivity(intent_busc);


        });




    }

    public boolean hayInternet(){
        ConnectivityManager manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        boolean tieneInternet = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        Log.d("msg-test","Internet: " + tieneInternet);
        return tieneInternet;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "Esta en la pagina de inicio de la app",Toast.LENGTH_SHORT).show();
    }




}