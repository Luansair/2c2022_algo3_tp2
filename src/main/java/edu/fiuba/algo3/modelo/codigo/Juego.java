package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.*;
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

    public Juego() {
        this.mapa = new Mapa();
        mapa.crearMapa();
        this.jugadores = new ArrayList<>();
        this.cantidadJugadores = 0;
    }

    public Juego(String[] nombresJugadores) {
        Mapa mapa = new Mapa();

        jugadores = new ArrayList<>();
        cantidadJugadores = nombresJugadores.length;

        for(int i = 0; i < cantidadJugadores; i++) {
            jugadores.add(new Jugador(mapa, nombresJugadores[i]));
        }

        jugadorTurno = jugadores.get(0);
    }


    public void siguienteTurno() {
        int indice = jugadores.indexOf(jugadorTurno);

        if(indice == jugadores.size() - 1) {
            jugadorTurno = jugadores.get(0);
        } else {
            jugadorTurno = jugadores.get(indice + 1);
        }
    }

    //Sirve solo para las pruebas
    public String getJugadorTurno() {
        return jugadorTurno.getNombre();
    }


    public void agregarJugador(String nombre)  {
        Jugador jugador = new Jugador(mapa, nombre);
        jugadores.add(jugador);
        jugadorTurno = jugador;
        cantidadJugadores ++;
        System.out.println("JUGADOR AGREGADO");
    }

    public void asignarMoto()  {
        jugadorTurno.asignarVehiculo(new Moto(mapa.getEsquinaIncial(), jugadorTurno));
    }

    public void asignarAuto()  {
        jugadorTurno.asignarVehiculo(new Auto(mapa.getEsquinaIncial(), jugadorTurno));
    }

    public void asignaCuatroPorCuatro()  {
        jugadorTurno.asignarVehiculo(new CuatroPorCuatro(mapa.getEsquinaIncial(), jugadorTurno));
    }

    public boolean juegoTerminado() {
        return jugadores.size() == 0;
    }

    public ArrayList<Jugador> getJugadores() {return jugadores;}

    public int getCantidadJugadores() { return cantidadJugadores; }
    public void asignarNombre(String nombre) {jugadorTurno.asignarNombre(nombre);}

    public void imprimirEstado() {
        System.out.println(jugadorTurno.getNombre() + " tiene movimientos = " + jugadorTurno.cantidadDeMovimientos());
        System.out.println("Posición = " + jugadorTurno.obtenerVehiculo().obtenerPosicion().posicion_x + " " + jugadorTurno.obtenerVehiculo().obtenerPosicion().posicion_y);
    }

    public int puntaje() {
        return jugadorTurno.cantidadDeMovimientos();
    }

    public void moverhaciaArriba() {
        DireccionInferior direccionInferior = new DireccionInferior(mapa);
        jugadorTurno.moverVehiculo(direccionInferior);
    }

    public void moverHaciaAbajo() {
        DireccionSuperior direccionSuperior = new DireccionSuperior(mapa);
        jugadorTurno.moverVehiculo(direccionSuperior);
    }

    public void moverHaciaDerecha() {
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugadorTurno.moverVehiculo(direccionDerecha);

    }

    public void moverHaciaIzquierda() {
        DireccionIzquierda direccionIzquierda = new DireccionIzquierda(mapa);
        jugadorTurno.moverVehiculo(direccionIzquierda);
    }

    public ArrayList<Cuadra> getCuadras() {
        return mapa.getCuadras();
    }


}


