package com.arquitecturajava.util;

import com.arquitecturajava.modelo.Nota;

// formato 1: nombre,asignatura,valor
public class TransformadorFormato1 extends Transformador {

    public TransformadorFormato1(LectorFichero lector) {
        super(lector);
    }

    @Override
    Nota crearNota(String[] campos) {
        String asignatura = campos[1];
        double valor = Double.parseDouble(campos[2]);
        return new Nota(valor, asignatura);
    }
}
