package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.*;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebasJuego {

    @Test
    public void test01SeCreaUnJuegoConTresJugadoresYElJugadorDeTurnoEsElUltimo() {
        String[] jugadores = {"Facundo", "Felipe", "Franco"};
        Juego juego = new Juego();
        juego.agregarJugador("Facundo");
        juego.asignarMoto();
        juego.agregarJugador("Felipe");
        juego.asignarMoto();
        juego.agregarJugador("Franco");
        juego.asignarMoto();

        assertEquals(juego.getJugadorTurno(), jugadores[2]);
    }

    @Test
    public void test02SeCreaUnJuegoConTresJugadoresYAlPasarUnTurnoElJugadorDeTurnoEsElPrimero() {
        String[] jugadores = {"Facundo", "Felipe", "Franco"};
        Juego juego = new Juego();
        juego.agregarJugador("Facundo");
        juego.asignarMoto();
        juego.agregarJugador("Felipe");
        juego.asignarMoto();
        juego.agregarJugador("Franco");
        juego.asignarMoto();
        juego.siguienteTurno();

        assertEquals(juego.getJugadorTurno(), jugadores[0]);
    }

    @Test
    public void test03SeCreaUnJuegoConTresJugadoresYAlPasarTresVecesElTurnoElJugadorDeTurnoEsElUltimoDeNuevo() {
        String[] jugadores = {"Facundo", "Felipe", "Franco"};
        Juego juego = new Juego();
        juego.agregarJugador("Facundo");
        juego.asignarMoto();
        juego.agregarJugador("Felipe");
        juego.asignarMoto();
        juego.agregarJugador("Franco");
        juego.asignarMoto();
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();

        assertEquals(juego.getJugadorTurno(), jugadores[2]);
    }
}