package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.Direccion;
import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.modelo.codigo.Contador;

public abstract class Vehiculo {
    protected Jugador jugador;
    protected Esquina posicion;
    public Contador cantidadPozos;

    public Esquina obtenerPosicion() {
        return posicion;
    }

    public void sumarMovimientos(int movimientos) {
        jugador.sumarMovimientos(movimientos);
    }
    public void mover(Direccion unaDireccion) {
        unaDireccion.mover(posicion);
    }
    public void chocarPozo() {
        cantidadPozos.aumentar(1);
    }

    public void chocar(Vehiculo vehiculo) {
    	vehiculo.chocar(vehiculo);
    }
}

