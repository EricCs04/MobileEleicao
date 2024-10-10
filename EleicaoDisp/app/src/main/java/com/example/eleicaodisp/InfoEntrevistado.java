package com.example.eleicaodisp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class InfoEntrevistado extends AppCompatActivity {

    private Button btCadastroInfo;
    private EditText etEntNome, etEntCivil, etEntNum, etEntIdade, etEntSexo, etEntDia, etEntHora;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info_entrevistado);




        btCadastroInfo = findViewById(R.id.btCadastroInfo);
        etEntNome = findViewById(R.id.etEntNome);
        etEntCivil = findViewById(R.id.etEntCivil);
        etEntNum = findViewById(R.id.etEntNum);
        etEntIdade = findViewById(R.id.etEntIdade);
        etEntSexo = findViewById(R.id.etEntSexo);
        etEntDia = findViewById(R.id.etEntDia);
        etEntHora = findViewById(R.id.etEntHora);



        etEntDia.addTextChangedListener(new TextWatcher() {
            private boolean isUpdating;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isUpdating) {
                    isUpdating = false;
                    return;
                }
                String str;
                str = charSequence.toString().replaceAll("[^\\d]", "");
                StringBuilder formatted = new StringBuilder();
                if (str.length() > 2) {
                    formatted.append(str.substring(0, 2)).append("/");
                    if (str.length() > 4) {
                        formatted.append(str.substring(2, 4)).append("/");
                        if (str.length() > 8) {
                            formatted.append(str.substring(4, 8));
                        } else {
                            formatted.append(str.substring(4));
                        }
                    } else {
                        formatted.append(str.substring(2));
                    }
                } else {
                    formatted.append(str);
                }

                isUpdating = true;
                etEntDia.setText(formatted.toString());
                etEntDia.setSelection(formatted.length());
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        btCadastroInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEntNome.getText().toString().trim().isEmpty()){
                    AlertDialog alerta = new AlertDialog.Builder(InfoEntrevistado.this).create();
                    alerta.setTitle("Nao Cadastrado");
                    alerta.setMessage("O entrevistado não se cadastrou");
                    alerta.show();
                }else {
                    DadosEntrevistado entr = new DadosEntrevistado(etEntNome.getText().toString().trim(), etEntCivil.getText().toString().trim(), etEntNum.getText().toString().trim(), Integer.parseInt(etEntIdade.getText().toString()),
                            etEntSexo.getText().toString().trim(), etEntDia.getText().toString().trim(), etEntHora.getText().toString().trim());
                    DadosEntrevistado.adicionarDados(entr);

                    Intent conclusao = new Intent(InfoEntrevistado.this, PesqRes.class);
                    startActivity(conclusao);
                    finish();
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