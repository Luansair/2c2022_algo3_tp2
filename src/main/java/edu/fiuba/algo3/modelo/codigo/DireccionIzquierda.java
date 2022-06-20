package edu.fiuba.algo3.modelo.codigo;

public class DireccionIzquierda extends Direccion{

    public void mover(Esquina esquina) {
        esquina.actualizar(-1, 0);
    }
}