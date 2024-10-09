package com.example.eleicaodisp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
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

    //int kleberBombom, oscarAlho, juliaHRomeu, armandoP, mariana, branco, nulo, indeciso;
    RadioButton rbC1, rbC2, rbC3, rbC4, rbC5, rbBranco, rbNulo, rbIndeciso, rbNaoSabe;
    Button btRegSimulada;
    private static final int TEMPO_DELAY = 500;

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
                //Possivel fazer com switch case(Possivelmente melhor)
                if(rbC1.isChecked()){
                    try {
                        VarEleitoral.adicionarSimulado(rbC1.getText().toString());
                        proxAtividade();
                    }catch(Exception e){

                    }
                } else if (rbC2.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC2.getText().toString());
                    proxAtividade();
                } else if (rbC3.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC3.getText().toString());
                    proxAtividade();
                } else if (rbC4.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC4.getText().toString());
                    proxAtividade();
                } else if (rbC5.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbC5.getText().toString());
                    proxAtividade();
                } else if (rbBranco.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbBranco.getText().toString());
                    proxAtividade();
                } else if (rbNulo.isChecked()) {
                    VarEleitoral.adicionarSimulado(rbNulo.getText().toString());
                    proxAtividade();
                } else if (rbIndeciso.isChecked() || rbNaoSabe.isChecked()) {
                    VarEleitoral.adicionarSimulado("Indeciso ou Não Sabe");
                    proxAtividade();
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent cadastro = new Intent(PesqSimulada.this, InfoEntrevistado.class);
                startActivity(cadastro);
                finish();
            }
        }, TEMPO_DELAY);
    }

}