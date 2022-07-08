package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.*;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class ContenedorMapa extends VBox  {
    private Juego juego;
    private Stage stage;

    public ContenedorMapa( Juego juego,Stage stage ) {
        this.stage = stage;
        this.juego = juego;
        this.setCentro();
    }


    public void setCentro() {

        GridPane gridPane = new GridPane();
        int dimension_x = 10;
        int dimension_y = 10;

        for(int i = 0; i < 2 * dimension_x - 1; i++) {
            for(int j = 0; j < 2 * dimension_y - 1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-esquina");
                    gridPane.add(boton, i, j);
                }

                else if (i % 2 != 0 && j % 2 != 0) {
                    Button boton = new Button("");
                    int numero = i + j;
                    if(numero < 10)
                        boton.getStyleClass().add("boton-manzana");
                    else if(numero < 20)
                        boton.getStyleClass().add("boton-manzana2");
                    else if(numero < 30)
                        boton.getStyleClass().add("boton-manzana3");
                    else
                        boton.getStyleClass().add("boton-manzana4");
                    gridPane.add(boton, j, i);
                }

                else if (i % 2 == 0 ) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-calleHorizontal");
                    gridPane.add(boton, j, i);
                }

                else {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-calleVertical");
                    gridPane.add(boton, j, i);
                }

            }
        }

        ArrayList<Cuadra> cuadras = juego.getCuadras();

        int contador = 0;
        for(int fila = 0; fila < 10; fila++) {
            for(int columna = 0; columna < 9; columna++) {
                String dibujoBoton = cuadras.get(contador).imprimirCuadra();
                if (!Objects.equals(dibujoBoton, "Nada")) {
                    VBox caja = new VBox();
                    caja.getStyleClass().add(cuadras.get(contador).imprimirCuadra());
                    gridPane.add(caja, 2 * columna + 1, 2 * fila);
                }
                contador ++;
            }
        }

        for(int columna = 0; columna < 10; columna++) {
            for(int fila = 0; fila < 9; fila++) {
                String dibujoBoton = cuadras.get(contador).imprimirCuadra();
                if (!Objects.equals(dibujoBoton, "Nada")) {
                    VBox caja = new VBox();
                    caja.getStyleClass().add(cuadras.get(contador).imprimirCuadra());
                    gridPane.add(caja, 2 * columna, 2 * fila + 1);
                }
                contador ++;
            }
        }

        for(Jugador jugador:juego.getJugadores()) {
            VBox cajaVehiculo = new VBox();
            Vehiculo vehiculo = jugador.obtenerVehiculo();
            Esquina posicion = vehiculo.obtenerPosicion();

            cajaVehiculo.getStyleClass().add(vehiculo.imprimir() + "-mapa");
            gridPane.add(cajaVehiculo, 2 * posicion.getPosicionX(), 2 * posicion.getPosicionY());
        }

        // DIBUJO META
        VBox caja0 = new VBox();
        caja0.getStyleClass().add("boton-meta");
        gridPane.add(caja0, 2 * 9, 2 * 9);

        this.getChildren().add(gridPane);
    }




}
