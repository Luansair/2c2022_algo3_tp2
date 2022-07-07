package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.ArchivoPuntuacion;
import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.modelo.codigo.Jugador;
import edu.fiuba.algo3.vista.eventos.BotonVolverMenuEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;


public class ContenedorPuntuaciones extends VBox {

    public ContenedorPuntuaciones(Juego juego, Stage stage) throws Exception {
        this.getStyleClass().add("border-vox");
        this.setAlignment(Pos.TOP_CENTER);

        Label label = new Label("Tabla de puntuaciones");
        label.getStyleClass().add("texto-predeterminado");
        this.getChildren().addAll(label);

        Label titulo = new Label("Jugador" + "         " + "Movimientos");
        titulo.getStyleClass().add("texto-predeterminado");
        this.getChildren().addAll(titulo);

        ArchivoPuntuacion archivo = new ArchivoPuntuacion();
        ArrayList<Pair<String, Integer>> puntuaciones = archivo.leerArchivo("src/main/resources/archivo.csv");

        for(Pair<String, Integer> tupla: puntuaciones) {
            Label etiqueta = new Label(tupla.getValue() + "         " + tupla.getKey());
            etiqueta.getStyleClass().add("texto-predeterminado");
            this.getChildren().addAll(etiqueta);
        }

        Button volverMenu = new Button("Volver al menú principal");
        volverMenu.getStyleClass().add("boton-comienzo");

        BotonVolverMenuEventHandler evento = new BotonVolverMenuEventHandler(stage, juego);
        volverMenu.setOnAction(evento);

        this.getChildren().add(volverMenu);

    }
}