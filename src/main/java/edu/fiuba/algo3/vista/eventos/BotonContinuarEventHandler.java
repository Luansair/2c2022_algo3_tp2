package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotonContinuarEventHandler implements EventHandler<ActionEvent>{
    private BorderPane siguienteContenedor;
    private Stage stage;

    public BotonContinuarEventHandler(BorderPane siguienteContenedor, Stage stage) {
        this.siguienteContenedor = siguienteContenedor;
        this.stage = stage;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Scene escenaProxima = new Scene(siguienteContenedor, 1000, 900);
        stage.setScene(escenaProxima);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);

    }
}
