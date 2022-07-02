package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorMapa extends BorderPane {
    private Stage stage;
    private Juego juego;
    private MenuBar menuBar;

    public ContenedorMapa(Stage stage, Juego juego ) {
        this.stage = stage;
        this.juego = juego;

        this.setCentro();
    }

    private void setCentro() {
        GridPane gridPane = new GridPane();
        int dimension_x = 10;
        int dimension_y = 10;

        for(int i = 0; i < 2 * dimension_x; i++) {
            for(int j = 0; j < 2 * dimension_y; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-manzana");
                    boton.setDisable(true);
                    gridPane.add(boton, i, j);
                }

                else if (i % 2 != 0 && j % 2 != 0) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-esquina");
                    boton.setDisable(true);
                    gridPane.add(boton, j, i);
                }

                else if (i % 2 != 0 && j % 2 == 0) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-calleHorizontal");
                    boton.setDisable(true);
                    gridPane.add(boton, j, i);
                }

                else if (i % 2 == 0 && j % 2 != 0) {
                    Button boton = new Button("");
                    boton.getStyleClass().add("boton-calleVertical");
                    boton.setDisable(true);
                    gridPane.add(boton, j, i);
                }


            }
        }

        VBox caja0 = new VBox();
        caja0.getStyleClass().add("boton-autoFeo");
        gridPane.add(caja0, 5, 5);

        /*
        Button boton = new Button("");
        boton.getStyleClass().add("boton-esquina");
        boton.setDisable(true);
        gridPane.add(boton, 0, 0);

        Button boton1 = new Button("");
        boton1.getStyleClass().add("boton-calleHorizontal");
        boton1.setDisable(true);
        gridPane.add(boton1, 1, 0);

        Button boton2 = new Button("");
        boton2.getStyleClass().add("boton-esquina");
        boton2.setDisable(true);
        gridPane.add(boton2, 2, 0);

        Button boton3 = new Button("");
        boton3.getStyleClass().add("boton-calleVertical");
        boton3.setDisable(true);
        gridPane.add(boton3, 0, 1);

        Button boton4 = new Button("");
        boton4.getStyleClass().add("boton-esquina");
        boton4.setDisable(true);
        gridPane.add(boton4, 0, 2);

        Button boton5 = new Button("");
        boton5.getStyleClass().add("boton-manzana");
        boton5.setDisable(true);
        gridPane.add(boton5, 1, 1);

        Button boton6 = new Button("");
        boton6.getStyleClass().add("boton-esquina");
        boton6.setDisable(true);
        gridPane.add(boton6, 2, 2);

        Button boton7 = new Button("");
        boton7.getStyleClass().add("boton-calleHorizontal");
        boton7.setDisable(true);
        gridPane.add(boton7, 1, 2);

        Button boton8 = new Button("");
        boton8.getStyleClass().add("boton-calleVertical");
        boton8.setDisable(true);
        gridPane.add(boton8, 2, 1);




        /*VBox caja0 = new VBox();
        caja0.getStyleClass().add("boton-esquina");
        gridPane.add(caja0, 0, 0);


        VBox caja1 = new VBox();
        caja1.getStyleClass().add("boton-calleHorizontal");
        gridPane.add(caja1, 0, 1);

        VBox caja2 = new VBox();
        caja2.getStyleClass().add("boton-esquina");
        gridPane.add(caja2, 0, 2);

        VBox caja3 = new VBox();
        caja3.getStyleClass().add("boton-calleVertical");
        gridPane.add(caja3, 1, 0);

        VBox caja4 = new VBox();
        caja4.getStyleClass().add("boton-esquina");
        gridPane.add(caja4, 2, 0);

        VBox caja5 = new VBox();
        caja5.getStyleClass().add("boton-calleHorziontal");
        gridPane.add(caja5, 1, 2);

        VBox caja6 = new VBox();
        caja6.getStyleClass().add("boton-calleVertical");
        gridPane.add(caja6, 2, 1);

        VBox caja7 = new VBox();
        caja7.getStyleClass().add("boton-esquina");
        gridPane.add(caja7, 2, 2);

        VBox caja8 = new VBox();
        caja8.getStyleClass().add("boton-manzana");
        gridPane.add(caja8, 1, 1);

         */

        this.setCenter(gridPane);
    }



}
