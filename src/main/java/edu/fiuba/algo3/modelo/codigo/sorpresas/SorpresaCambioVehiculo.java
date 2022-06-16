package edu.fiuba.algo3.modelo.codigo.sorpresas;

import edu.fiuba.algo3.modelo.codigo.Jugador;

public class SorpresaCambioVehiculo implements Sorpresa{
    public void activar(Jugador jugador) {
        jugador.cambiarVehiculo();
    }
}