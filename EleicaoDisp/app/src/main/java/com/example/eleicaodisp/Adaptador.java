package com.example.eleicaodisp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<DadosEntrevistado> listaEntrevistados;

    public Adaptador(ArrayList<DadosEntrevistado> listaEntrevistados) {
        this.listaEntrevistados = listaEntrevistados;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DadosEntrevistado entrevistado = listaEntrevistados.get(position);
        holder.bind(entrevistado);
    }

    @Override
    public int getItemCount() {
        return listaEntrevistados.size();
    }
}
