package edu.fiuba.algo3.modelo.codigo.Direccion;

import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Mapa;

public abstract class Direccion {

    protected Mapa mapa; //deberia ser para evitar sobrepasar los limites, pero por ahora no se usa...

    abstract public void mover(Esquina unaEsquina);

    abstract public Esquina obtenerSiguiente(Esquina unaEsquina);
}
