package com.arquitecturajava.util;

import java.util.Map;

import com.arquitecturajava.modelo.Alumno;
import com.arquitecturajava.modelo.Nota;

// formato 3: una línea con el nombre y debajo sus notas como |valor|asignatura
public class TransformadorFormato3 extends Transformador {

    public TransformadorFormato3(LectorFichero lector) {
        super(lector);
    }

    @Override
    Alumno procesarLinea(String linea, Map<String, Alumno> alumnos, Alumno alumnoActual) {
        if (esLineaDeNota(linea)) {
            alumnoActual.addNota(crearNota(separarCampos(linea)));
            return alumnoActual;
        }
        if (esLineaDeAlumno(linea)) {
            return buscarOCrearAlumno(linea.trim(), alumnos);
        }
        return alumnoActual;
    }

    @Override
    boolean esLineaDeNota(String linea) {
        return linea.trim().startsWith("|");
    }

    boolean esLineaDeAlumno(String linea) {
        return !linea.isBlank() && Character.isLetter(linea.trim().charAt(0));
    }

    @Override
    String[] separarCampos(String linea) {
        String[] campos = linea.trim().substring(1).split("\\|");
        for (int i = 0; i < campos.length; i++) {
            campos[i] = campos[i].trim();
        }
        return campos;
    }

    @Override
    Nota crearNota(String[] campos) {
        double valor = Double.parseDouble(campos[0]);
        String asignatura = campos[1];
        return new Nota(valor, asignatura);
    }
}
