package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OpcionJugar implements EventHandler<ActionEvent> {
    private Stage stage;
    private Juego juego;

    private Label label;

    public OpcionJugar(Stage stage, Juego juego, Label label) {
        this.stage = stage;
        this.juego = juego;
        this.label = label;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (juego.getCantidadJugadores() == 0) {
            label.setText("No se agrego ningun jugador");
            label.getStyleClass().add("texto-predeterminado");
        }
        else  {
            ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);

            Scene escenaPrincipal = new Scene(contenedorPrincipal,1235,957);
            escenaPrincipal.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
            stage.setScene(escenaPrincipal);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(false);
        }
    }
}