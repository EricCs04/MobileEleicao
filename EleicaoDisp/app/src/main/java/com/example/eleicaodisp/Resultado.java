package com.example.eleicaodisp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {

    TextView tvCandidatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);


        tvCandidatos = findViewById(R.id.tvCandidatos);
        try {
            VarEleitoral varEleitoral = new VarEleitoral();
            String nomesContadores = varEleitoral.getNomeCont();
            tvCandidatos.setText(nomesContadores);
        } catch(Exception e){
            Log.e("Segunda Atividade", "ERRO:", e);
            tvCandidatos.setText("Erro ao carregar dados");
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}