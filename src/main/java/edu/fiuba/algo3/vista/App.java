package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.security.AlgorithmConstraints;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Trabajo practico 2 - GPS Challenge");

        Juego juego = crearModelo();

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, juego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1000, 900);

        stage.setScene(escenaBienvenidos);
        stage.show();
    }

    private Juego crearModelo() {
        Juego juego = new Juego();
        return juego;
    }

    public static void main(String[] args) {
        launch(args);
    }

}