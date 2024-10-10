package com.example.eleicaodisp;

import java.util.ArrayList;

public class DadosEntrevistado {

    private static ArrayList<DadosEntrevistado> listaEntrevistados = new ArrayList<>();
    private String nome;
    private String estadoCivil;
    private String numero;
    private int idade;
    private String sexo;
    private String dia;
    private String hora;

    public DadosEntrevistado(String nome, String estadoCivil, String numero, int idade, String sexo, String dia, String hora) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.numero = numero;
        this.idade = idade;
        this.sexo = sexo;
        this.dia = dia;
        this.hora = hora;
    }
    public static void adicionarDados(DadosEntrevistado dados) {
        listaEntrevistados.add(dados);
    }

    public static ArrayList<DadosEntrevistado> getListaEntrevistados() {
        return listaEntrevistados;
    }


    public String getNome() {
        return nome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getNumero() {
        return numero;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }
}
