package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void sumarDosNumeros() {
        assertEquals(5, Calculadora.sumar(2, 3));
    }
}
