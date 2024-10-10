package com.example.eleicaodisp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesqEspont extends AppCompatActivity {

    Button btConEsp;
    EditText etRespEsp;
    private static final int TEMPO_LEITURA = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pesq_espont);


        etRespEsp = findViewById(R.id.etRespEsp);
        btConEsp = findViewById(R.id.btConEsp);



        btConEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etRespEsp.getText().toString().trim().isEmpty()){
                    try{
                        AlertDialog erro = new AlertDialog.Builder(PesqEspont.this).create();
                        erro.setTitle("Erro");
                        erro.setMessage("Precisa inserir um valor");
                        erro.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (erro.isShowing()) {
                                    erro.dismiss(); // Fecha o diálogo
                                }
                            }
                        }, 2000);
                    }catch(Exception e){
                        Log.e("Pesq Espont", "Erro:", e);
                    }
                } else {
                    try {
                        String nome = etRespEsp.getText().toString().trim();
                        VarEleitoral.addNome(nome);
                    } catch (Exception e) {
                        Log.e("Pesq Espont", "Erro:", e);
                    }
                    AlertDialog confirmado = new AlertDialog.Builder(PesqEspont.this).create();
                    confirmado.setTitle("ADICIONADO");
                    confirmado.setMessage(etRespEsp.getText().toString() + " foi adicionado.");
                    confirmado.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent simulado = new Intent(PesqEspont.this, PesqSimulada.class);
                            if (confirmado.isShowing()){
                                confirmado.dismiss();
                            }
                            startActivity(simulado);
                            finish();
                        }
                    }, TEMPO_LEITURA);
                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}