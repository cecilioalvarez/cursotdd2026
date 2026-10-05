package com.arquitecturajava;

public class Nota {

    private double valor;
    private String asignatura;

    public Nota(double valor, String asignatura) {
        this.valor = valor;
        this.asignatura = asignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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
