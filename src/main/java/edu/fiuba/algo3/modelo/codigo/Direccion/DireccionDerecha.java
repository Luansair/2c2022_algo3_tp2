package edu.fiuba.algo3.modelo.codigo.Direccion;

import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Mapa;

public class DireccionDerecha extends Direccion{

    public DireccionDerecha(Mapa mapa){
        super.mapa = mapa;
    }

    public void mover(Esquina esquina) {
        esquina.actualizar(1, 0);
    }

    @Override
    public Esquina obtenerSiguiente(Esquina unaEsquina) { return unaEsquina.obtenerSiguiente(1, 0); }
}
