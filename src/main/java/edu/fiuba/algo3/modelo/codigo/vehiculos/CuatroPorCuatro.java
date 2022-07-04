package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.*;
import edu.fiuba.algo3.modelo.codigo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;

public class CuatroPorCuatro extends Vehiculo{

    public ContadorPozo contadorPozo;

    public CuatroPorCuatro(Esquina unaEsquina, Jugador unJugador) {
        this.cantidadPozos = new ContadorMovimiento();
        this.jugador = unJugador;
        this.posicion = unaEsquina;
        this.contadorPozo = new ContadorPozo(unJugador, 3);
    }

    @Override
    public void chocarPozo(Pozo pozo) {
        pozo.activar(this);
    }

    @Override
    public void chocarPiquete(Piquete piquete) {
        piquete.activar(this);
    }

    @Override
    public void chocarControlPolicial(ControlPolicial controlPolicial) {
        controlPolicial.activar(this);
    }
    @Override
    public void sumarMovimientos(int movimientos) {
        contadorPozo.sumarMovimientos(movimientos);
    }

    public Vehiculo obtenerSiguiente() {
        return new Moto(super.posicion, super.jugador);
    }

    public String imprimir(){
        return ("boton-cuatroPorCuatro");
    }
}
