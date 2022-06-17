package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;

public class Jugador {
    private String nombre;
    private ContadorMovimiento cantidadMovimientos;
    private Vehiculo vehiculo;
    private Mapa mapa;

    public Jugador(Mapa unMapa, String unNombre) {
        this.nombre = unNombre;
        this.cantidadMovimientos = new ContadorMovimiento();
        this.mapa = unMapa;
    }

    // Provisorio solo para prueba de sorpresa de cambio de vehículo
    public Vehiculo obtenerVehiculo() {
        return this.vehiculo;
    }

    public void asignarVehiculo(Vehiculo unVehiculo) {
        this.vehiculo = unVehiculo;
    }

    public int cantidadDeMovimientos() {
        return cantidadMovimientos.valor();
    }

    public void sumarPorcentaje(double porcentaje) {
        cantidadMovimientos.aumentarPorcentaje(porcentaje);
    }

    public void moverVehiculo(Direccion unaDireccion) {
        sumarMovimientos(1);
        Esquina posicionInicial = vehiculo.obtenerPosicion();
        vehiculo.mover(unaDireccion);
        Esquina posicionFinal = vehiculo.obtenerPosicion();

        mapa.aplicarObstaculos(vehiculo, posicionInicial, posicionFinal);
        mapa.aplicarSorpresas(this, posicionInicial, posicionFinal);
    }
    public void sumarMovimientos(int movimientos) {
        cantidadMovimientos.aumentar(movimientos);
    }

    public void cambiarVehiculo(){
        this.vehiculo = vehiculo.obtenerSiguiente();
    }
}
