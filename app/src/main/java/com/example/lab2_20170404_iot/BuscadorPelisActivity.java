package com.example.lab2_20170404_iot;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_20170404_iot.R;
import com.example.lab2_20170404_iot.Services.Apis;
import com.example.lab2_20170404_iot.dto.Pelicula;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscadorPelisActivity extends AppCompatActivity {
    Apis apis;

    Pelicula pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_pelis);
        Toast.makeText(this, "Se encuentra en: " + getClass().getSimpleName(), Toast.LENGTH_SHORT).show();



        apis = new Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Apis.class);
        fetchWebServiceData();

        CheckBox checkBox = findViewById(R.id.checkBox);
        Button regresar = findViewById(R.id.button_regresar);

        regresar.setOnClickListener(view ->{
            if(checkBox.isChecked()){
                Intent intent = new Intent(BuscadorPelisActivity.this, MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Debe estar de acuerdo con lo leido", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void fetchWebServiceData(){

        String movieId = getIntent().getStringExtra("idmb_peli");
        String apikey = "bf81d461";

        TextView titulo = findViewById(R.id.titulo_vistapeli);
        TextView director = findViewById(R.id.director);

        TextView actores = findViewById(R.id.actores);
        TextView fecha_estreno = findViewById(R.id.fecha_estreno);
        TextView generos = findViewById(R.id.generos);
        TextView escritores = findViewById(R.id.escritores);
        TextView trama = findViewById(R.id.trama);
        TextView ratings_imdb = findViewById(R.id.int_mov_database);
        TextView rotten_tom = findViewById(R.id.rotten_tomatoes);
        TextView metrics = findViewById((R.id.metrics));



        apis.getPelicula(apikey, movieId).enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                Log.d("msg-test", "Funciona");

                if(response.isSuccessful()){
                    pelicula = response.body();

                    assert pelicula != null;
                    titulo.setText(pelicula.getTitle());
                    director.setText(pelicula.getDirector());
                    actores.setText(pelicula.getActors());
                    fecha_estreno.setText(pelicula.getReleased());
                    generos.setText(pelicula.getGenre());
                    trama.setText(pelicula.getPlot());
                    escritores.setText(pelicula.getWriter());
                    ratings_imdb.setText(pelicula.getRatings().get(0).getValue());
                    rotten_tom.setText(pelicula.getRatings().get(1).getValue());
                    metrics.setText(pelicula.getRatings().get(2).getValue());



                }
            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {
                Log.d("mrg-test", "No funciona");

            }
        });
    }


}
