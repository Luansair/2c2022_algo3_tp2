package edu.fiuba.algo3.modelo.codigo.sorpresas;

import edu.fiuba.algo3.modelo.codigo.Jugador;

public class SorpresaDesfavorable implements Sorpresa{
    public void activar(Jugador jugador) {
        jugador.sumarPorcentaje(0.25);
    }

    public void imprimir(){
        System.out.print(" SorpresaDesfavorable ");
    }
}
