package com.arquitecturajava;

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
}
