package com.example.eleicaodisp;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class VarEleitoral {

    private static HashMap<String, Integer> contadorNomes = new HashMap<>();
    private static HashMap<String, Integer> contadorSimulado = new HashMap<>();

    static {
        contadorSimulado.put("Cléber Bombom", 0);
        contadorSimulado.put("Oscar Olho", 0);
        contadorSimulado.put("Julia H romeu", 0);
        contadorSimulado.put("Armando P", 0);
        contadorSimulado.put("Mariana", 0);
        contadorSimulado.put("Branco", 0);
        contadorSimulado.put("Nulo", 0);
        contadorSimulado.put("Indeciso ou Não Sabe", 0);
    }



    public VarEleitoral() {}

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
        int total = getVotosSimulado();

        for(Map.Entry<String, Integer> entrada: contadorSimulado.entrySet()){
            double porcentagemCandidato = (entrada.getValue() * 100.0) / total;
            simulado.append(entrada.getKey()).append("- Votos: ").append(entrada.getValue()).append(String.format(" - %.2f", porcentagemCandidato)).append("%\n");
        }
        Log.e("TESTANDO ESCRITA", simulado.toString());
        return simulado.toString();
    }


    public static String getNomeCont(){
        StringBuilder candidato = new StringBuilder();
        int total = getVotosEspontaneo();

        for (Map.Entry<String, Integer> entrada: contadorNomes.entrySet()){
            double porcEspontaneo = (entrada.getValue()* 100.0)/total;
            candidato.append(entrada.getKey()).append("- Votos: ").append(entrada.getValue()).append(String.format(" - %.2f", porcEspontaneo)).append("%\n");
        }
        return candidato.toString();
    }


    public static int getVotosSimulado() {
        int total = 0;
        for (int votos : contadorSimulado.values()) {
            total += votos;
        }
        return total;
    }

    public static int getVotosEspontaneo() {
        int total = 0;
        for (int votos : contadorNomes.values()) {
            total += votos;
        }
        return total;
    }

}
