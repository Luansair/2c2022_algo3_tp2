package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.Message;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebasIntegrales {

    @Test
    public void test01MotoDoblaALaDerechaYSeEncuentraConUnPozo() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y 1 Pozo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        Pozo pozo = new Pozo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarObstaculo(pozo);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, la moto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Moto moto = new Moto(esquinaUno, jugador);
        jugador.asignarVehiculo(moto);

        // Le digo al jugador que mueva la moto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);

        // Verifico que haya chocado
        int movimientos = jugador.cantidadDeMovimientos();
        assertEquals(4, movimientos);
    }

    @Test
    public void test02AutoDoblaALaDerechaYSeEncuentraConUnPozo() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y 1 Pozo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        Pozo pozo = new Pozo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarObstaculo(pozo);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, la moto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Auto auto = new Auto(esquinaUno, jugador);
        jugador.asignarVehiculo(auto);

        // Le digo al jugador que mueva la moto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);
        int movimientos = jugador.cantidadDeMovimientos();

        // Verifico que haya chocado
        assertEquals(4, movimientos);
    }

    @Test
    public void test034x4DoblaALaDerechaYSeEncuentraConUnPozoSumaCero() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y 1 Pozo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        Pozo pozo = new Pozo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarObstaculo(pozo);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, la moto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro(esquinaUno, jugador);
        jugador.asignarVehiculo(cuatroPorCuatro);

        // Le digo al jugador que mueva la moto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);
        int movimientos = jugador.cantidadDeMovimientos();

        // Verifico que haya chocado
        assertEquals(1, movimientos);
    }

    @Test
    public void test044x4DoblaALaDerechaYSeEncuentraConTresPozosSumaTres() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y 3 Pozo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        Pozo pozo = new Pozo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarObstaculo(pozo);
        cuadra.agregarObstaculo(pozo);
        cuadra.agregarObstaculo(pozo);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, la moto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro(esquinaUno, jugador);
        jugador.asignarVehiculo(cuatroPorCuatro);

        // Le digo al jugador que mueva la moto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);
        int movimientos = jugador.cantidadDeMovimientos();

        // Verifico que haya chocado
        assertEquals(3, movimientos);
    }

    @Test
    public void test05MotoDoblaALaDerechaYLuegoALaIzquierdaYChocaDosVecesConElMismoPozo() {
        /* Este test posee la perspectiva de la clase Juego. En el juego real muchas de las instancias y mensajes
        que se detallan a continuación quedarán encapsulados dentro de otras clases
        */

        // Creo un mapa con 2 Esquinas, 1 Cuadra y 3 Pozo
        Esquina esquinaUno = new Esquina(1, 1);
        Esquina esquinaDos = new Esquina(2, 1);

        Pozo pozo = new Pozo();
        Cuadra cuadra = new Cuadra(esquinaUno, esquinaDos);
        cuadra.agregarObstaculo(pozo);
        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra);

        // Creo el jugador, la moto y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        Moto moto = new Moto(esquinaUno, jugador);
        jugador.asignarVehiculo(moto);

        // Le digo al jugador que mueva la moto
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);
        DireccionIzquierda direccionIzquierda = new DireccionIzquierda(mapa);
        jugador.moverVehiculo(direccionIzquierda);
        int movimientos = jugador.cantidadDeMovimientos();

        // Verifico que haya chocado
        assertEquals(8, movimientos);
    }
}
