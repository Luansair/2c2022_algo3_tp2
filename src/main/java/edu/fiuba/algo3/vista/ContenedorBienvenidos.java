package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonContinuarEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonCreditosEventHandler;
import edu.fiuba.algo3.vista.eventos.OpcionSalirEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

    private Juego juego;
    private Stage stage;

    public ContenedorBienvenidos(Stage stage, Juego juego) {

        super();

        this.stage = stage;
        this.juego = juego;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(25);

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar");
        botonEntrar.setMinSize(75,25);

        Button botonCreditos = new Button();
        botonCreditos.setText("Creditos");
        botonCreditos.setMinSize(75,25);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setMinSize(75,25);

        ContenedorMapa contenedorMapa = new ContenedorMapa(stage, juego);
        BotonContinuarEventHandler botonContinuarEventHandler = new BotonContinuarEventHandler(contenedorMapa,stage);
        botonEntrar.setOnAction(botonContinuarEventHandler);

        BotonCreditosEventHandler botonCreditosEventHandler = new BotonCreditosEventHandler();
        botonCreditos.setOnAction(botonCreditosEventHandler);

        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(opcionSalirEventHandler);

        this.getChildren().addAll(botonEntrar, botonCreditos, botonSalir);

    }


}
