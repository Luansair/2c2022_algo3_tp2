package edu.fiuba.algo3.modelo.codigo;

public class DireccionDerecha extends Direccion{

    public DireccionDerecha(Mapa mapa) {
        super.mapa = mapa;
    }

    public void mover(Esquina esquina) {
        esquina.actualizar(1, 0);
    }
}
