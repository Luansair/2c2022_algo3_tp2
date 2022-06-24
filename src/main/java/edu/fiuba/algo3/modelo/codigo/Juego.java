package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.Direccion;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorTurno;

    private int cantidadJugadores;

    private Mapa mapa;



    public Juego(String[] nombresJugadores) {
        Mapa mapa = new Mapa();
        mapa = mapa.crearMapa(4, 4); // Hardcodeado, hay que ver donde se crea el mapa
        jugadores = new ArrayList<>();
        cantidadJugadores = nombresJugadores.length;

        if(cantidadJugadores == 0) {
            throw new RuntimeException("Debe haber al menos un jugador");
        }

        for(int i = 0; i < cantidadJugadores; i++) {
            jugadores.add(new Jugador(mapa, nombresJugadores[i]));
        }

        jugadorTurno = jugadores.get(0);
    }



    public void moverVehiculo(Direccion unaDireccion) { jugadorTurno.moverVehiculo(unaDireccion); }
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

    public Juego() {
        this.mapa = new Mapa();
    }
    public void crearMapa(int dimension_x, int dimension_y) {
        mapa.crearMapa(dimension_x,dimension_y);
    }

    public void getNombreJugador(String nombre)  {
        jugadorTurno = new Jugador(mapa, nombre);
    }

    public void asignarMoto()  {
        getJugadorTurno().asignarVehiculo(new Moto(mapa.getEsquinaIncial(),jugadorTurno));
    }

    public void asignarAuto()  {
        getJugadorTurno().asignarVehiculo(new Auto(mapa.getEsquinaIncial(),jugadorTurno));
    }

    public void asignaCuatroPorCuatro()  {
        getJugadorTurno().asignarVehiculo(new CuatroPorCuatro(mapa.getEsquinaIncial(),jugadorTurno));
    }





}


