package edu.fiuba.algo3.modelo.codigo;

public class Esquina {
    private int posicion_x;
    private int posicion_y;

    public Esquina(int x, int y) {
        this.posicion_x = x;
        this.posicion_y = y;
    }

    public void imprimirEsquina() {
        System.out.println(posicion_x + "," + posicion_y);
    }

    public void actualizar(int incremento_x, int incremento_y) {
        this.posicion_x += incremento_x;
        this.posicion_y += incremento_y;
    }

    public boolean mismaEsquina(Esquina unaEsquina) { //siempre devuelve true porq no se utiliza la otra esquina sino q se compara con sigo misma.
        return this.coordenadasIguales(unaEsquina.posicion_x, unaEsquina.posicion_y);
    }

    private boolean coordenadasIguales(int coordenadaX, int coordenadaY) {
        return posicion_x == coordenadaX && posicion_y == coordenadaY;
    }

    public Esquina obtenerSiguiente(int incremento_x, int incremento_y) {
        return new Esquina(posicion_x + incremento_x, posicion_y + incremento_y);
    }

}
