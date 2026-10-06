package com.arquitecturajava.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.arquitecturajava.modelo.Alumno;
import com.arquitecturajava.modelo.Nota;

class ComprobacionesAlumnos {

    private ComprobacionesAlumnos() {
    }

    static void comprobarAlumnosDeNotas(List<Alumno> alumnos) {
        assertEquals(2, alumnos.size());

        Alumno antonio = alumnos.get(0);
        comprobarAlumno(antonio, "antonio", 2);
        comprobarNota(antonio.getNotas().get(0), "matematicas", 7);
        comprobarNota(antonio.getNotas().get(1), "lengua", 5.5);

        Alumno gema = alumnos.get(1);
        comprobarAlumno(gema, "gema", 2);
        comprobarNota(gema.getNotas().get(0), "historia", 9);
        comprobarNota(gema.getNotas().get(1), "lengua", 3);
    }

    static void comprobarAlumno(Alumno alumno, String nombre, int numeroDeNotas) {
        assertEquals(nombre, alumno.getNombre());
        assertEquals(numeroDeNotas, alumno.getNotas().size());
    }

    static void comprobarNota(Nota nota, String asignatura, double valor) {
        assertEquals(asignatura, nota.getAsignatura());
        assertEquals(valor, nota.getValor());
    }
}
