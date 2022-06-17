package edu.fiuba.algo3.modelo.codigo;

public class DireccionIzquierda extends Direccion{

    public DireccionIzquierda(Mapa mapa) {
        super.mapa = mapa;
    }

    public void mover(Esquina esquina) {
        esquina.actualizar(-1, 0);
    }
}