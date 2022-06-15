package edu.fiuba.algo3.modelo.codigo;

public class Contador {
    private int valor;
    public int valor() {
        return this.valor;
    }

    public Contador() {
        valor = 0;
    }

    public void aumentar(int movimientos) {
        valor = valor + movimientos;
    }

    public void aumentarPorcentaje(double porcentaje) {valor = (int)(valor + porcentaje * valor);}
}
