package edu.fiuba.algo3.modelo.codigo;

public class ContadorPozo {
    private final Jugador jugador;
    private int contador;
    private final int maximo;

    public ContadorPozo(Jugador unJugador, int unaCantMaxima){
        jugador = unJugador;
        contador = 0;
        maximo = unaCantMaxima;
    }

    public void sumarMovimientos(int movimiento){
        contador++;
        if(contador >= maximo){
            jugador.sumarMovimientos(movimiento);
            contador = 0;
        }
    }

}
