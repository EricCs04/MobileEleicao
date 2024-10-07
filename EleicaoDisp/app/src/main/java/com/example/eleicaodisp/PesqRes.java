package com.example.eleicaodisp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesqRes extends AppCompatActivity {

    Button btnInic;
    ImageButton imgBtVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pesq_res);

        btnInic = findViewById(R.id.btnInic);
        imgBtVoltar = findViewById(R.id.imgBtVoltar);

        imgBtVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(PesqRes.this, Login.class);
                startActivity(back);
                finish();
            }
        });

        btnInic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent begin = new Intent(PesqRes.this, PesqEspont.class);
                startActivity(begin);
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