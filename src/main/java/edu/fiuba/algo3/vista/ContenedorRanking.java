package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.ArchivoPuntuacion;
import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonVolverMenuEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.util.Collections;

import java.util.ArrayList;


public class ContenedorRanking extends VBox {
    private Stage stage;
    private Juego juego;
    private String nombreJugador;
    public ContenedorRanking(Stage stage, Juego juego, String nombreJugador) throws Exception {
        this.stage = stage;
        this.juego = juego;
        this.nombreJugador = nombreJugador;
        this.getStyleClass().add("border-vox");

        Label label = new Label("Tabla de puntuaciones");
        label.getStyleClass().add("texto-predeterminado");
        this.getChildren().addAll(label);

        Label titulo = new Label("Jugador" + "             " + "Movimientos");
        titulo.getStyleClass().add("texto-predeterminado");
        this.getChildren().addAll(titulo);
        ;
        ArrayList<Pair<String, Integer>> puntuaciones = juego.leerPuntajes();
        ArrayList<Integer> puntuacionesJugadorElegido = new ArrayList<>();

        for(Pair<String, Integer> tupla: puntuaciones) {
            if (tupla.getKey().equals(nombreJugador) ) {
                puntuacionesJugadorElegido.add(tupla.getValue());
            }
        }

        Collections.sort(puntuacionesJugadorElegido);

        for (int i = 0; (i < 5 && i < puntuacionesJugadorElegido.size() ); i ++) {
            Label etiqueta = new Label(nombreJugador + "             " + puntuacionesJugadorElegido.get(i));
            etiqueta.getStyleClass().add("texto-predeterminado");
            this.getChildren().addAll(etiqueta);
        }
        Button volverMenu = new Button("Volver al menú principal");
        volverMenu.getStyleClass().add("boton-predeterminado");

        BotonVolverMenuEventHandler botonVolverMenuEventHandler = new BotonVolverMenuEventHandler(stage, juego);
        volverMenu.setOnAction(botonVolverMenuEventHandler);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(33);
        this.getChildren().add(volverMenu);

    }


}
