package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.*;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorTurno;
    private int cantidadJugadores;
    private Mapa mapa;
    public ArrayList<Jugador> scores;

    public Juego() {
        this.mapa = new Mapa();
        this.mapa.crearMapa();
        this.jugadores = new ArrayList<>();
        this.cantidadJugadores = 0;
        this.scores = new ArrayList<>();
    }

    public void siguienteTurno() {
        if (jugadorTurno.llegoAMeta()) {
            llegueAMeta();
        } else {
            int indice = jugadores.indexOf(jugadorTurno);

            if(indice == jugadores.size() - 1) {
                jugadorTurno = jugadores.get(0);
            } else {
                jugadorTurno = jugadores.get(indice + 1);
            }
        }
    }

    public void llegueAMeta() {
        this.scores.add(jugadorTurno);
        jugadores.remove(jugadorTurno);
        cantidadJugadores --;
        if (!juegoTerminado()) {
            jugadorTurno = jugadores.get(indiceSiguiente());
        }
    }

    private int indiceSiguiente() {
        int indice = jugadores.indexOf(jugadorTurno);
        if (indice == jugadores.size() - 1) {
            return 0;
        } else {
            return indice + 1;
        }
    }

    public String getJugadorTurno() {
        return jugadorTurno.getNombre();
    }


    public void agregarJugador(String nombre)  {
        Jugador jugador = new Jugador(mapa, nombre);
        jugadores.add(jugador);
        cantidadJugadores ++;
        jugadorTurno = jugador;
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

    public Esquina getMeta() {return mapa.getMeta();}

    public ArrayList<Jugador> getJugadores() {return jugadores;}

    public int getCantidadJugadores() { return cantidadJugadores; }
    public void asignarNombre(String nombre) {jugadorTurno.asignarNombre(nombre);}


    public int puntaje() {
        return jugadorTurno.cantidadDeMovimientos();
    }

    public void moverhaciaArriba() {
        DireccionInferior direccionInferior = new DireccionInferior(mapa);
        jugadorTurno.moverVehiculo(direccionInferior);
        siguienteTurno();
    }

    public void moverHaciaAbajo() {
        DireccionSuperior direccionSuperior = new DireccionSuperior(mapa);
        jugadorTurno.moverVehiculo(direccionSuperior);
        siguienteTurno();
    }

    public void moverHaciaDerecha() {
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugadorTurno.moverVehiculo(direccionDerecha);
        siguienteTurno();
    }

    public void moverHaciaIzquierda() {
        DireccionIzquierda direccionIzquierda = new DireccionIzquierda(mapa);
        jugadorTurno.moverVehiculo(direccionIzquierda);
        siguienteTurno();
    }



    public ArrayList<Cuadra> getCuadras() {
        return mapa.getCuadras();
    }


    public int getPosicionX() {
        Vehiculo vehiculo = jugadorTurno.obtenerVehiculo();
        return vehiculo.obtenerPosicion().getPosicionX();
    }

    public int getPosicionY() {
        Vehiculo vehiculo = jugadorTurno.obtenerVehiculo();
        return vehiculo.obtenerPosicion().getPosicionY();
    }

    public  ArrayList<Pair<String, Integer>> leerPuntajes() throws Exception {
        ArchivoPuntuacion archivo = new ArchivoPuntuacion();
        return archivo.leerArchivo("src/main/resources/archivo.csv");
    }

    public void escribirPuntajes() throws IOException {
        ArchivoPuntuacion archivo = new ArchivoPuntuacion();
        archivo.escribirArchivo("src/main/resources/archivo.csv", scores);
    }
}


