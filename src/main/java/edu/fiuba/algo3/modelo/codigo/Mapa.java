package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Piquete;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Pozo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.codigo.sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    private ArrayList<Cuadra> cuadras;
    private ArrayList<Esquina> esquinas;
    private int dimension_x;
    private int dimension_y;

    private Esquina meta;

    public Mapa() {
        cuadras = new ArrayList<>();
        esquinas = new ArrayList<>();
        dimension_x = 10;
        dimension_y = 10;
        meta = new Esquina(9, 9);
    }

    public Boolean llegueAMeta(Esquina posicion) {
        return posicion.mismaEsquina(meta);
    }

    public void crearMapa() {
        // Me creo la matriz de esquinas
        Esquina [][] esquinas = new Esquina[dimension_x][dimension_y];
        for(int x = 0; x < dimension_x; x++) {
            for(int y = 0; y < dimension_y; y++) {
                esquinas[x][y] = new Esquina(x, y);
                this.agregarEsquina(esquinas[x][y]);
            }
        }

        // Me creo las cuadras horizontales
        for(int y = 0; y < dimension_y; y++) {
            for(int x = 0; x < dimension_x - 1; x++) {
                this.agregarCuadra(new Cuadra(esquinas[x][y], esquinas[x+1][y]));
            }
        }

        // Me creo las cuadras verticales
        for(int x = 0; x < dimension_x; x++) {
            for(int y = 0; y < dimension_y - 1; y++) {
                this.agregarCuadra(new Cuadra(esquinas[x][y], esquinas[x][y+1]));
            }
        }


        cuadras.get(2).agregarObstaculo(new Pozo());
        cuadras.get(11).agregarObstaculo(new Pozo());
        cuadras.get(104).agregarObstaculo(new Pozo());
        cuadras.get(107).agregarObstaculo(new Pozo());
        cuadras.get(116).agregarObstaculo(new Pozo());
        cuadras.get(130).agregarObstaculo(new Pozo());
        cuadras.get(43).agregarObstaculo(new Pozo());
        cuadras.get(55).agregarObstaculo(new Pozo());
        cuadras.get(167).agregarObstaculo(new Pozo());
        cuadras.get(82).agregarObstaculo(new Pozo());
        cuadras.get(85).agregarObstaculo(new Pozo());
        cuadras.get(89).agregarObstaculo(new Pozo());

        cuadras.get(5).agregarObstaculo(new ControlPolicial());
        cuadras.get(8).agregarObstaculo(new ControlPolicial());
        cuadras.get(18).agregarObstaculo(new ControlPolicial());
        cuadras.get(101).agregarObstaculo(new ControlPolicial());
        cuadras.get(108).agregarObstaculo(new ControlPolicial());
        cuadras.get(21).agregarObstaculo(new ControlPolicial());
        cuadras.get(112).agregarObstaculo(new ControlPolicial());
        cuadras.get(34).agregarObstaculo(new ControlPolicial());
        cuadras.get(45).agregarObstaculo(new ControlPolicial());
        cuadras.get(136).agregarObstaculo(new ControlPolicial());
        cuadras.get(47).agregarObstaculo(new ControlPolicial());
        cuadras.get(50).agregarObstaculo(new ControlPolicial());
        cuadras.get(156).agregarObstaculo(new ControlPolicial());
        cuadras.get(159).agregarObstaculo(new ControlPolicial());
        cuadras.get(161).agregarObstaculo(new ControlPolicial());
        cuadras.get(168).agregarObstaculo(new ControlPolicial());
        cuadras.get(77).agregarObstaculo(new ControlPolicial());
        cuadras.get(173).agregarObstaculo(new ControlPolicial());

        cuadras.get(14).agregarObstaculo(new Piquete());
        cuadras.get(111).agregarObstaculo(new Piquete());
        cuadras.get(30).agregarObstaculo(new Piquete());
        cuadras.get(119).agregarObstaculo(new Piquete());
        cuadras.get(125).agregarObstaculo(new Piquete());
        cuadras.get(52).agregarObstaculo(new Piquete());
        cuadras.get(144).agregarObstaculo(new Piquete());
        cuadras.get(63).agregarObstaculo(new Piquete());
        cuadras.get(152).agregarObstaculo(new Piquete());
        cuadras.get(67).agregarObstaculo(new Piquete());
        cuadras.get(179).agregarObstaculo(new Piquete());
        cuadras.get(87).agregarObstaculo(new Piquete());

        cuadras.get(94).agregarSorpresa(new SorpresaCambioVehiculo());
        cuadras.get(11).agregarSorpresa(new SorpresaFavorable());
        cuadras.get(12).agregarSorpresa(new SorpresaCambioVehiculo());
        cuadras.get(110).agregarSorpresa(new SorpresaDesfavorable());
        cuadras.get(117).agregarSorpresa(new SorpresaFavorable());
        cuadras.get(37).agregarSorpresa(new SorpresaDesfavorable());
        cuadras.get(39).agregarSorpresa(new SorpresaCambioVehiculo());
        cuadras.get(46).agregarSorpresa(new SorpresaCambioVehiculo());
        cuadras.get(52).agregarSorpresa(new SorpresaFavorable());
        cuadras.get(147).agregarSorpresa(new SorpresaDesfavorable());
        cuadras.get(62).agregarSorpresa(new SorpresaCambioVehiculo());
        cuadras.get(141).agregarSorpresa(new SorpresaFavorable());
        cuadras.get(143).agregarSorpresa(new SorpresaCambioVehiculo());
        cuadras.get(146).agregarSorpresa(new SorpresaFavorable());
        cuadras.get(72).agregarSorpresa(new SorpresaDesfavorable());
        cuadras.get(75).agregarSorpresa(new SorpresaCambioVehiculo());
        cuadras.get(86).agregarSorpresa(new SorpresaFavorable());
    }

    //Getter para dibujar el mapa
    public ArrayList<Cuadra> getCuadras() {
        return cuadras;
    }

    public Esquina getMeta() {return this.meta;}

    public Boolean posicionValida(Vehiculo vehiculo) {
        Esquina posVehiculo = vehiculo.obtenerPosicion();
        return posVehiculo.coordenadasValidas(0,0,dimension_x-1, dimension_y-1);
    }

    public void aplicarObstaculos(Vehiculo unVehiculo, Esquina esquinaUno, Esquina esquinaDos) {
        for (Cuadra cuadra : cuadras) {
            if (cuadra.mismaCuadra(esquinaUno, esquinaDos)) {
                cuadra.aplicarObstaculos(unVehiculo);
                break;
            }
        }
    }

    public void aplicarSorpresas(Jugador unJugador, Esquina esquinaUno, Esquina esquinaDos) {
        for (Cuadra cuadra : cuadras) {
            if (cuadra.mismaCuadra(esquinaUno, esquinaDos)) {
                cuadra.aplicarSorpresas(unJugador);
                break;
            }
        }
    }

    public void agregarCuadra(Cuadra cuadra) {
        this.cuadras.add(cuadra);
    }

    public void agregarEsquina(Esquina esquina) {
        this.esquinas.add(esquina);
    }

    public Esquina getEsquinaIncial()  {
        return esquinas.get(0);
    }


}
