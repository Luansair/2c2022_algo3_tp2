package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;

import java.util.ArrayList;

public class Mapa {
    private ArrayList<Cuadra> cuadras;

    public Mapa() {
        cuadras = new ArrayList<>();
    }
    public void aplicarObstaculos(Vehiculo unVehiculo, Esquina esquinaUno, Esquina esquinaDos) {
        for (Cuadra cuadra : cuadras) {
            if (cuadra.mismaCuadra(esquinaUno, esquinaDos)) {
                cuadra.aplicarObstaculos(unVehiculo);
            }
        }
    }

    public void aplicarSorpresas(Jugador unJugador, Esquina esquinaUno, Esquina esquinaDos) {
        for (Cuadra cuadra : cuadras) {
            if (cuadra.mismaCuadra(esquinaUno, esquinaDos)) {
                cuadra.aplicarSorpresas(unJugador);
            }
        }
    }

    public void agregarCuadra(Cuadra cuadra) {
        this.cuadras.add(cuadra);
    }
}
