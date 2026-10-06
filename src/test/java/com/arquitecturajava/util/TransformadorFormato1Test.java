package com.arquitecturajava.util;

import static com.arquitecturajava.util.ComprobacionesAlumnos.comprobarAlumnosDeNotas;
import static com.arquitecturajava.util.ComprobacionesAlumnos.comprobarNota;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.arquitecturajava.modelo.Alumno;
import com.arquitecturajava.modelo.Nota;

class TransformadorFormato1Test {

    @Test
    void transformarAgrupaLasNotasPorAlumno() throws IOException {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Mockito.when(lector.leerLineas("notas.txt")).thenReturn(lineasDeNotas());
        Transformador transformador = new TransformadorFormato1(lector);

        // Act
        List<Alumno> alumnos = transformador.transformar("notas.txt");

        // Assert
        comprobarAlumnosDeNotas(alumnos);
    }

    @Test
    void crearNotaFormato1() {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Transformador transformador = new TransformadorFormato1(lector);
        String[] campos = {"antonio", "lengua", "5.5"};

        // Act
        Nota nota = transformador.crearNota(campos);

        // Assert
        comprobarNota(nota, "lengua", 5.5);
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
