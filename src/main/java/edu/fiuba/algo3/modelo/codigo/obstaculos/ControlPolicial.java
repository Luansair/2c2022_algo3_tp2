package edu.fiuba.algo3.modelo.codigo.obstaculos;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;

import java.lang.Math;

public class ControlPolicial implements Obstaculo{
    public void activar(Vehiculo unVehiculo){
        unVehiculo.chocarControlPolicial(this);
    }

    public void activar(Moto unaMoto){
        if (Math.random() < 0.8) {
            unaMoto.sumarMovimientos(3);
        }
    }

    public void activar(Auto unAuto){
        if (Math.random() < 0.5) {
            unAuto.sumarMovimientos(3);
        }
    }

    public void activar(CuatroPorCuatro un4x4){
        if (Math.random() < 0.3) {
            un4x4.sumarMovimientos(3);
        }
    }

    public void imprimir(){
        System.out.println("ControlPolicial");
    }

}
