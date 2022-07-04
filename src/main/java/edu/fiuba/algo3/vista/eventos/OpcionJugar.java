package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import edu.fiuba.algo3.vista.ContenedorMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionJugar implements EventHandler<ActionEvent> {
    private Stage stage;
    private Juego juego;

    public OpcionJugar(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorMapa contenedorMapa = new ContenedorMapa(stage, juego);

        Scene escenaMapa = new Scene(contenedorMapa,2200,1400);
        escenaMapa.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaMapa);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}