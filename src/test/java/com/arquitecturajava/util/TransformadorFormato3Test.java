package com.arquitecturajava.util;

import static com.arquitecturajava.util.ComprobacionesAlumnos.comprobarAlumnosDeNotas;
import static com.arquitecturajava.util.ComprobacionesAlumnos.comprobarNota;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.arquitecturajava.modelo.Alumno;
import com.arquitecturajava.modelo.Nota;

class TransformadorFormato3Test {

    @Test
    void transformarAgrupaLasNotasPorAlumno() throws IOException {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Mockito.when(lector.leerLineas("nota3.txt")).thenReturn(lineasDeNotasFormato3());
        Transformador transformador = new TransformadorFormato3(lector);

        // Act
        List<Alumno> alumnos = transformador.transformar("nota3.txt");

        // Assert
        comprobarAlumnosDeNotas(alumnos);
    }

    @Test
    void crearNotaFormato3() {

        // Arrange
        TransformadorFormato3 transformador = crearTransformador();
        String[] campos = {"5.5", "lengua"};

        // Act
        Nota nota = transformador.crearNota(campos);

        // Assert
        comprobarNota(nota, "lengua", 5.5);
    }

    @Test
    void separarCamposDeLineaDeNota() {

        // Arrange
        TransformadorFormato3 transformador = crearTransformador();

        // Act
        String[] campos = transformador.separarCampos("|7|matematicas");

        // Assert
        assertEquals(2, campos.length);
        assertEquals("7", campos[0]);
        assertEquals("matematicas", campos[1]);
    }

    @Test
    void lineaQueEmpiezaPorBarraEsLineaDeNota() {

        // Arrange
        TransformadorFormato3 transformador = crearTransformador();

        // Act
        boolean esNota = transformador.esLineaDeNota("|7|matematicas");

        // Assert
        assertTrue(esNota);
    }

    @Test
    void lineaConNombreEsLineaDeAlumno() {

        // Arrange
        TransformadorFormato3 transformador = crearTransformador();

        // Act
        boolean esAlumno = transformador.esLineaDeAlumno("antonio");

        // Assert
        assertTrue(esAlumno);
    }

    @Test
    void lineaSeparadoraNoEsLineaDeAlumno() {

        // Arrange
        TransformadorFormato3 transformador = crearTransformador();

        // Act
        boolean esAlumno = transformador.esLineaDeAlumno("//////////////////////////////");

        // Assert
        assertFalse(esAlumno);
    }

    private TransformadorFormato3 crearTransformador() {
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        return new TransformadorFormato3(lector);
    }

    private List<String> lineasDeNotasFormato3() {
        return List.of(
                "*******************************",
                "antonio",
                "|7|matematicas",
                "|5.5|lengua",
                "//////////////////////////////",
                "gema",
                "|9|historia",
                "|3|lengua",
                "******************************",
                "");
    }
}
