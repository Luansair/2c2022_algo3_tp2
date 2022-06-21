package edu.fiuba.algo3.modelo.codigo.Direccion;

import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Mapa;

public class DireccionSuperior extends Direccion{

    public DireccionSuperior(Mapa mapa){
        super.mapa = mapa;
    }

    public void mover(Esquina esquina) {
        esquina.actualizar(0, 1);
    }
}

