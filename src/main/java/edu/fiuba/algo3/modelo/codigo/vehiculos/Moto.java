package edu.fiuba.algo3.modelo.codigo.vehiculos;

import edu.fiuba.algo3.modelo.codigo.Direccion;
import edu.fiuba.algo3.modelo.codigo.Esquina;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.modelo.codigo.Contador;

public class Moto extends Vehiculo{
    public Moto(Esquina unaEsquina, Jugador unJugador) {
        this.cantidadPozos = new Contador();
        this.jugador = unJugador;
        this.posicion = unaEsquina;
    }


    public void chocar(Vehiculo vehiculo) {
        vehiculo.sumarMovimientos(3);
    }

}

