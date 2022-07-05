package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class ContenedorPrincipal extends BorderPane {

    private Stage stage;
    private Juego juego;
    private BarraDeMenu menuBar;


    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
        this.getStyleClass().add("border-vox");
        this.setMenu();
        this.setCentro();

    }

    private void setMenu() {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
        HBox pantallaPrincipal = new HBox();
        pantallaPrincipal.setSpacing(10);


        Canvas canvas = new Canvas(925,925);
        VBox mapaCamuflado = new VBox(canvas);

        GridPane mapaFinal = new GridPane();
        mapaFinal.getStyleClass().add("fondo-mapa");

        ContenedorMapa contenedorMapa = new ContenedorMapa( juego);

        canvas.getGraphicsContext2D().setFill(Paint.valueOf("#000000"));
        int radio = 200;
        int posicionAutoX = 500;
        int poscionAutoY = 500;
        //canvas.getGraphicsContext2D().fillRect(0,0,925,925);
        //canvas.getGraphicsContext2D().clearRect(posicionAutoX-radio,poscionAutoY-radio, radio * 2,radio*2);
        canvas.getGraphicsContext2D().beginPath();
        canvas.getGraphicsContext2D().arc(200,200,100,100,79,50);

        //canvas.getGraphicsContext2D().lineTo(75,50);
        //canvas.getGraphicsContext2D().closePath();
        canvas.getGraphicsContext2D().stroke();


        mapaFinal.add(contenedorMapa,0,0);
        mapaFinal.add(mapaCamuflado,0,0 );

        ContenedorBotonesMovimiento contenedorBotonesMovimiento = new ContenedorBotonesMovimiento(stage, juego);


        pantallaPrincipal.getChildren().addAll(mapaFinal, contenedorBotonesMovimiento);
        this.setCenter(pantallaPrincipal);
    }
}
