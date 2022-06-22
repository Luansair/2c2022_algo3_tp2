package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.codigo.obstaculos.Obstaculo;
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

    public Mapa() {
        cuadras = new ArrayList<>();
    }

    public Mapa crearMapa(int dimension_x, int dimension_y) {
        Mapa mapa = new Mapa();

        // Me creo la matriz de esquinas
        Esquina [][] esquinas = new Esquina[dimension_x][dimension_y];
        for(int x = 0; x < dimension_x; x++) {
            for(int y = 0; y < dimension_y; y++) {
                esquinas[x][y] = new Esquina(x, y);
            }
        }

        // Me creo las cuadras horizontales
        for(int y = 0; y < dimension_y; y++) {
            for(int x = 0; x < dimension_x - 1; x++) {
                mapa.agregarCuadra(new Cuadra(esquinas[x][y], esquinas[x+1][y]));
            }
        }

        // Me creo las cuadras verticales
        for(int x = 0; x < dimension_x; x++) {
            for(int y = 0; y < dimension_y - 1; y++) {
                mapa.agregarCuadra(new Cuadra(esquinas[x][y], esquinas[x][y+1]));
            }
        }

        for (Cuadra cuadra:mapa.cuadras){
            // Es probable que la cuadra no tenga nada basandonos en la imagen de la consigna
            if(Math.random() < 0.7) { continue; }

            double numero = Math.random();
            int maxElementos; //determina la cantidad de cosas en una misma cuadra

            if(numero < 0.8){
                maxElementos = 1;
            } else if(numero < 0.95){
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
                    cuadra.agregarObstaculo(new Piquete());
                } else if(elemento == 6) {
                    cuadra.agregarObstaculo(new ControlPolicial());
                }
            }
        }

        return mapa;
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
}
