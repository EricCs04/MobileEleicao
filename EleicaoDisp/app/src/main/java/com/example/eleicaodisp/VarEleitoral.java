package com.example.eleicaodisp;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class VarEleitoral {

    private static HashMap<String, Integer> contadorNomes = new HashMap<>();
    private static HashMap<String, Integer> contadorSimulado = new HashMap<>();
    private static int kleberBombom, oscarAlho, juliaHRomeu, armandoP, mariana, branco, nulo, indeciso;


    public VarEleitoral() {
        contadorSimulado.put("Cléber Bombom",0);
        contadorSimulado.put("Oscar Alho",0);
        contadorSimulado.put("Julia H romeu",0);
        contadorSimulado.put("Armando P",0);
        contadorSimulado.put("Mariana",0);
        contadorSimulado.put("Branco",0);
        contadorSimulado.put("Nulo",0);
        contadorSimulado.put("Indeciso ou Não Sabe",0);

    }

    public static void addNome(String nome) {
        if (nome!=null) {
            if (contadorNomes.containsKey(nome)) {
                contadorNomes.put(nome, contadorNomes.get(nome) + 1);
            } else {
                contadorNomes.put(nome, 1);
            }
        }
    }

    public static void adicionarSimulado (String nome){
        if (nome!=null){
                contadorSimulado.put(nome, contadorSimulado.get(nome) + 1);
        }
    }

    public static String getNomeSimulado(){
        StringBuilder simulado = new StringBuilder();

        for(Map.Entry<String, Integer> entrada: contadorSimulado.entrySet()){
            simulado.append(entrada.getKey()).append(": ").append(entrada.getValue()).append("\n");
        }
        Log.e("TESTANDO ESCRITA", simulado.toString());
        return simulado.toString();
    }


    public static String getNomeCont(){
        StringBuilder candidato = new StringBuilder();

        for (Map.Entry<String, Integer> entrada: contadorNomes.entrySet()){
            candidato.append(entrada.getKey()).append(": ").append(entrada.getValue()).append("\n");
        }
        return candidato.toString();
    }


}
