package com.arquitecturajava.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {

    private String nombre;
    private List<Nota> notas = new ArrayList<>();

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void addNota(Nota nota) {
        notas.add(nota);
    }

    public void removeNota(Nota nota) {
        notas.remove(nota);
    }

    public double getNotaMedia() {
        return notas.stream()
                .mapToDouble(Nota::getValor)
                .average()
                .orElse(0);
    }
}
