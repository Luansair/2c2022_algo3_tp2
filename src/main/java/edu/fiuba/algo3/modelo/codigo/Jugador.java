package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.Direccion;
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

    public void asignarVehiculo(Vehiculo unVehiculo) { this.vehiculo = unVehiculo; }
    public void asignarNombre(String unNombre) {this.nombre = unNombre;}

    public int cantidadDeMovimientos() {
        return cantidadMovimientos.valor();
    } //Rompe encapsulamiento

    public void sumarPorcentaje(double porcentaje) {
        cantidadMovimientos.aumentarPorcentaje(porcentaje);
    }

    public void moverVehiculo(Direccion unaDireccion) {
        // Al mover se crea una nueva instancia de Esquina en lugar de actualizar la existente
        sumarMovimientos(1);
        vehiculo.mover(unaDireccion);
        if(!mapa.posicionValida(vehiculo))
            vehiculo.pegarLaVuelta();
        mapa.aplicarObstaculos(vehiculo, vehiculo.obtenerPosicion(), vehiculo.obtenerPosicionAnterior());
        mapa.aplicarSorpresas(this, vehiculo.obtenerPosicion(), vehiculo.obtenerPosicionAnterior());
    }
    public void sumarMovimientos(int movimientos) {
        cantidadMovimientos.aumentar(movimientos);
    }

    public void cambiarVehiculo(){
        this.vehiculo = vehiculo.obtenerSiguiente();
    }

    public String nombre() {return nombre;}

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void asignarMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Boolean igualNombre(String nombre) {
        return this.nombre.equals(nombre);
    }
}
