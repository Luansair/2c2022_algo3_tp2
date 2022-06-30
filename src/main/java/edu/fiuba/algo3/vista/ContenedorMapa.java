package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonContinuarEventHandler;
import edu.fiuba.algo3.vista.eventos.TextoDimensionEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorMapa extends BorderPane {

    private Juego juego;
    private Stage stage;
    private BarraDeMenu menuBar;

    public ContenedorMapa(Stage stage, Juego juego)  {
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

        Image imagen = new Image("file:imagenes/pantallaComienzo.png");
        BackgroundImage backgroundImage = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pantallaDimension.setBackground(new Background(backgroundImage));

        Label label = new Label("Ingresar dimension del mapa");

        TextField textoDimension = new TextField();

        Button botonContinuar = new Button("¨Continuar");

        TextoDimensionEventHandler textoDimensionEventHandler = new TextoDimensionEventHandler();
        textoDimension.setOnAction(textoDimensionEventHandler);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);

        BotonContinuarEventHandler botonContinuarEventHandler = new BotonContinuarEventHandler(contenedorPrincipal, stage);
        botonContinuar.setOnAction(botonContinuarEventHandler);

        pantallaDimension.getChildren().addAll(label,textoDimension,botonContinuar);
        this.setCenter(pantallaDimension);

    }


}
