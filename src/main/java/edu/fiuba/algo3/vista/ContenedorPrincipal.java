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

    //MEDIDOS EN PIXELES
    private int TAMANIOMAPA = 925;
    private int RADIOVISIBLE = 125;
    private int DISTANCIARECORRIDA = 100;


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
        pantallaPrincipal.setMaxHeight(935);
        pantallaPrincipal.setMinHeight(935);
        pantallaPrincipal.setSpacing(15);

        Canvas canvas = new Canvas(TAMANIOMAPA,TAMANIOMAPA);
        VBox mapaCamuflado = new VBox(canvas);

        ContenedorMapa contenedorMapa = new ContenedorMapa( juego,stage);

        GridPane mapaFinal = new GridPane();
        mapaFinal.getStyleClass().add("fondo-mapa");

        canvas.getGraphicsContext2D().setFill(Paint.valueOf("#000000"));
        canvas.getGraphicsContext2D().fillRect(0,0,TAMANIOMAPA,TAMANIOMAPA);
        canvas.getGraphicsContext2D().clearRect(juego.getPosicionX() * DISTANCIARECORRIDA - RADIOVISIBLE, juego.getPosicionY() * DISTANCIARECORRIDA - RADIOVISIBLE, RADIOVISIBLE * 2,RADIOVISIBLE *2);
        canvas.getGraphicsContext2D().clearRect(juego.getMeta().getPosicionX() * DISTANCIARECORRIDA, juego.getMeta().getPosicionY() * DISTANCIARECORRIDA, RADIOVISIBLE,RADIOVISIBLE);

        mapaFinal.add(contenedorMapa,0,0);
        mapaFinal.add(mapaCamuflado,0,0 );

        ContenedorBotonesMovimiento contenedorBotonesMovimiento = new ContenedorBotonesMovimiento(stage, juego);

        pantallaPrincipal.getChildren().addAll(mapaFinal, contenedorBotonesMovimiento);
        this.setCenter(pantallaPrincipal);
    }
}
