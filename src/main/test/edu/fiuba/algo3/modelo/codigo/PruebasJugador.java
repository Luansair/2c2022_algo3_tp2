package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebasJugador {

    @Test
    public void test01JugadorDoblaALaDerechaConMotoYSeEncuentraConUnPozoDeberiaSumar4Movimientos() {
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
    public void test02JugadorDoblaALaDerechaConAutoYSeEncuentraConUnPozoDeberiaSumar4Movimientos() {
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
    public void test03JugadorDoblaALaDerechaCon4x4YSeEncuentraConUnPozoDeberiaSumarUnMovimiento() {
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
    public void test04JugadorCon4x4DoblaALaDerechaYSeEncuentraConTresPozosDeberiaSumarSoloTresMovimientos() {
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
    public void test05JugadorConMotoDoblaALaDerechaYLuegoALaIzquierdaYChocaDosVecesConElMismoPozoDeberiaSumar8Movimientos() {
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

    @Test
    public void test06JugadorMueveAutoTresCuadrasALaDerechaConUnPozoEnLasPrimerasDosYDeberiaSumar9Movimientos(){
        int movTotal = 9; // 3 movimientos por pozo -> 2 * 3 = 6 + 3 movimientos = 9 movimientos totales.

        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(1,0);
        Esquina esquina3 = new Esquina(2,0);
        Esquina esquina4 = new Esquina(3,0);
        Esquina esquinaActual = new Esquina(0,0);

        Cuadra cuadra1 = new Cuadra(esquina1, esquina2);
        Cuadra cuadra2 = new Cuadra(esquina2, esquina3);
        Cuadra cuadra3 = new Cuadra(esquina3, esquina4);
        cuadra1.agregarObstaculo(new Pozo());
        cuadra2.agregarObstaculo(new Pozo());

        Mapa mapa = new Mapa();
        mapa.agregarCuadra(cuadra1);
        mapa.agregarCuadra(cuadra2);
        mapa.agregarCuadra(cuadra3);

        Jugador jugador = new Jugador(mapa, "a");
        jugador.asignarVehiculo(new Auto(esquinaActual, jugador));

        jugador.moverVehiculo(new DireccionDerecha(mapa));
        jugador.moverVehiculo(new DireccionDerecha(mapa));
        jugador.moverVehiculo(new DireccionDerecha(mapa));

        assertEquals(movTotal,jugador.cantidadDeMovimientos());
    }
    @Test
    public void test07JugadorConMotoSeEncuentraConSorpresaCambioDeVehiculoYSeVuelveUnAuto() {
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
    public void test08JugadorConAutoSeEncuentraConSorpresaFavorableYDeberiaReducirUn25PorcientoSusMovimientos() {
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
    public void test09JugadorConAutoSeEncuentraConSorpresaDesfavorableYDeberiaAumentarUn25PorcientoSusMovimientos() {
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
    public void test10JugadorConAutoSeEncuentraConUnaSorpresaDeCambioDeVehiculoYSeVuelveUna4x4() {
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
    public void test11JugadorConMotoSeEncuentraConTresSorpresasCambioDeVehiculoYVuelveATenerUnaMoto() {
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
    @Test
    public void test12JugadorConMotoChocaDosPozosYUnCambioDeVehiculoLuegoChocaUnPozoYUnCambioDeVehiculoLuegoChocoDosPozosTodoEn7MovimientosALaDerechaDeberiaDarme18MovimientosEnTotal(){
        int movTotal = 18;

        Mapa mapa = new Mapa();

        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(1,0); Cuadra cuadra1 = new Cuadra(esquina1, esquina2); cuadra1.agregarObstaculo(new Pozo());
        Esquina esquina3 = new Esquina(2,0); Cuadra cuadra2 = new Cuadra(esquina2, esquina3); cuadra2.agregarObstaculo(new Pozo());
        Esquina esquina4 = new Esquina(3,0); Cuadra cuadra3 = new Cuadra(esquina3, esquina4); cuadra3.agregarSorpresa(new SorpresaCambioVehiculo());
        Esquina esquina5 = new Esquina(4,0); Cuadra cuadra4 = new Cuadra(esquina4, esquina5); cuadra4.agregarObstaculo(new Pozo());
        Esquina esquina6 = new Esquina(5,0); Cuadra cuadra5 = new Cuadra(esquina5, esquina6); cuadra5.agregarSorpresa(new SorpresaCambioVehiculo());
        Esquina esquina7 = new Esquina(6,0); Cuadra cuadra6 = new Cuadra(esquina6, esquina7); cuadra6.agregarObstaculo(new Pozo());
        Esquina esquina8 = new Esquina(7,0); Cuadra cuadra7 = new Cuadra(esquina7, esquina8); cuadra7.agregarObstaculo(new Pozo());

        mapa.agregarCuadra(cuadra1);
        mapa.agregarCuadra(cuadra2);
        mapa.agregarCuadra(cuadra3);
        mapa.agregarCuadra(cuadra4);
        mapa.agregarCuadra(cuadra5);
        mapa.agregarCuadra(cuadra6);
        mapa.agregarCuadra(cuadra7);

        Jugador jugador = new Jugador(mapa, "Ghengis");
        jugador.asignarVehiculo(new Moto(new Esquina(0,0),jugador));

        for (int i = 0; i < 7; i++) {
            jugador.moverVehiculo(new DireccionDerecha(mapa));
        }

        assertEquals(movTotal, jugador.cantidadDeMovimientos());
    }
}
