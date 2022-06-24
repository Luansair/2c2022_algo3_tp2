package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.util.Locale;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Acerca de...");
        alerta.setHeaderText("Trabajo practico 2 - GPS Challenge");
        String mensaje = "Algoritmos y programacion III";
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
