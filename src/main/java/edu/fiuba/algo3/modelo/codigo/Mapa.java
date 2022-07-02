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

    public Mapa() {
        cuadras = new ArrayList<>();
        esquinas = new ArrayList<>();
    }

    public Mapa crearMapa() {
        Mapa mapa = new Mapa();

        // Me creo la matriz de esquinas
        Esquina [][] esquinas = new Esquina[10][10];
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                esquinas[x][y] = new Esquina(x, y);
                mapa.agregarEsquina(esquinas[x][y]);
            }
        }

        // Me creo las cuadras horizontales
        for(int y = 0; y < 10; y++) {
            for(int x = 0; x < 10 - 1; x++) {
                mapa.agregarCuadra(new Cuadra(esquinas[x][y], esquinas[x+1][y]));
            }
        }

        // Me creo las cuadras verticales
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10 - 1; y++) {
                mapa.agregarCuadra(new Cuadra(esquinas[x][y], esquinas[x][y+1]));
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


        /*
        for (Cuadra cuadra:mapa.cuadras){
            // Es probable que la cuadra no tenga nada basandonos en la imagen de la consigna
            if(Math.random() < 0.65) { continue; }

            double numero = Math.random();
            int maxElementos; //determina la cantidad de cosas en una misma cuadra

            if(numero < 0.8) {
                maxElementos = 1;
            } else if(numero < 0.95) {
                maxElementos = 2;
            } else {
                maxElementos = 3;
            }

            for (int i = 0; i < maxElementos; i++) {
                int elemento = new Random().nextInt(7); // determina que se guarda
                if(elemento == 1){
                    cuadra.agregarSorpresa(new SorpresaFavorable());
                } else if(elemento == 2){
                    cuadra.agregarSorpresa(new SorpresaDesfavorable());
                } else if(elemento == 3){
                    cuadra.agregarSorpresa(new SorpresaCambioVehiculo());
                } else if(elemento == 4) {
                    cuadra.agregarObstaculo(new Pozo());
                } else if(elemento == 5) {
                    cuadra.agregarObstaculo(new Piquete()); // Agregar boolean para que no haya 2 piquetes en misma cuadra
                } else if(elemento == 6) {
                    cuadra.agregarObstaculo(new ControlPolicial());
                }
            }
        }
        */

        return mapa;
    }

    //Getter para dibujar el mapa
    public ArrayList<Cuadra> getCuadras() {
        return cuadras;
    }

    public void imprimirMapa() {
        for(Cuadra cuadra : cuadras) {
            cuadra.imprimirCuadra();
        }
    }

    public void aplicarObstaculos(Vehiculo unVehiculo, Esquina esquinaUno, Esquina esquinaDos) {
        for (Cuadra cuadra : cuadras) {
            if (cuadra.mismaCuadra(esquinaUno, esquinaDos)) {
                cuadra.aplicarObstaculos(unVehiculo);
            }
        }
    }

    public void aplicarSorpresas(Jugador unJugador, Esquina esquinaUno, Esquina esquinaDos) {
        for (Cuadra cuadra : cuadras) {
            if (cuadra.mismaCuadra(esquinaUno, esquinaDos)) {
                cuadra.aplicarSorpresas(unJugador);
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
