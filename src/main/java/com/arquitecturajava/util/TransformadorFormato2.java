package com.arquitecturajava.util;

import com.arquitecturajava.modelo.Nota;

// formato 2: nombre,valor,asignatura
public class TransformadorFormato2 extends Transformador {

    public TransformadorFormato2(LectorFichero lector) {
        super(lector);
    }

    @Override
    Nota crearNota(String[] campos) {
        double valor = Double.parseDouble(campos[1]);
        String asignatura = campos[2];
        return new Nota(valor, asignatura);
    }
}
