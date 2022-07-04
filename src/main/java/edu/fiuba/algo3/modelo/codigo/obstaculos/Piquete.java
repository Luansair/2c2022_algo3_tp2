package edu.fiuba.algo3.modelo.codigo.obstaculos;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;

public class Piquete implements Obstaculo{
    // Se toma de supuesto que NO puede haber dos piquetes en la misma cuadra

    public void activar(Vehiculo unVehiculo){
        unVehiculo.chocarPiquete(this);
    }

    public void activar(Moto unaMoto){ unaMoto.sumarMovimientos(2); }

    public void activar(Auto unAuto){
        unAuto.pegarLaVuelta();
    }

    public void activar(CuatroPorCuatro un4x4){
        un4x4.pegarLaVuelta();
    }
    public String imprimir(){
        return ("boton-piquete");
    }

}