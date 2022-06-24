package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {
    private HBox contenedorHorizontal;
    private VBox contenedorPrincipal;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Mi primera ventana");
        StackPane layout = new StackPane();

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");
        botonEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Enviado");
            }
        });

        Button botonLimpiar = new Button();
        botonLimpiar.setText("Limpiar cuadro de texto");
        botonLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Limpiado");
            }
        });

        contenedorHorizontal = new HBox(botonEnviar, botonLimpiar);
        contenedorHorizontal.setSpacing(10);

        Label label = new Label();
        label.setText("TEXTO DE LA ETIQUETA");
        layout.getChildren().add(label);

        TextField texto = new TextField();
        texto.setPromptText("Ingrese texto");

        contenedorPrincipal = new VBox(texto, contenedorHorizontal, label);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20, 10, 20, 10));
        contenedorPrincipal.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));

        Scene scene = new Scene(contenedorPrincipal, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}