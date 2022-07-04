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

        jugadores = new ArrayList<>();
        cantidadJugadores = nombresJugadores.length;

        for(int i = 0; i < cantidadJugadores; i++) {
            jugadores.add(new Jugador(mapa, nombresJugadores[i]));
        }

        jugadorTurno = jugadores.get(0);
    }


    public Mapa obtenerMapa() {return this.mapa;}

    public void moverVehiculo(Direccion unaDireccion) { jugadorTurno.moverVehiculo(unaDireccion); }
    public void siguienteTurno() {
        int indice = jugadores.indexOf(jugadorTurno);

        if(indice == jugadores.size() - 1) {
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
        this.jugadores = new ArrayList<>();
        this.cantidadJugadores = 0;
    }

    public void agregarJugador(String nombre)  {
        Jugador jugador = new Jugador(mapa, nombre);
        jugadores.add(jugador);
        jugadorTurno = jugador;
        cantidadJugadores ++;
        System.out.println("JUGADOR AGREGADO");
    }

    public void asignarMoto()  {
        getJugadorTurno().asignarVehiculo(new Moto(mapa.getEsquinaIncial(), jugadorTurno));
    }

    public void asignarAuto()  {
        getJugadorTurno().asignarVehiculo(new Auto(mapa.getEsquinaIncial(), jugadorTurno));
    }

    public void asignaCuatroPorCuatro()  {
        getJugadorTurno().asignarVehiculo(new CuatroPorCuatro(mapa.getEsquinaIncial(), jugadorTurno));
    }

    public boolean juegoTerminado() {
        return jugadores.size() == 0;
    }

    public ArrayList<Jugador> getJugadores() {return jugadores;}

    public int getCantidadJugadores() { return cantidadJugadores; }
    public void asignarNombre(String nombre) {jugadorTurno.asignarNombre(nombre);}

    public void imprimirEstado() {
        System.out.println(jugadorTurno.nombre() + " tiene movimientos = " + jugadorTurno.cantidadDeMovimientos());
        System.out.println("Posición = " + jugadorTurno.obtenerVehiculo().obtenerPosicion().posicion_x + " " + jugadorTurno.obtenerVehiculo().obtenerPosicion().posicion_y);
    }
}


