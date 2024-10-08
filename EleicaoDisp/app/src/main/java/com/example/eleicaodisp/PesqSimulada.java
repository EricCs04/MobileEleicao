package com.example.eleicaodisp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesqSimulada extends AppCompatActivity {

    //int kleberBombom, oscarAlho, juliaHRomeu, armandoP, mariana, branco, nulo, indeciso;
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


        btRegSimulada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rbC1.isChecked()){
                  VarEleitoral.adicionarSimulado(rbC1.getText().toString());

                } else if (rbC2.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC2.getText().toString());

                } else if (rbC3.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC3.getText().toString());

                } else if (rbC4.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC4.getText().toString());

                } else if (rbC5.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC5.getText().toString());

                } else if (rbBranco.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbBranco.getText().toString());

                } else if (rbNulo.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbNulo.getText().toString());

                } else if (rbIndeciso.isChecked() || rbNaoSabe.isChecked()) {
                    VarEleitoral.adicionarSimulado("Indeciso ou Não Sabe");
                }

                Intent cadastro = new Intent(PesqSimulada.this, InfoEntrevistado.class);
                startActivity(cadastro);
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