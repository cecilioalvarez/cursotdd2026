package com.arquitecturajava.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.arquitecturajava.modelo.Alumno;
import com.arquitecturajava.modelo.Nota;

public abstract class Transformador {

    private LectorFichero lector;

    protected Transformador(LectorFichero lector) {
        this.lector = lector;
    }

    public List<Alumno> transformar(String ruta) throws IOException {
        Map<String, Alumno> alumnos = new LinkedHashMap<>();
        Alumno alumnoActual = null;
        for (String linea : lector.leerLineas(ruta)) {
            alumnoActual = procesarLinea(linea, alumnos, alumnoActual);
        }
        return new ArrayList<>(alumnos.values());
    }

    boolean esLineaDeNota(String linea) {
        return separarCampos(linea).length == 3;
    }

    // devuelve el alumno actual, para los formatos en los que una nota
    // depende de un alumno leído en una línea anterior
    Alumno procesarLinea(String linea, Map<String, Alumno> alumnos, Alumno alumnoActual) {
        if (!esLineaDeNota(linea)) {
            return alumnoActual;
        }
        String[] campos = separarCampos(linea);
        String nombre = campos[0];
        Alumno alumno = buscarOCrearAlumno(nombre, alumnos);
        alumno.addNota(crearNota(campos));
        return alumno;
    }

    String[] separarCampos(String linea) {
        String[] campos = linea.split(",");
        for (int i = 0; i < campos.length; i++) {
            campos[i] = campos[i].trim();
        }
        return campos;
    }

    abstract Nota crearNota(String[] campos);

    Alumno buscarOCrearAlumno(String nombre, Map<String, Alumno> alumnos) {
        Alumno alumno = alumnos.get(nombre);
        if (alumno == null) {
            alumno = new Alumno(nombre);
            alumnos.put(nombre, alumno);
        }
        return alumno;
    }
}
