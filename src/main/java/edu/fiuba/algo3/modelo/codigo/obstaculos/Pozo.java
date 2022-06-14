package edu.fiuba.algo3.modelo.codigo.obstaculos;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
public class Pozo implements Obstaculo {

	public void activar(Vehiculo vehiculo) {
		
        
        vehiculo.chocar(vehiculo);
        
    }
}