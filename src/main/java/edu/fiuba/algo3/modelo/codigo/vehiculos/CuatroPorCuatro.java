package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.*;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;

public class CuatroPorCuatro extends Vehiculo{

    public ContadorPozo contadorPozo;

    public CuatroPorCuatro(Esquina unaEsquina, Jugador unJugador) {
        this.cantidadPozos = new Contador();
        this.jugador = unJugador;
        this.posicion = unaEsquina;
        this.contadorPozo = new ContadorPozo(unJugador, 3);
    }

    @Override
    public void chocar(Pozo pozo) {
        pozo.activar(this);
    }

    @Override
    public void sumarMovimientos(int movimientos) {
        contadorPozo.sumarMovimientos(movimientos);
    }
}
