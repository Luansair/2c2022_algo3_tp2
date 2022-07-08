package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Juego juego;

    public BotonEntrarEventHandler(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, juego);
        Scene escenaJugadores = new Scene(contenedorJugadores,1100,700);
        escenaJugadores.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaJugadores);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}