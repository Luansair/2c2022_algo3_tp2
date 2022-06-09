package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;

public class Jugador {
    private String nombre;
    private Contador cantidadMovimientos;
    private Vehiculo vehiculo;
    private Mapa mapa;

    public Jugador(Mapa unMapa, String unNombre) {
        this.nombre = unNombre;
        this.cantidadMovimientos = new Contador();
        this.mapa = unMapa;
    }

    public void asignarVehiculo(Vehiculo unVehiculo) {
        this.vehiculo = unVehiculo;
    }

    public int cantidadDeMovimientos() {
        return cantidadMovimientos.valor();
    }

    public void moverVehiculo(Direccion unaDireccion) {
        Esquina posicionInicial = vehiculo.obtenerPosicion();
        vehiculo.mover(unaDireccion);
        Esquina posicionFinal = vehiculo.obtenerPosicion();

        mapa.aplicarObstaculos(vehiculo, posicionInicial, posicionFinal);
        sumarMovimientos(1);
    }
    public void sumarMovimientos(int movimientos) {
        cantidadMovimientos.aumentar(movimientos);
    }

}
