package com.arquitecturajava.util;

import static com.arquitecturajava.util.ComprobacionesAlumnos.comprobarAlumnosDeNotas;
import static com.arquitecturajava.util.ComprobacionesAlumnos.comprobarNota;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.arquitecturajava.modelo.Alumno;
import com.arquitecturajava.modelo.Nota;

class TransformadorFormato2Test {

    @Test
    void transformarAgrupaLasNotasPorAlumno() throws IOException {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Mockito.when(lector.leerLineas("nota2.txt")).thenReturn(lineasDeNotasFormato2());
        Transformador transformador = new TransformadorFormato2(lector);

        // Act
        List<Alumno> alumnos = transformador.transformar("nota2.txt");

        // Assert
        comprobarAlumnosDeNotas(alumnos);
    }

    @Test
    void crearNotaFormato2() {

        // Arrange
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        Transformador transformador = new TransformadorFormato2(lector);
        String[] campos = {"antonio", "5.5", "lengua"};

        // Act
        Nota nota = transformador.crearNota(campos);

        // Assert
        comprobarNota(nota, "lengua", 5.5);
    }

    private List<String> lineasDeNotasFormato2() {
        return List.of(
                "+++++++++++++++++++++++++++++++",
                "antonio,7,matematicas",
                "antonio,5.5,lengua",
                "//////////////////////////////",
                "gema,9,historia",
                "gema,3,lengua",
                "+++++++++++++++++++++++++++++++");
    }
}
