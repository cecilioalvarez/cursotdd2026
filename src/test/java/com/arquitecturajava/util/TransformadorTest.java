package com.arquitecturajava.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.arquitecturajava.modelo.Alumno;

// Tests de la funcionalidad común heredada por todos los transformadores
class TransformadorTest {

    @Test
    void transformarFicheroSinNotasDevuelveListaVacia() throws IOException {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Mockito.when(lector.leerLineas("vacio.txt")).thenReturn(List.of(
                "*******************************",
                "*******************************"));
        Transformador transformador = new TransformadorFormato1(lector);

        // Act
        List<Alumno> alumnos = transformador.transformar("vacio.txt");

        // Assert
        assertTrue(alumnos.isEmpty());
    }

    @Test
    void lineaConTresCamposEsLineaDeNota() {

        // Arrange
        Transformador transformador = crearTransformador();

        // Act
        boolean esNota = transformador.esLineaDeNota("antonio,matematicas,7");

        // Assert
        assertTrue(esNota);
    }

    @Test
    void lineaSeparadoraNoEsLineaDeNota() {

        // Arrange
        Transformador transformador = crearTransformador();

        // Act
        boolean esNota = transformador.esLineaDeNota("-------------------------------");

        // Assert
        assertFalse(esNota);
    }

    @Test
    void separarCamposQuitaLosEspacios() {

        // Arrange
        Transformador transformador = crearTransformador();

        // Act
        String[] campos = transformador.separarCampos(" antonio , matematicas , 7 ");

        // Assert
        assertEquals(3, campos.length);
        assertEquals("antonio", campos[0]);
        assertEquals("matematicas", campos[1]);
        assertEquals("7", campos[2]);
    }

    @Test
    void buscarOCrearAlumnoCreaUnAlumnoNuevo() {

        // Arrange
        Transformador transformador = crearTransformador();
        Map<String, Alumno> alumnos = new HashMap<>();

        // Act
        Alumno alumno = transformador.buscarOCrearAlumno("antonio", alumnos);

        // Assert con cross checking
        assertEquals("antonio", alumno.getNombre());
        assertSame(alumno, alumnos.get("antonio"));
    }

    @Test
    void buscarOCrearAlumnoDevuelveElAlumnoExistente() {

        // Arrange
        Transformador transformador = crearTransformador();
        Map<String, Alumno> alumnos = new HashMap<>();
        Alumno antonio = new Alumno("antonio");
        alumnos.put("antonio", antonio);

        // Act
        Alumno alumno = transformador.buscarOCrearAlumno("antonio", alumnos);

        // Assert
        assertSame(antonio, alumno);
        assertEquals(1, alumnos.size());
    }

    // cualquier hija sirve: aquí se prueba la lógica heredada de Transformador
    private Transformador crearTransformador() {
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        return new TransformadorFormato1(lector);
    }
}
