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
        for (int i = 0; i < cuadras.size(); i++) {
            Cuadra cuadra = cuadras.get(i);
            if (cuadra.mismaCuadra(esquinaUno, esquinaDos)) {
                cuadra.aplicarObstaculos(unVehiculo);
            }
        }

    }

    public void agregarCuadra(Cuadra cuadra) {
        this.cuadras.add(cuadra);
    }
}
