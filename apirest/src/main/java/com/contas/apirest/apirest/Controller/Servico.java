package com.contas.apirest.apirest.Controller;


public class Servico {
    public static void main(String[] args) {
        
        double[] numeros = new double[6];

        numeros[0] = 3.5;
        numeros[1] = 2;
        numeros[2] = 3;
        numeros[3] = 14;
        numeros[4] = 36;
        numeros[5] = 45;

        double calc = 0;
    
        for(int soma = 0; soma < numeros.length; soma++){

            calc += numeros[soma];
        }
        System.out.println(calc);
    }
}
