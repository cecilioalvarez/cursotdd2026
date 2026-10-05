package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

//Arrange Act , Assert 

    @Test
    void sumarDosNumeros() {
       
        //Arrange 
        Calculadora c1= new Calculadora();
        //Act 
        double suma=c1.sumar(2, 2);
        //Assert
        assertEquals(4, suma);

    }

    @Test
    void restarDosNumeros() {
       
          //Arrange 
        Calculadora c1= new Calculadora();
        //Act 
        double resta=c1.restar(2, 2);
        //Assert
        assertEquals(0, resta);
    }
}

