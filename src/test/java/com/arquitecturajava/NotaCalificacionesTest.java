package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NotaCalificacionesTest {

    @Test
    void calificacionMuyDeficiente() {

        // Arrange
        Nota nota = new Nota(2.9, "matematicas");

        // Act
        String calificacion = nota.getCalificacion();

        // Assert
        assertEquals("muy deficiente", calificacion);
    }

    @Test
    void calificacionInsuficiente() {

        // Arrange
        Nota nota = new Nota(3, "matematicas");

        // Act
        String calificacion = nota.getCalificacion();

        // Assert
        assertEquals("insuficiente", calificacion);
    }

    @Test
    void calificacionAprobado() {

        // Arrange
        Nota nota = new Nota(5, "matematicas");

        // Act
        String calificacion = nota.getCalificacion();

        // Assert
        assertEquals("aprobado", calificacion);
    }

    @Test
    void calificacionBien() {

        // Arrange
        Nota nota = new Nota(6, "matematicas");

        // Act
        String calificacion = nota.getCalificacion();

        // Assert
        assertEquals("bien", calificacion);
    }

    @Test
    void calificacionNotable() {

        // Arrange
        Nota nota = new Nota(7, "matematicas");

        // Act
        String calificacion = nota.getCalificacion();

        // Assert
        assertEquals("notable", calificacion);
    }

    @Test
    void calificacionSobresaliente() {

        // Arrange
        Nota nota = new Nota(9, "matematicas");

        // Act
        String calificacion = nota.getCalificacion();

        // Assert
        assertEquals("sobresaliente", calificacion);
    }
}
