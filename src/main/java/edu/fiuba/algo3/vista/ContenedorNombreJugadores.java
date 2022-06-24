package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorNombreJugadores extends HBox {

    private Stage stage;
    private Juego juego;

    public ContenedorNombreJugadores(Stage stage, Juego juego)  {

        this.setPadding(new Insets(25));
        this.setSpacing(10);

        VBox pantalla = new VBox();
        pantalla.setPrefSize(425, 570);
        IngresarJugadorVista IngresarJugadorVista = new IngresarJugadorVista(pantalla,juego);


        this.getChildren().addAll(pantalla);



    }

}
