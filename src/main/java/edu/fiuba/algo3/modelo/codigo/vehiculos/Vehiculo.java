package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.modelo.codigo.ContadorMovimiento;
import edu.fiuba.algo3.modelo.codigo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Piquete;

public abstract class Vehiculo {
    protected Jugador jugador;
    protected Esquina posicion_anterior;
    protected Esquina posicion;
    public ContadorMovimiento cantidadPozos;

    public Esquina obtenerPosicion() {
        return posicion;
    } //rompe encapsulamiento

    public Esquina obtenerPosicionAnterior() {
        return posicion_anterior;
    }

    public void sumarMovimientos(int movimientos) {
        jugador.sumarMovimientos(movimientos);
    }
    public void mover(Direccion unaDireccion) {
        posicion_anterior = posicion;
        posicion = unaDireccion.obtenerSiguiente(posicion);
    }

    public abstract void chocarPozo(Pozo pozo);
    public abstract void chocarPiquete(Piquete piquete);
    public abstract void chocarControlPolicial(ControlPolicial controlPolicial);

    public abstract Vehiculo obtenerSiguiente();

    public abstract String imprimir();

    public void pegarLaVuelta() {
        Esquina aux = posicion;
        posicion = posicion_anterior;
        posicion_anterior = aux;
        sumarMovimientos(1);
    }
}
