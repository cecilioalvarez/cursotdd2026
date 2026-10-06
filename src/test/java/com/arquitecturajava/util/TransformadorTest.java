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
import com.arquitecturajava.modelo.Nota;

class TransformadorTest {

    @Test
    void transformarAgrupaLasNotasPorAlumno() throws IOException {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Mockito.when(lector.leerLineas("notas.txt")).thenReturn(lineasDeNotas());
        Transformador transformador = new Transformador(lector);

        // Act
        List<Alumno> alumnos = transformador.transformar("notas.txt");

        // Assert con cross checking
        assertEquals(2, alumnos.size());

        Alumno antonio = alumnos.get(0);
        List<Nota> notasAntonio = antonio.getNotas();
        Nota matematicasAntonio = notasAntonio.get(0);
        Nota lenguaAntonio = notasAntonio.get(1);

        assertEquals("antonio", antonio.getNombre());
        assertEquals(2, notasAntonio.size());
        assertEquals("matematicas", matematicasAntonio.getAsignatura());
        assertEquals(7, matematicasAntonio.getValor());
        assertEquals("lengua", lenguaAntonio.getAsignatura());
        assertEquals(5.5, lenguaAntonio.getValor());

        Alumno gema = alumnos.get(1);
        List<Nota> notasGema = gema.getNotas();
        Nota historiaGema = notasGema.get(0);
        Nota lenguaGema = notasGema.get(1);

        assertEquals("gema", gema.getNombre());
        assertEquals(2, notasGema.size());
        assertEquals("historia", historiaGema.getAsignatura());
        assertEquals(9, historiaGema.getValor());
        assertEquals("lengua", lenguaGema.getAsignatura());
        assertEquals(3, lenguaGema.getValor());
    }

    @Test
    void transformarFicheroSinNotasDevuelveListaVacia() throws IOException {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Mockito.when(lector.leerLineas("vacio.txt")).thenReturn(List.of(
                "*******************************",
                "*******************************"));
        Transformador transformador = new Transformador(lector);

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

    private Transformador crearTransformador() {
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        return new Transformador(lector);
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
