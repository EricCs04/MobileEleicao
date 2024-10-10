package com.example.eleicaodisp;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.stream.IntStream;

public class Login extends AppCompatActivity {

     Button btConectar;
     EditText etUsuario, etSenha;
    public static String[] usuario = {"admin", "entrevistado"};
    public static String[] senha = {"admin" , "entrevistado"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        btConectar = (Button)findViewById(R.id.btConectar);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etSenha = (EditText)findViewById(R.id.etSenha);

        btConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean loginBS= false;

                for (int i = 0; i < usuario.length; i++) {
                    if (etUsuario.getText().toString().equals(usuario[i]) && etSenha.getText().toString().equals(senha[i])) {
                        loginBS = true;
                        if (etUsuario.getText().toString().equals("entrevistado")) {
                            Intent proxPage = new Intent(Login.this, PesqRes.class);
                            startActivity(proxPage);
                            break;
                        }else if (etUsuario.getText().toString().equals("admin")) {
                            Intent res = new Intent(Login.this, Resultado.class);
                            startActivity(res);
                            break;
                        }
                    }
                }
                if(!loginBS){
                    AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                    alertDialog.setTitle("ERRO");
                    alertDialog.setMessage("O Usuário ou Senha está Errado.");
                    alertDialog.show();
                    etSenha.setText("");
                    etUsuario.setText("");
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