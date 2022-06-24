package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VistaMapa extends HBox {

    private Juego juego;
    private Stage stage;

    public VistaMapa(Stage stage, Juego juego) {
        GridPane mapaVista = new GridPane();

        //UNA IDEA
        /*int contadorEsquinas = 0;
        int contadorCuadras = 0;
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; i++) {
                if ( j % 2 = 0 & i % 2 =0) {
                    mapaVista.add(juego.getEsquina(contadorEsquinas), i, j);
                    contadorEsquinas ++;
                } else if( j % 2 != 0 & i % 2 != 0) {
                    mapaVista.add(new VBox(), i, j);
                } else {
                    mapaVista.add(juego.getCuadra(contadorCuadras),i,j);
                }

            }
        }*/


    }



}
