package com.arquitecturajava.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

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
    void notaMediaConDecimalesPeriodicos() {

        // Arrange
        Alumno alumno = crearAlumnoConNotas(
                new Nota(7, "matematicas"),
                new Nota(8, "lengua"),
                new Nota(8, "historia"));

        // Act
        double media = alumno.getNotaMedia();

        // Assert
        assertEquals(7.67, media, 0.01);
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

    @Test
    void mejorNotaDeVariasNotas() {

        // Arrange
        Alumno alumno = crearAlumnoConNotas(
                new Nota(7, "matematicas"),
                new Nota(9.5, "lengua"),
                new Nota(3, "historia"));

        // Act
        Optional<Nota> mejorNota = alumno.getMejorNota();

        // Assert con cross checking
        assertEquals(Optional.of(new Nota(9.5, "lengua")), mejorNota);
        assertEquals("lengua", mejorNota.get().getAsignatura());
    }

    @Test
    void mejorNotaSinNotasEstaVacia() {

        // Arrange
        Alumno alumno = new Alumno("Ana");

        // Act
        Optional<Nota> mejorNota = alumno.getMejorNota();

        // Assert
        assertTrue(mejorNota.isEmpty());
    }

    @Test
    void alumnosConMismoNombreSonIguales() {

        // Arrange
        Alumno alumno1 = new Alumno("Ana");
        Alumno alumno2 = new Alumno("Ana");

        // Act
        boolean iguales = alumno1.equals(alumno2);

        // Assert
        assertTrue(iguales);
    }

    @Test
    void alumnosConDistintoNombreNoSonIguales() {

        // Arrange
        Alumno alumno1 = new Alumno("Ana");
        Alumno alumno2 = new Alumno("Pedro");

        // Act
        boolean iguales = alumno1.equals(alumno2);

        // Assert
        assertFalse(iguales);
    }

    @Test
    void alumnoNoEsIgualANull() {

        // Arrange
        Alumno alumno = new Alumno("Ana");

        // Act
        boolean iguales = alumno.equals(null);

        // Assert
        assertFalse(iguales);
    }

    @Test
    void alumnosIgualesTienenElMismoHashCode() {

        // Arrange
        Alumno alumno1 = new Alumno("Ana");
        Alumno alumno2 = new Alumno("Ana");

        // Act
        int hash1 = alumno1.hashCode();
        int hash2 = alumno2.hashCode();

        // Assert
        assertEquals(hash1, hash2);
    }

    private Alumno crearAlumnoConNotas(Nota... notas) {
        Alumno alumno = new Alumno("Ana");
        for (Nota nota : notas) {
            alumno.addNota(nota);
        }
        return alumno;
    }
}
