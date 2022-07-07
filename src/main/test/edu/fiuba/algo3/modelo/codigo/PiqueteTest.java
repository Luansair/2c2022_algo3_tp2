package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.*;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {
    @Test
    public void test01JugadorConAutoSeMueveHaciaAbajoSeEncuentraConPiqueteYVuelveAPosicionOrigen(){

        Mapa mapa = new Mapa();
        Esquina origen = new Esquina(0, 0);
        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(0,1);
        Cuadra cuadra1 = new Cuadra(esquina1, esquina2); cuadra1.agregarObstaculo(new Piquete());


        Jugador jugador = new Jugador(mapa, "Boadicea");
        Auto auto = new Auto(origen, jugador);
        jugador.asignarVehiculo(auto);

        mapa.agregarCuadra(cuadra1);

        jugador.moverVehiculo(new DireccionSuperior(mapa)); //o direccion abajo

        assertTrue(origen.mismaEsquina(auto.obtenerPosicion()));
    }

    @Test
    public void test02JugadorConAutoSeMueveHaciaAbajoSeEncuentraConPiqueteYVuelveAPosicionOrigenSumandoDosMovimientos(){
        //Se contabiliza tanto la ida como la vuelta
        int movimientos = 2;

        Mapa mapa = new Mapa();
        Esquina origen = new Esquina(0, 0);
        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(0,1);
        Cuadra cuadra1 = new Cuadra(esquina1, esquina2); cuadra1.agregarObstaculo(new Piquete());


        Jugador jugador = new Jugador(mapa, "Mario");
        Auto auto = new Auto(origen, jugador);
        jugador.asignarVehiculo(auto);

        mapa.agregarCuadra(cuadra1);

        jugador.moverVehiculo(new DireccionSuperior(mapa)); //o direccion abajo

        assertEquals(jugador.cantidadDeMovimientos(), movimientos);
    }

    @Test
    public void test03JugadorConMotoSeMueveHaciaAbajoSeEncuentraConPiqueteYNoPegaLaVuelta(){
        Mapa mapa = new Mapa();
        Esquina origen = new Esquina(0, 0);
        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(0,1);
        Cuadra cuadra1 = new Cuadra(esquina1, esquina2); cuadra1.agregarObstaculo(new Piquete());


        Jugador jugador = new Jugador(mapa, "Luigi");
        Moto moto = new Moto(origen, jugador);
        jugador.asignarVehiculo(moto);

        mapa.agregarCuadra(cuadra1);

        jugador.moverVehiculo(new DireccionSuperior(mapa)); //o direccion abajo

        assertTrue(esquina2.mismaEsquina(moto.obtenerPosicion()));
    }
}
