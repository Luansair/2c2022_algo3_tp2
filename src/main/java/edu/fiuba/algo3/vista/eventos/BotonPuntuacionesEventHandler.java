package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorPuntuaciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonPuntuacionesEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private Stage stage;

    public BotonPuntuacionesEventHandler(Juego juego, Stage stage)  {
        this.stage = stage;
        this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorPuntuaciones contenedorPuntuaciones = null;
        try {
            contenedorPuntuaciones = new ContenedorPuntuaciones(juego, stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Scene escenaPuntuaciones = new Scene(contenedorPuntuaciones,1100,700);
        escenaPuntuaciones.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaPuntuaciones);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}