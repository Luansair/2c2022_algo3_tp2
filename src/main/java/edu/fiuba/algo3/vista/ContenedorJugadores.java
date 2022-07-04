package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ContenedorJugadores extends VBox {
    private Stage stage;
    private Juego juego;


    public ContenedorJugadores(Stage stage, Juego juego) {

        super();

        this.stage = stage;
        this.juego = juego;

        this.getStyleClass().add("border-vox");
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(95,20,20,20));
        this.setSpacing(60);

        Label label = new Label("Jugadores");
        label.getStyleClass().add("texto-predeterminado");

        this.getChildren().add(label);

        Button botonAgregar = new Button();
        botonAgregar.setText("Agregar Jugador");
        botonAgregar.getStyleClass().add("boton-comienzo");
        botonAgregar.setMinSize(75,25);


        OpcionAgregarJugador opcionAgregarJugador = new OpcionAgregarJugador(stage, juego);
        botonAgregar.setOnAction(opcionAgregarJugador);

        //Jugadores de momento
        ArrayList<Jugador> jugadores = juego.getJugadores();
        VBox pantallaNombre = new VBox();
        pantallaNombre.setPadding(new Insets(0,200,0,80));
        Label etiquetaTitulo = new Label("Jugadores:");
        etiquetaTitulo.getStyleClass().add("texto-predeterminado");

        if(jugadores != null) {
            for(int i = 0; i < jugadores.size(); i++) {
                this.getStyleClass().add("border-vox");
                this.setAlignment(Pos.TOP_CENTER);
                this.setPadding(new Insets(95,20,20,20));
                this.setSpacing(30);

                Label jugador = new Label(jugadores.get(i).nombre());
                jugador.getStyleClass().add("texto-predeterminado");
                this.getChildren().add(jugador);
            }
        }

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.getStyleClass().add("boton-comienzo");
        botonJugar.setMinSize(75,25);


        OpcionJugar opcionJugar = new OpcionJugar(stage, juego);
        botonJugar.setOnAction(opcionJugar);

        this.getChildren().addAll(botonAgregar, botonJugar);

    }



}

