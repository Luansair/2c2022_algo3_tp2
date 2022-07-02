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

        //ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, juego);
        //Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1100,  700);
        //escenaBienvenidos.getStylesheets().add(getClass().getResource("/escenas/escenaBienvenidos.css").toExternalForm());
        //stage.setScene(escenaBienvenidos);


        ContenedorMapa contenedorMapa = new ContenedorMapa(stage, juego);
        Scene escenaMapa = new Scene(contenedorMapa, 1100, 700);
        escenaMapa.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaMapa);

        stage.show();
    }

    private Juego crearModelo() {
        return new Juego();
    }

    public static void main(String[] args) {
        launch(args);
    }

}