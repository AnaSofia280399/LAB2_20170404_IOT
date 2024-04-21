package com.example.lab2_20170404_iot.Services;

import android.content.Intent;

import com.example.lab2_20170404_iot.dto.Numprimo;
import com.example.lab2_20170404_iot.dto.Pelicula;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {

    @GET("/")
    Call<Pelicula> getPelicula(
            @Query("apikey") String apikey,
            @Query("i") String imdbID
    );

    @GET("/")
    Call<Numprimo> getPrimo(
            @Query("order")Intent order);



}

