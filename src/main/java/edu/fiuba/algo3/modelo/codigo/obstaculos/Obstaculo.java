package edu.fiuba.algo3.modelo.codigo.obstaculos;

import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;


public interface Obstaculo {
    void activar(Vehiculo unVehiculo);
    String imprimir();
}
