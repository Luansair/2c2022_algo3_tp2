package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class ContenedorMeta extends VBox {

    public ContenedorMeta(Juego juego) {
        this.getStylesheets().add("border-vox");
        this.setAlignment(Pos.TOP_CENTER);

        Label label = new Label("El jugadpr ganador es...");
        label.getStyleClass().add("texto-predeterminado");

        this.getChildren().addAll(label);
    }
}
