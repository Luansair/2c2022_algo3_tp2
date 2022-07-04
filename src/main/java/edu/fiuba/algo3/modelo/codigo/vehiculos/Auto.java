package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.modelo.codigo.ContadorMovimiento;
import edu.fiuba.algo3.modelo.codigo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;

public class Auto extends Vehiculo{
    public Auto(Esquina unaEsquina, Jugador unJugador) {
        this.cantidadPozos = new ContadorMovimiento();
        this.jugador = unJugador;
        this.posicion = unaEsquina;
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

    public Vehiculo obtenerSiguiente() {
        return new CuatroPorCuatro(super.posicion, super.jugador);
    }

    public String imprimir(){
        return ("boton-auto");
    }

}
