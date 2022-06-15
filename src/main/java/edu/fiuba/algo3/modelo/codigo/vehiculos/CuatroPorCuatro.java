package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.Direccion;
import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.modelo.codigo.Contador;

public class CuatroPorCuatro extends Vehiculo{

    public CuatroPorCuatro(Esquina unaEsquina, Jugador unJugador) {
        this.cantidadPozos = new Contador();
        this.jugador = unJugador;
        this.posicion = unaEsquina;
    }

    public Vehiculo obtenerSiguiente() {
        return new Moto(super.posicion, super.jugador);
    }
}
