package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import com.tngtech.archunit.thirdparty.com.google.common.net.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebasSorpresas {

    @Test
    public void test01MotoSeEncuentraConSorpresaCambioDeVehiculoYSeVuelveUnAuto() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y 1 Sorpresa de cambio de Vehículo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarSorpresa(sorpresa);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, la moto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Moto moto = new Moto(esquinaUno, jugador);
        jugador.asignarVehiculo(moto);

        // Le digo al jugador que mueva la moto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);

        // Verifico que haya cambiado de vehiculo a una instancia de auto
        assertEquals(Auto.class, jugador.obtenerVehiculo().getClass());
    }

    @Test
    public void test02AutoSeEncuentraConSorpresaFavorable() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra, 1 Pozo y 1 SorpresaFavorable
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        SorpresaFavorable sorpresa = new SorpresaFavorable();
        Pozo pozo = new Pozo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarSorpresa(sorpresa);
        cuadra.agregarObstaculo(pozo);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, el auto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Auto auto = new Auto(esquinaUno, jugador);
        jugador.asignarVehiculo(auto);

        // Le digo al jugador que mueva el auto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);
        int movimientos = jugador.cantidadDeMovimientos();

        // Verifico que haya restado el 20 porciento de los movimientos
        assertEquals(3, movimientos);
    }

    @Test
    public void test03AutoSeEncuentraConSorpresaDesfavorable() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra, 1 Pozo y 1 SorpresaDesfavorable
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        SorpresaDesfavorable sorpresa = new SorpresaDesfavorable();
        Pozo pozo = new Pozo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarSorpresa(sorpresa);
        cuadra.agregarObstaculo(pozo);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, el auto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Auto auto = new Auto(esquinaUno, jugador);
        jugador.asignarVehiculo(auto);

        // Le digo al jugador que mueva el auto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);
        int movimientos = jugador.cantidadDeMovimientos();

        // Verifico que haya sumado el 25 porciento de los movimientos
        assertEquals(5, movimientos);
    }

    @Test
    public void test04AutoSeEncuentraConUnaSorpresaDeCambioDeVehiculoYSeVuelveUna4x4() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y 1 sorpresa de cambio de vehiculo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarSorpresa(sorpresa);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, el auto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Auto auto = new Auto(esquinaUno, jugador);
        jugador.asignarVehiculo(auto);

        // Le digo al jugador que mueva el auto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);

        // Verifico que haya cambiado de vehiculo a una instancia de cuatro por cuatro
        assertEquals(CuatroPorCuatro.class, jugador.obtenerVehiculo().getClass());
    }

    @Test
    public void test05MotoSeEncuentraConTresSorpresasCambioDeVehiculoYVuelveASerMoto() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y agrego 3 sorpresas de cambio de vehiculo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarSorpresa(sorpresa);
        cuadra.agregarSorpresa(sorpresa);
        cuadra.agregarSorpresa(sorpresa);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, la moto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Moto moto = new Moto(esquinaUno, jugador);
        jugador.asignarVehiculo(moto);

        // Le digo al jugador que mueva la moto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);

        // Verifico que haya cambiado de vehiculo a una nueva instancia de moto
        assertEquals(Moto.class, jugador.obtenerVehiculo().getClass());
    }
}

