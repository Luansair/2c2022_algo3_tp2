package edu.fiuba.algo3.modelo.codigo.obstaculos;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
public class Pozo implements Obstaculo {
    public void activar(Vehiculo vehiculo) {
        if(vehiculo.getClass() == Moto.class) {
            chocarMoto(vehiculo);
        }

        if(vehiculo.getClass() == Auto.class) {
            chocarAuto(vehiculo);
        }

        if(vehiculo.getClass() == CuatroPorCuatro.class) {
            chocarCuatroPorCuatro(vehiculo);
        }
    }

    private void chocarMoto(Vehiculo vehiculo) {
        vehiculo.sumarMovimientos(3);
    }

    private void chocarAuto(Vehiculo vehiculo) {
        vehiculo.sumarMovimientos(3);
    }

    public void chocarCuatroPorCuatro(Vehiculo vehiculo) {
        vehiculo.cantidadPozos.aumentar(1);
        if(vehiculo.cantidadPozos.valor() % 3 == 0 && vehiculo.cantidadPozos.valor() != 0)
            vehiculo.sumarMovimientos(2);
    }
}
