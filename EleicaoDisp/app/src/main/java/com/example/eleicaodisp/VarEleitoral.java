package com.example.eleicaodisp;

import java.util.HashMap;
import java.util.Map;

public class VarEleitoral {

    private static HashMap<String, Integer> contadorNomes = new HashMap<>();

    public VarEleitoral() {
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

    public static String getNomeCont(){
        StringBuilder candidato = new StringBuilder();

        for (Map.Entry<String, Integer> entrada: contadorNomes.entrySet()){
            candidato.append(entrada.getKey()).append(": ").append(entrada.getValue()).append("\n");
        }
        return candidato.toString();
    }


}
