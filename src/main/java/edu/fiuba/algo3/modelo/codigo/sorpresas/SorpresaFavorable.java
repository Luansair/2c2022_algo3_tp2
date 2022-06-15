package edu.fiuba.algo3.modelo.codigo.sorpresas;

import edu.fiuba.algo3.modelo.codigo.Jugador;

public class SorpresaFavorable implements Sorpresa{
    public void activar(Jugador jugador) {
        jugador.sumarPorcentaje(-0.2);
    }
}
