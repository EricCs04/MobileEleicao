package com.example.eleicaodisp;



import android.provider.Settings;

public class CadLogin {

    public static String[] usuario = {"admin", "entrevistado"};
    public static String[] senha = {"admin" , "entrevistado"};


    public String[] getUsuario() {
        return usuario;
    }

    public String[] getSenha() {
        return senha;
    }
}
