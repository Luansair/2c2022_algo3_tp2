package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.OpcionDimensionEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorDimension extends BorderPane {
    private Juego juego;
    private Stage stage;
    private BarraDeMenu menuBar;

    public ContenedorDimension(Stage stage, Juego juego)  {
        this.juego = juego;
        this.stage = stage;

        this.setMenu();
        this.setCentro();
    }

    private void setMenu() {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro()  {
        VBox pantallaDimension = new VBox();

        pantallaDimension.setAlignment(Pos.TOP_CENTER);
        pantallaDimension.setSpacing(70);
        pantallaDimension.setPadding(new Insets(50,50,50,50));
        this.getStyleClass().add("border-vox");


        Label label = new Label("Ingresar la dimension del mapa");
        label.getStyleClass().add("texto-predeterminado");


        HBox pantallaOpciones = new HBox();
        pantallaOpciones.setAlignment(Pos.CENTER);
        pantallaOpciones.setPadding(new Insets(30,40,40,10));
        pantallaOpciones.setSpacing(60);

        ComboBox<Integer> opcionesDimensionIzquierda = new ComboBox<>();
        opcionesDimensionIzquierda.getItems().addAll(2,3,4,5,6,7);
        opcionesDimensionIzquierda.getStyleClass().add("opcion");

        ComboBox<Integer> opcionesDimensionDerecha = new ComboBox<>();
        opcionesDimensionDerecha.getItems().addAll(2,3,4,5,6,7);
        opcionesDimensionDerecha.getStyleClass().add("opcion");

        Label separador = new Label("X");
        separador.getStyleClass().add("texto-predeterminado");
        pantallaOpciones.getChildren().addAll(opcionesDimensionIzquierda, separador, opcionesDimensionDerecha);

        pantallaDimension.getChildren().addAll(label, pantallaOpciones);
        this.setCenter(pantallaDimension);


        HBox pantallaContinuar = new HBox();
        pantallaContinuar.setAlignment(Pos.BOTTOM_RIGHT);
        Button botonContinuar = new Button(">");
        botonContinuar.getStyleClass().add("boton-continuar");
        OpcionDimensionEventHandler opcionDimensionEventHandler = new OpcionDimensionEventHandler(opcionesDimensionIzquierda, opcionesDimensionDerecha, juego, stage);
        botonContinuar.setOnAction(opcionDimensionEventHandler);
        pantallaContinuar.getChildren().add(botonContinuar);
        pantallaContinuar.setPadding(new Insets(0,60,60,60));

        this.setBottom(pantallaContinuar);
    }
}
