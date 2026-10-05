package com.arquitecturajava.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    // Arrange Act , Assert
    Calculadora c1;

    @BeforeEach 
    void setUp() {
        //Arrange
        c1= new Calculadora();
    }

    @Test
    void sumarDosNumeros() {

        // Arrange
     
        // Act
        double suma = c1.sumar(2, 2);
        // Assert
        assertEquals(4, suma);

    }

    @Test
    void restarDosNumeros() {

        // Arrange
      
        // Act
        double resta = c1.restar(2, 2);
        // Assert
        assertEquals(0, resta);
    }

    @Test
    void multiplicarDosNumeros() {

        // Arrange
    
        // Act
        double multiplicar = c1.multiplicar(2, 4);
        // Assert
        assertEquals(8, multiplicar);
    }
     @Test
    void dividirDosNumeros() {

        // Arrange
      
        // Act
        double division = c1.dividir(4, 2);
        // Assert
        assertEquals(2, division);
    }
}
