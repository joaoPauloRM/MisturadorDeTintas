package com.joaopaulo.misturadordetintas.service;


import com.joaopaulo.misturadordetintas.model.Supervisorio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface SupervisorioService {

    @PUT("ligarSistema")
    Call<Supervisorio> ligarSistema();

    @PUT("desligarSistema")
    Call<Supervisorio> desligarSistema();

    @PUT("resetarContadores")
    Call<Supervisorio> resetarContadores();

    @GET("retornoDados")
    Call<Supervisorio> retornoDados();


}
