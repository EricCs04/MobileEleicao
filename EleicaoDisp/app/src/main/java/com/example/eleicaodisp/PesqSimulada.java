package com.example.eleicaodisp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesqSimulada extends AppCompatActivity {

    RadioButton rbC1, rbC2, rbC3, rbC4, rbC5, rbBranco, rbNulo, rbIndeciso, rbNaoSabe;
    Button btRegSimulada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pesq_simulada);

        rbC1 = findViewById(R.id.rbC1);
        rbC2 = findViewById(R.id.rbC2);
        rbC3 = findViewById(R.id.rbC3);
        rbC4 = findViewById(R.id.rbC4);
        rbC5 = findViewById(R.id.rbC5);
        rbBranco = findViewById(R.id.rbBranco);
        rbNulo = findViewById(R.id.rbNulo);
        rbIndeciso = findViewById(R.id.rbIndeciso);
        rbNaoSabe = findViewById(R.id.rbNaosabe);
        btRegSimulada = findViewById(R.id.btRegSimulada);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}