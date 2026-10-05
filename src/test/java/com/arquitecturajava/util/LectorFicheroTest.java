package com.arquitecturajava.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class LectorFicheroTest {

    @Test
    void leerLineasDevuelveTodasLasLineasDelFichero() throws IOException {

        // Arrange
        LectorFichero lector = new LectorFichero();
        String ruta = "src/test/resources/notas.txt";
        List<String> lineasEsperadas = lineasDeNotas();

        // Act
        List<String> lineas = lector.leerLineas(ruta);

        // Assert con cross checking
        assertEquals(7, lineas.size());
        assertEquals(lineasEsperadas, lineas);
    }

    @Test
    void leerFicheroQueNoExisteLanzaExcepcion() {

        // Arrange
        LectorFichero lector = new LectorFichero();
        String ruta = "src/test/resources/no_existe.txt";

        // Act
        Executable leerFichero = () -> lector.leerLineas(ruta);

        // Assert
        assertThrows(IOException.class, leerFichero);
    }

    private List<String> lineasDeNotas() {
        return List.of(
                "*******************************",
                "antonio,matematicas,7",
                "antonio,lengua,5.5",
                "-------------------------------",
                "gema,historia,9",
                "gema,lengua,3",
                "*******************************");
    }
}
