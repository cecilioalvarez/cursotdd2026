package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class NotaTest {

    @Test
    void aprobadoTest() {

        // Arrange
        Nota nota = new Nota(7, "matematicas");
        // Act
        boolean aprobado = nota.estaAprobada();

        // Assert
        assertTrue(aprobado);
    }

    @Test
    void aprobadoJustoTest() {

        // Arrange
        Nota nota = new Nota(5, "matematicas");
        // Act
        boolean aprobado = nota.estaAprobada();

        // Assert
        assertTrue(aprobado);
    }

    @Test
    void suspensoTest() {

        // Arrange
        Nota nota = new Nota(4.9, "matematicas");
        // Act
        boolean aprobado = nota.estaAprobada();

        // Assert
        assertFalse(aprobado);
    }
    @Test
    void asignarValoresLimiteNota() {

        //Arrange
        Nota nota1= new Nota(10,"matematicas");
        Nota nota2= new Nota(0,"matematicas");
        //Act
        double valor1=nota1.getValor();
        double valor2=nota2.getValor();
    
        //Assert
        assertEquals(10,valor1);
        assertEquals(0, valor2);


    }

    @Test
    void notaNegativaLanzaExcepcion() {

        // Arrange
        double valorNegativo = -1;
        String asignatura = "matematicas";

        // Act
        Executable crearNota = () -> new Nota(valorNegativo, asignatura);

        // Assert
        assertThrows(IllegalArgumentException.class, crearNota);
    }

    @Test
    void notaMayorQueDiezLanzaExcepcion() {

        // Arrange
        double valorMayorQueDiez = 11;
        String asignatura = "matematicas";

        // Act
        Executable crearNota = () -> new Nota(valorMayorQueDiez, asignatura);

        // Assert
        assertThrows(IllegalArgumentException.class, crearNota);
    }
}
