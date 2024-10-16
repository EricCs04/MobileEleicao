package com.example.eleicaodisp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {

    TextView tvCandidatos, tvSimulado;
    Button btProxEnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        tvSimulado = findViewById(R.id.tvSimulado);
        tvCandidatos = findViewById(R.id.tvCandidatos);
        btProxEnt = findViewById(R.id.btProxEnt);
        try {

            String nomesContadores = VarEleitoral.getNomeCont();
            String nomesSimulados = VarEleitoral.getNomeSimulado();
            tvSimulado.setText(nomesSimulados);
            tvCandidatos.setText(nomesContadores);
        } catch(Exception e){
            Log.e("Segunda Atividade", "ERRO:", e);
            tvCandidatos.setText("Erro ao carregar dados");
            tvSimulado.setText("Erro ao carregar dados");
        }

        btProxEnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Resultado.this, EntrevistadoPres.class);
                startActivity(i);
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}