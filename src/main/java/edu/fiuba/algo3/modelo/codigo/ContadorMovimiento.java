package edu.fiuba.algo3.modelo.codigo;

public class ContadorMovimiento {
    private int valor;
    public int valor() {
        return this.valor;
    }

    public ContadorMovimiento() {
        valor = 0;
    }

    public void aumentar(int movimientos) {
        valor = valor + movimientos;
    }

    public void aumentarPorcentaje(double porcentaje) {valor = (int)(valor + porcentaje * valor);}
}
