package com.arquitecturajava.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClaseTest {

    @Test
    void addAlumnoClase() {

        // Arrange
        Clase clase = new Clase("1A");
        Alumno alumno = new Alumno("Ana");

        // Act
        clase.addAlumno(alumno);

        // Assert con cross checking
        assertEquals(1, clase.getAlumnos().size());
        assertTrue(clase.getAlumnos().contains(alumno));
    }

    @Test
    void removeAlumnoSoloQuitaElAlumnoIndicado() {

        // Arrange
        Alumno ana = new Alumno("Ana");
        Alumno pedro = new Alumno("Pedro");
        Clase clase = new Clase("1A");
        clase.addAlumno(ana);
        clase.addAlumno(pedro);

        // Act
        clase.removeAlumno(ana);

        // Assert con cross checking
        assertFalse(clase.getAlumnos().contains(ana));
        assertTrue(clase.getAlumnos().contains(pedro));
    }

    @Test
    void mejorNotaDeTodosLosAlumnos() {

        Alumno ana = Mockito.mock(Alumno.class);
        Nota nota1 = new Nota(7, "lengua");
        Mockito.when(ana.getMejorNota()).thenReturn(Optional.of(nota1));

        Alumno juan = Mockito.mock(Alumno.class);
        Nota nota2 = new Nota(9, "matematicas");
        Mockito.when(juan.getMejorNota()).thenReturn(Optional.of(nota2));

        // Arrange
        /*
         * Alumno ana = new Alumno("Ana");
         * ana.addNota(new Nota(7, "matematicas"));
         * ana.addNota(new Nota(5, "lengua"));
         
        Alumno pedro = new Alumno("Pedro");
        pedro.addNota(new Nota(9.5, "historia"));
        pedro.addNota(new Nota(4, "matematicas"));
        */


        Clase clase = new Clase("1A");
        clase.addAlumno(ana);
        clase.addAlumno(juan);

        // Act
        Optional<Nota> mejorNota = clase.getMejorNota();

        // Assert
        assertEquals(Optional.of(new Nota(9, "matematicas")), mejorNota);
    }

    @Test
    void mejorNotaIgnoraAlumnosSinNotas() {


        Alumno ana = Mockito.mock(Alumno.class);
        Nota nota1 = new Nota(7, "lengua");
        Mockito.when(ana.getMejorNota()).thenReturn(Optional.of(nota1));

        // lista vacia de notas
        Alumno juan = Mockito.mock(Alumno.class);
        Mockito.when(juan.getMejorNota()).thenReturn(Optional.empty());
     
       
        Clase clase = new Clase("1A");
        clase.addAlumno(ana);
        clase.addAlumno(juan);

        // Act
        Optional<Nota> mejorNota = clase.getMejorNota();

        // Assert
        assertEquals(Optional.of(new Nota(7, "lengua")), mejorNota);
    }

    @Test
    void mejorNotaDeClaseSinAlumnosEstaVacia() {

        // Arrange
        Clase clase = new Clase("1A");

        // Act
        Optional<Nota> mejorNota = clase.getMejorNota();

        // Assert
        assertTrue(mejorNota.isEmpty());
    }
}
