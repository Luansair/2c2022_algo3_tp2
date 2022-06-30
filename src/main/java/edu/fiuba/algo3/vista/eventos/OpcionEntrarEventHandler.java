package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorDimension;
import edu.fiuba.algo3.vista.ContenedorMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionEntrarEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Juego juego;

    public OpcionEntrarEventHandler(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorDimension contenedorDimension = new ContenedorDimension(stage, juego);
        Scene escenaDimension = new Scene(contenedorDimension,1100,700);
        escenaDimension.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaDimension);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);

    }
}
