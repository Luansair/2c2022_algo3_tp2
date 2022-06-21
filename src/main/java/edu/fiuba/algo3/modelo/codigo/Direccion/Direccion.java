package edu.fiuba.algo3.modelo.codigo.Direccion;

import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Mapa;

public abstract class Direccion {

    protected Mapa mapa;

    abstract public void mover(Esquina unaEsquina);
}
