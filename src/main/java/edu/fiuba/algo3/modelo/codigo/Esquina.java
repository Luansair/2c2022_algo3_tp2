package edu.fiuba.algo3.modelo.codigo;

public class Esquina {
    private int posicion_x;
    private int posicion_y;

    public Esquina(int x, int y) {
        this.posicion_x = x;
        this.posicion_y = y;
    }

    public void actualizar(int incremento_x, int incremento_y) {
        this.posicion_x += incremento_x;
        this.posicion_y += incremento_y;
    }

    public boolean mismaEsquina(Esquina unaEsquina) {
        return this.coordenadasIguales(posicion_x, posicion_y);
    }

    private boolean coordenadasIguales(int coordenadaX, int coordenadaY) {
        return posicion_x == coordenadaX && posicion_y == coordenadaY;
    }

}