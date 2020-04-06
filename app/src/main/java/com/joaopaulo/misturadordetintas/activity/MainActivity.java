package com.joaopaulo.misturadordetintas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.joaopaulo.misturadordetintas.R;
import com.joaopaulo.misturadordetintas.helper.RetrofitConfig;
import com.joaopaulo.misturadordetintas.model.Supervisorio;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLigar = findViewById(R.id.btLigar);
        Button btDesliga = findViewById(R.id.btDesliga);
        Button btReset = findViewById(R.id.btReset);

        final RadioButton statusBomba01 = findViewById(R.id.statusBomba01);
        final RadioButton statusValvula01 = findViewById(R.id.statusValvula01);
        final RadioButton statusValvula02 = findViewById(R.id.statusValvula02);
        final RadioButton statusMisturador = findViewById(R.id.statusMisturador);
        final RadioButton statusBombaDescarte = findViewById(R.id.statusBombaDescarte);
        final TextView contadorIncompletas = findViewById(R.id.contadorIncompletas);
        final TextView contadorCompletas = findViewById(R.id.contadorCompletas);

        final RadioButton statusResetContadores = findViewById(R.id.statusResetContadores);
        final RadioButton statusEmergencia = findViewById(R.id.statusDesligado);
        final RadioButton statusStart = findViewById(R.id.statusLigado);
        Button btAtualiza = findViewById(R.id.btAtualizar);

        btLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Supervisorio> ligar = new RetrofitConfig().getSupervisorioService().ligarSistema();
                ligar.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                    }
                });
            }
        });

        btDesliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Supervisorio> desligar = new RetrofitConfig().getSupervisorioService().desligarSistema();
                desligar.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                    }
                });
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Supervisorio> resetar = new RetrofitConfig().getSupervisorioService().resetarContadores();
                resetar.enqueue(new Callback<Supervisorio>() {
                    @Override
                    public void onResponse(Call<Supervisorio> call, Response<Supervisorio> response) {
                    }

                    @Override
                    public void onFailure(Call<Supervisorio> call, Throwable t) {
                    }
                });
            }
        });

        btAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Supervisorio> atualizar = new RetrofitConfig().getSupervisorioService().retornoDados();
                atualizar.enqueue(new Callback<Supervisorio>() {
                    @Override
                    public void onResponse(Call<Supervisorio> call, Response<Supervisorio> response) {
                        Supervisorio supervisorio = response.body();
                        String[] dadosSeparados = supervisorio.toString().split(", ");

                        if (Integer.parseInt(dadosSeparados[0].trim()) == 1) {
                            statusStart.setChecked(true);
                        } else {
                            statusStart.setChecked(false);
                        }
                        if (Integer.parseInt(dadosSeparados[1].trim()) == 1) {
                            statusEmergencia.setChecked(true);
                        } else {
                            statusEmergencia.setChecked(false);
                        }
                        if (Integer.parseInt(dadosSeparados[9].trim()) == 1) {
                            statusResetContadores.setChecked(true);
                        } else {
                            statusResetContadores.setChecked(false);
                        }
                    }

                    @Override
                    public void onFailure(Call<Supervisorio> call, Throwable t) {
                    }
                });
            }
        });
    }

}

