package com.example.eleicaodisp;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder{

    TextView nome, civil, numero, idade, sexo, dia, hora;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.tvNome);
        civil = itemView.findViewById(R.id.tvEstadoCivil);
        numero = itemView.findViewById(R.id.tvNumero);
        idade = itemView.findViewById(R.id.tvIdade);
        sexo = itemView.findViewById(R.id.tvSexo);
        dia = itemView.findViewById(R.id.tvDia);
        hora = itemView.findViewById(R.id.tvHora);
    }

    public void bind(DadosEntrevistado entrevistado) {
        nome.setText(entrevistado.getNome());
        civil.setText(entrevistado.getEstadoCivil());
        numero.setText(entrevistado.getNumero());
        idade.setText(String.valueOf(entrevistado.getIdade()));
        sexo.setText(entrevistado.getSexo());
        dia.setText(entrevistado.getDia());
        hora.setText(entrevistado.getHora());
    }
}
