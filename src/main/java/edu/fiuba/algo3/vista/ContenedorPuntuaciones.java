package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonRankingEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.print.attribute.standard.PrinterMakeAndModel;


public class ContenedorPuntuaciones extends VBox {

    public ContenedorPuntuaciones(Juego juego, Stage stage)  {
        this.getStyleClass().add("border-vox");

        VBox pantallaPrincipal = new VBox();
        Label labelTitulo = new Label("Tabla de puntuacion");
        labelTitulo.getStyleClass().add("texto-predeterminado");

        Label labelPedirNombre = new Label("Ingresar nickName del jugador:");
        labelPedirNombre.getStyleClass().add("texto-predeterminado");

        TextField textoNombre = new TextField();
        textoNombre.getStyleClass().add("textfill-nombre");

        Label labelVacio = new Label();
        labelVacio.getStyleClass().add("texto-preventivo");

        pantallaPrincipal.setPadding(new Insets(50,0,0,0));
        pantallaPrincipal.setAlignment(Pos.CENTER);
        pantallaPrincipal.setSpacing(20);
        pantallaPrincipal.getStyleClass().add("panel-semitransparente");
        pantallaPrincipal.getChildren().addAll(labelTitulo,labelPedirNombre, textoNombre, labelVacio);

        HBox pantallaRanking = new HBox();
        pantallaRanking.setAlignment(Pos.BOTTOM_CENTER);
        Button botonRanking = new Button("Ver Ranking");
        botonRanking.getStyleClass().add("boton-predeterminado");
        pantallaRanking.getChildren().add(botonRanking);

        BotonRankingEventHandler botonRankingEventHandler = new BotonRankingEventHandler(stage,juego, textoNombre, labelVacio);
        botonRanking.setOnAction(botonRankingEventHandler);

        this.setSpacing(150);
        this.setPadding(new Insets(0,200,100,100));
        this.getChildren().addAll(pantallaPrincipal,pantallaRanking);

    }
}