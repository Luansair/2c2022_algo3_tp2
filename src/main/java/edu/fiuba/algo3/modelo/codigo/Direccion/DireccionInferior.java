package edu.fiuba.algo3.modelo.codigo.Direccion;

import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Mapa;

public class DireccionInferior extends Direccion{
    public DireccionInferior(Mapa mapa){
        super.mapa = mapa;
    }

    public void mover(Esquina esquina) {
        esquina.actualizar(0, -1);
    }

    public Esquina obtenerSiguiente(Esquina unaEsquina) { return unaEsquina.obtenerSiguiente(0, -1); }
}

