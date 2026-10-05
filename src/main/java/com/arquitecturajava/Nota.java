package com.arquitecturajava;

import java.util.Objects;

public class Nota {

    private double valor;
    private String asignatura;

    public Nota(double valor, String asignatura) {
        setValor(valor);
        this.asignatura = asignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10: " + valor);
        }
        this.valor = valor;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    public boolean estaAprobada() {
        if(valor>=5) {
            return true;
        }else {
            return false;
        }
    }

    public void subir(double puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("Los puntos a subir no pueden ser negativos: " + puntos);
        }
        setValor(valor + puntos);
    }

    public void bajar(double puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("Los puntos a bajar no pueden ser negativos: " + puntos);
        }
        setValor(valor - puntos);
    }

    public String getCalificacion() {
        if (valor < 3) {
            return "muy deficiente";
        } else if (valor < 5) {
            return "insuficiente";
        } else if (valor < 6) {
            return "aprobado";
        } else if (valor < 7) {
            return "bien";
        } else if (valor < 9) {
            return "notable";
        } else {
            return "sobresaliente";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nota otra = (Nota) obj;
        return Double.compare(valor, otra.valor) == 0
                && Objects.equals(asignatura, otra.asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, asignatura);
    }
}
