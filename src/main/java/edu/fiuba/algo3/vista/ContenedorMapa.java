package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.*;
import edu.fiuba.algo3.modelo.codigo.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverAbajo;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverArriba;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverDerecha;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverIzquierda;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class ContenedorMapa extends BorderPane {
    private Stage stage;
    private Juego juego;
    private MenuBar menuBar;

    public ContenedorMapa(Stage stage, Juego juego ) {
        this.stage = stage;
        this.juego = juego;

        this.setCentro(juego.obtenerMapa());
    }

    private void setCentro(Mapa mapa) {
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
                    //boton.setDisable(true);
                    gridPane.add(boton, j, i);
                }

                else if (i % 2 == 0 && j % 2 != 0) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-calleHorizontal");
                    //boton.setDisable(true);
                    gridPane.add(boton, j, i);
                }

                else if (i % 2 != 0 && j % 2 == 0) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-calleVertical");
                    //boton.setDisable(true);
                    gridPane.add(boton, j, i);
                }


            }
        }

        ArrayList<Cuadra> cuadras = mapa.getCuadras();

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

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 9; j++) {
                String dibujoBoton = cuadras.get(contador).imprimirCuadra();
                if (!Objects.equals(dibujoBoton, "Nada")) {
                    VBox caja = new VBox();
                    caja.getStyleClass().add(cuadras.get(contador).imprimirCuadra());
                    gridPane.add(caja, 2 * i, 2 * j + 1);
                }
                contador ++;
            }
        }

        for(Jugador jugador:juego.getJugadores()) {
            VBox caja0 = new VBox();
            Vehiculo vehiculo = jugador.obtenerVehiculo();
            Esquina posicion = vehiculo.obtenerPosicion();

            caja0.getStyleClass().add(vehiculo.imprimir());
            gridPane.add(caja0, 2 * posicion.posicion_x, 2 * posicion.posicion_y);
        }

        Button botonArriba = new Button("Arriba");
        BotonMoverArriba opcionArriba = new BotonMoverArriba(juego, stage);
        botonArriba.setOnAction(opcionArriba);
        gridPane.add(botonArriba, 21, 1);

        Button botonAbajo = new Button("Abajo");
        BotonMoverAbajo opcionAbajo = new BotonMoverAbajo(juego, stage);
        botonAbajo.setOnAction(opcionAbajo);
        gridPane.add(botonAbajo, 21, 2);

        Button botonDerecha = new Button("Derecha");
        BotonMoverDerecha opcionDerecha = new BotonMoverDerecha(juego, stage);
        botonDerecha.setOnAction(opcionDerecha);
        gridPane.add(botonDerecha, 22, 2);

        Button botonIzquierda = new Button("Izquierda");
        BotonMoverIzquierda opcionIzquierda = new BotonMoverIzquierda(juego, stage);
        botonIzquierda.setOnAction(opcionIzquierda);
        gridPane.add(botonIzquierda, 20, 2);

        this.setCenter(gridPane);
    }



}
