package com.arquitecturajava.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NotaCalificacionesTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
        "2.9, muy deficiente",
        "3,   insuficiente",
        "5,   aprobado",
        "6,   bien",
        "7,   notable",
        "9,   sobresaliente"
    })
    void calificacionSegunValor(double valor, String calificacionEsperada) {

        // Arrange
        Nota nota = new Nota(valor, "matematicas");

        // Act
        String calificacion = nota.getCalificacion();

        // Assert
        assertEquals(calificacionEsperada, calificacion);
    }
}
