package com.arquitecturajava;

import com.arquitecturajava.modelo.Calculadora;

public class Main {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.sumar(2, 2));
    }
}
