package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.ContadorMovimiento;
import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.modelo.codigo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;

public class ReliantRobin extends Vehiculo{
    private Vehiculo tipoVehiculo;


    public ReliantRobin(Esquina unaEsquina, Jugador unJugador) {
        double probabilidad = Math.random();

        if(probabilidad < 0.6)
            this.tipoVehiculo = new Auto(unaEsquina, unJugador);
        else
            this.tipoVehiculo = new Moto(unaEsquina, unJugador);

        this.cantidadPozos = new ContadorMovimiento();
        this.jugador = unJugador;
        this.posicion = unaEsquina;
    }

    @Override
    public void chocarPozo(Pozo pozo) {
        pozo.activar(this.tipoVehiculo);
    }

    @Override
    public void chocarPiquete(Piquete piquete) {
        piquete.activar(this.tipoVehiculo);
    }

    @Override
    public void chocarControlPolicial(ControlPolicial controlPolicial) {
        controlPolicial.activar(this.tipoVehiculo);
    }

    public Vehiculo obtenerSiguiente() {
        return this.tipoVehiculo.obtenerSiguiente();
    }

    public String imprimir(){
        return "boton-reliant";
    }

}
