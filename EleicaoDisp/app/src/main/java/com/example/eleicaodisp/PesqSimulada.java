package com.example.eleicaodisp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesqSimulada extends AppCompatActivity {


    RadioButton rbC1, rbC2, rbC3, rbC4, rbC5, rbBranco, rbNulo, rbIndeciso, rbNaoSabe;
    Button btRegSimulada;
    private static final int TEMPO_DELAY = 1000;

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
                    try {
                        String nome = rbC1.getText().toString();
                        VarEleitoral.adicionarSimulado(nome);

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                } else if (rbC2.isChecked()) {
                    try {
                        String nome = rbC2.getText().toString().trim();
                        VarEleitoral.adicionarSimulado(nome);

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                } else if (rbC3.isChecked()) {
                    try {
                        String nome = rbC3.getText().toString().trim();
                        VarEleitoral.adicionarSimulado(nome);

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                } else if (rbC4.isChecked()) {
                    try {
                        String nome = rbC4.getText().toString().trim();
                        VarEleitoral.adicionarSimulado(nome);

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                } else if (rbC5.isChecked()) {
                    try {
                        String nome = rbC5.getText().toString().trim();
                        VarEleitoral.adicionarSimulado(nome);

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                } else if (rbBranco.isChecked()) {
                    try {
                        String nome = rbBranco.getText().toString().trim();
                        VarEleitoral.adicionarSimulado(nome);

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                } else if (rbNulo.isChecked()) {
                    try {
                        String nome = rbNulo.getText().toString();
                        VarEleitoral.adicionarSimulado(nome);

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                } else if (rbIndeciso.isChecked() || rbNaoSabe.isChecked()) {
                    try {
                        VarEleitoral.adicionarSimulado("Indeciso ou Não Sabe");

                        proxAtividade();
                    }catch(Exception e){
                        Log.e("PesqSimulada", "Erro", e);
                    }
                }else{
                    AlertDialog erro = new AlertDialog.Builder(PesqSimulada.this).create();
                    erro.setTitle("ERRO");
                    erro.setTitle("É necessário selecionar uma da opções!");
                }

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void proxAtividade (){
        AlertDialog confirmado = new AlertDialog.Builder(PesqSimulada.this).create();
        confirmado.setTitle("ADICIONADO");
        confirmado.setMessage("Seu voto foi adicionado.");
        confirmado.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent cadastro = new Intent(PesqSimulada.this, InfoEntrevistado.class);
                if (confirmado.isShowing()){
                    confirmado.dismiss();
                }
                startActivity(cadastro);
                finish();
            }
        }, TEMPO_DELAY);
    }

}