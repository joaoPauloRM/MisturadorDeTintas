package com.joaopaulo.misturadordetintas.helper;

import com.joaopaulo.misturadordetintas.service.SupervisorioService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.3:8080/supervisorio/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public SupervisorioService getSupervisorioService() {
        return this.retrofit.create(SupervisorioService.class);
    }

}
