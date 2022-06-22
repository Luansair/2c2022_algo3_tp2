package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Obstaculo;

import java.util.ArrayList;
import java.util.Scanner;
public class Juego {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorTurno;
    private int cantidadJugadores;

    public Juego(String[] nombresJugadores) {
        Mapa mapa = new Mapa();
        jugadores = new ArrayList<>();
        cantidadJugadores = nombresJugadores.length;

        for(int i = 0; i < cantidadJugadores; i++) {
            jugadores.add(new Jugador(mapa, nombresJugadores[i]));
        }

        jugadorTurno = jugadores.get(0);
    }

    public void moverVehiculo(Direccion unaDireccion) {
        jugadorTurno.moverVehiculo(unaDireccion);
    }
    public void siguienteTurno() {
        int indice = jugadores.indexOf(jugadorTurno);

        if(indice == cantidadJugadores - 1) {
            jugadorTurno = jugadores.get(0);
        } else {
            jugadorTurno = jugadores.get(indice + 1);
        }
    }

    //Sirve solo para las pruebas
    public Jugador getJugadorTurno() {
        return jugadorTurno;
    }
    /*public static void main(String[] args) {
        String[] nombres = {"FACUNDO", "FELIPE", "FRANCO"};
        Juego juego = new Juego(nombres);
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();

        System.out.println(juego.jugadorTurno.nombre());
    }*/
}
