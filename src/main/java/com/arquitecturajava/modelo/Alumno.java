package com.arquitecturajava.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Optional<Nota> getMejorNota() {
        return notas.stream()
                .max(Comparator.comparingDouble(Nota::getValor));
        //return Optional.of(new Nota (5,"Filosofia"));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Alumno otro = (Alumno) obj;
        return Objects.equals(nombre, otro.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
