package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AlumnoTest {

    @Test
    void addNotaAlumno() {

        // Arrange
        Alumno alumno = new Alumno("Ana");
        Nota nota = new Nota(7, "matematicas");

        // Act
        alumno.addNota(nota);

        // Assert con cross checking
        assertEquals(1, alumno.getNotas().size());
        assertTrue(alumno.getNotas().contains(nota));
    }

    @Test
    void removeNotaSoloQuitaLaNotaIndicada() {

        // Arrange
        Nota nota1 = new Nota(7, "matematicas");
        Nota nota2 = new Nota(5, "lengua");
        Alumno alumno = crearAlumnoConNotas(nota1, nota2);

        // Act
        alumno.removeNota(nota1);

        // Assert
        assertFalse(alumno.getNotas().contains(nota1));
        assertTrue(alumno.getNotas().contains(nota2));
    }

    @Test
    void removeNotaIgualQuitaLaNotaDelAlumno() {

        // Arrange
        Alumno alumno = crearAlumnoConNotas(new Nota(7, "matematicas"));

        // Act
        alumno.removeNota(new Nota(7, "matematicas"));

        // Assert
        assertTrue(alumno.getNotas().isEmpty());
    }

    @Test
    void notaMediaDeVariasNotas() {

        // Arrange
        Alumno alumno = crearAlumnoConNotas(
                new Nota(7, "matematicas"),
                new Nota(8, "lengua"),
                new Nota(3, "historia"));

        // Act
        double media = alumno.getNotaMedia();

        // Assert
        assertEquals(6, media);
    }

    @Test
    void notaMediaConDecimales() {

        // Arrange
        Alumno alumno = crearAlumnoConNotas(
                new Nota(7, "matematicas"),
                new Nota(8, "lengua"));

        // Act
        double media = alumno.getNotaMedia();

        // Assert
        assertEquals(7.5, media);
    }

    @Test
    void notaMediaSinNotasEsCero() {

        // Arrange
        Alumno alumno = new Alumno("Ana");

        // Act
        double media = alumno.getNotaMedia();

        // Assert
        assertEquals(0, media);
    }

    private Alumno crearAlumnoConNotas(Nota... notas) {
        Alumno alumno = new Alumno("Ana");
        for (Nota nota : notas) {
            alumno.addNota(nota);
        }
        return alumno;
    }
}
