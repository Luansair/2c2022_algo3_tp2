package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.ArchivoPuntuacion;
import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.vista.eventos.BotonVolverMenuEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class ContenedorMeta extends VBox {

    public ContenedorMeta(Juego juego, Stage stage) throws IOException {
        this.getStyleClass().add("pantalla-final");
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(100,0,0,0));

        VBox  pantallaJugadores = new VBox();
        pantallaJugadores.setAlignment(Pos.CENTER);
        Label titulo = new Label("Jugador" + "          " + "Puntaje");
        titulo.getStyleClass().add("label-titulo");
        pantallaJugadores.getChildren().addAll(titulo);

        for(Jugador jugador : juego.scores) {
            Label etiqueta = new Label(jugador.getNombre() + "                         " + jugador.cantidadDeMovimientos());
            etiqueta.getStyleClass().add("label-jugadores");
            pantallaJugadores.getChildren().addAll(etiqueta);
        }

        juego.escribirPuntajes();

        HBox pantallaVolver = new HBox();
        pantallaVolver.setAlignment(Pos.BOTTOM_CENTER);
        Button volverMenu = new Button("Volver al menú principal");
        volverMenu.getStyleClass().add("boton");
        pantallaVolver.getChildren().add(volverMenu);

        this.setSpacing(60);
        this.getChildren().addAll(pantallaJugadores,pantallaVolver);


        BotonVolverMenuEventHandler evento = new BotonVolverMenuEventHandler(stage, juego);
        volverMenu.setOnAction(evento);

        this.getChildren().add(volverMenu);

    }
}
