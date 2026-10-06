package com.arquitecturajava.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Clase {

    private String nombre;
    private List<Alumno> alumnos = new ArrayList<>();

    public Clase(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void removeAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }

    public Optional<Nota> getMejorNota() {
        Nota mejorNota = null;
        for (Alumno alumno : alumnos) {
            Optional<Nota> mejorNotaAlumno = alumno.getMejorNota();
            if (mejorNotaAlumno.isPresent()
                    && (mejorNota == null || mejorNotaAlumno.get().getValor() > mejorNota.getValor())) {
                mejorNota = mejorNotaAlumno.get();
            }
        }
        return Optional.ofNullable(mejorNota);
    }
}
