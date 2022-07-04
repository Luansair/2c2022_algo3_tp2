package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorAgregarJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionAgregarJugador implements EventHandler<ActionEvent> {
    private Stage stage;
    private Juego juego;

    public OpcionAgregarJugador(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.agregarJugador("Jugador " + juego.getCantidadJugadores());

        ContenedorAgregarJugador contenedorJugador = new ContenedorAgregarJugador(stage, juego);
        Scene escenaJugador = new Scene(contenedorJugador,1100,700);
        escenaJugador.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaJugador);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}