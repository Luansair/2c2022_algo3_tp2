package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.*;
import edu.fiuba.algo3.modelo.codigo.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverAbajo;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverArriba;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverDerecha;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverIzquierda;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class ContenedorMapa extends VBox  {
    private Juego juego;

    public ContenedorMapa( Juego juego ) {
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


        for(Jugador jugador:juego.getJugadores()) {
            VBox caja0 = new VBox();
            Vehiculo vehiculo = jugador.obtenerVehiculo();
            Esquina posicion = vehiculo.obtenerPosicion();

            caja0.getStyleClass().add(vehiculo.imprimir() + "-mapa");
            gridPane.add(caja0, 2 * posicion.posicion_x, 2 * posicion.posicion_y);
        }


        this.getChildren().add(gridPane);
    }




}
