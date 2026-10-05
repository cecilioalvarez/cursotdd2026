package com.arquitecturajava;

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
}
