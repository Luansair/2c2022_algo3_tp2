package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionInferior;
import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionSuperior;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.ReliantRobin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReliantRobinTest {

    @Test
    public void test01CreoMuchasInstanciasDeReliantRobinParaVerSiAlgunosSonMotosYOtrosSonAuto() {
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
        ReliantRobin vehiculo1 = new ReliantRobin(esquinaUno, jugador);
        jugador.asignarVehiculo(vehiculo1);

        Jugador jugador2 = new Jugador(mapa, "Facundo");
        ReliantRobin vehiculo2 = new ReliantRobin(esquinaUno, jugador);
        jugador.asignarVehiculo(vehiculo2);

        Jugador jugador3 = new Jugador(mapa, "Facundo");
        ReliantRobin vehiculo3 = new ReliantRobin(esquinaUno, jugador);
        jugador.asignarVehiculo(vehiculo3);


        System.out.println(vehiculo1.imprimir());
        System.out.println(vehiculo2.imprimir());
        System.out.println(vehiculo3.imprimir());
    }

    @Test
    public void test02JugadorConAutoSeMueveHaciaAbajoLuegoHaciaArribaDeberiaTener2MovimientosEnTotal(){
        int movTotal = 2;

        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador(mapa, "Boadicea");
        jugador.asignarVehiculo(new ReliantRobin(new Esquina(0,0),jugador));

        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(0,1); Cuadra cuadra1 = new Cuadra(esquina1, esquina2);

        mapa.agregarCuadra(cuadra1);

        jugador.moverVehiculo(new DireccionSuperior(mapa)); //o direccion arriba
        jugador.moverVehiculo(new DireccionInferior(mapa)); //o direccion abajo

        assertEquals(movTotal, jugador.cantidadDeMovimientos());
    }

    @Test
    public void test03JugadorDoblaALaDerechaConReliantRobinYSeEncuentraConUnPozoDeberiaTener4Movimientos() {
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

        // Creo el jugador, el Reliant y se la asigno
        Jugador jugador = new Jugador(mapa, "Facundo");
        ReliantRobin reliantRobin = new ReliantRobin(esquinaUno, jugador);
        jugador.asignarVehiculo(reliantRobin);

        // Le digo al jugador que mueva el Reliant
        DireccionDerecha direccionDerecha = new DireccionDerecha(mapa);
        jugador.moverVehiculo(direccionDerecha);

        // Verifico que haya chocado
        int movimientos = jugador.cantidadDeMovimientos();
        assertEquals(4, movimientos);
    }
}
