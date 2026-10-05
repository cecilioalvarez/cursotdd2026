package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NotaTest {

    @Test
    void aprobadoTest() {

        //Arrange
        Nota nota= new Nota(7,"matematicas");
        //Act
        boolean aprobado= nota.estaAprobada();

        //Assert
        assertTrue(aprobado);
    }
     @Test
    void aprobadoJustoTest() {

        //Arrange
        Nota nota= new Nota(5,"matematicas");
        //Act
        boolean aprobado= nota.estaAprobada();

        //Assert
        assertTrue(aprobado);
    }
     @Test
    void suspensoTest() {

        //Arrange
        Nota nota= new Nota(4.9,"matematicas");
        //Act
        boolean aprobado= nota.estaAprobada();

        //Assert
        assertFalse(aprobado);
    }
}
