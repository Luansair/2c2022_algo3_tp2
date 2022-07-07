package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Pair;


public class ContenedorMeta extends VBox {

    public ContenedorMeta(Juego juego) {
        this.getStylesheets().add("border-vox");
        this.setAlignment(Pos.TOP_CENTER);

        Label label = new Label("Tabla de puntuaciones");
        label.getStyleClass().add("texto-predeterminado");
        this.getChildren().addAll(label);

        for(Pair<Jugador, Integer> tupla : juego.scores) {
            Label etiqueta = new Label(tupla.getKey().getNombre() + " " + tupla.getValue());
            etiqueta.getStyleClass().add("texto-predeterminado");
            this.getChildren().addAll(etiqueta);
        }


    }
}
