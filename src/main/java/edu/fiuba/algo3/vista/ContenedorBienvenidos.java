package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonEntrarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonPuntuacionesEventHandler;
import edu.fiuba.algo3.vista.eventos.OpcionEntrarEventHandler;
import edu.fiuba.algo3.vista.eventos.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

    private Juego juego;
    private Stage stage;

    public ContenedorBienvenidos(Stage stage, Juego juego) {

        super();

        this.stage = stage;
        this.juego = juego;

        this.getStyleClass().add("border-vox");
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(95,20,20,20));
        this.setSpacing(60);

        Label label = new Label("Bienvenidos a GPS");

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar");
        botonEntrar.getStyleClass().add("boton-comienzo");
        botonEntrar.setMinSize(75,25);

        Button botonPuntuaciones = new Button();
        botonPuntuaciones.setText("Puntuaciones");
        botonPuntuaciones.getStyleClass().add("boton-comienzo");
        botonPuntuaciones.setMinSize(75,25);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.getStyleClass().add("boton-comienzo");
        botonSalir.setMinSize(75,25);

        BotonEntrarEventHandler botonEntrarEventHandler = new BotonEntrarEventHandler(stage, juego);
        botonEntrar.setOnAction(botonEntrarEventHandler);

        BotonPuntuacionesEventHandler botonPuntuacionesEventHandler = new BotonPuntuacionesEventHandler(juego, stage);
        botonPuntuaciones.setOnAction(botonPuntuacionesEventHandler);

        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(opcionSalirEventHandler);

        this.getChildren().addAll(label, botonEntrar,botonPuntuaciones, botonSalir);

    }


}
