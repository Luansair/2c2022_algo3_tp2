package edu.fiuba.algo3.modelo.codigo.obstaculos;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
public class Pozo implements Obstaculo{
    public void activar(Vehiculo unVehiculo){
        unVehiculo.chocarPozo(this);
    }

    public void activar(Moto unaMoto){
        unaMoto.sumarMovimientos(3);
    }

    public void activar(Auto unAuto){
        unAuto.sumarMovimientos(3);
    }

    public void activar(CuatroPorCuatro un4x4){
        un4x4.sumarMovimientos(2);
    }

    public String imprimir(){
        return ("boton-pozo");
    }

}
