package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonContinuarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonCreditosEventHandler;
import edu.fiuba.algo3.vista.eventos.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

    private Juego juego;
    private Stage stage;

    public ContenedorBienvenidos(Stage stage, Juego juego) {

        super();

        this.stage = stage;
        this.juego = juego;

        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(95,20,20,20));
        this.setSpacing(60);

        Image imagen = new Image("file:imagenes/pantallaComienzo.png");
        BackgroundImage backgroundImage = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));

        Label label = new Label("Bienvenidos a GPS");

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar");
        botonEntrar.getStyleClass().add("boton-comienzo");
        botonEntrar.setMinSize(75,25);

        Button botonCreditos = new Button();
        botonCreditos.setText("Creditos");
        botonCreditos.getStyleClass().add("boton-comienzo");
        botonCreditos.setMinSize(75,25);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.getStyleClass().add("boton-comienzo");
        botonSalir.setMinSize(75,25);

        ContenedorMapa contenedorMapa = new ContenedorMapa(stage, juego);
        BotonContinuarEventHandler botonContinuarEventHandler = new BotonContinuarEventHandler(contenedorMapa,stage);
        botonEntrar.setOnAction(botonContinuarEventHandler);

        BotonCreditosEventHandler botonCreditosEventHandler = new BotonCreditosEventHandler();
        botonCreditos.setOnAction(botonCreditosEventHandler);

        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(opcionSalirEventHandler);

        this.getChildren().addAll(label, botonEntrar,botonCreditos, botonSalir);

    }


}
