package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.awt.*;

public class BotonSubmitEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Juego juego;
    private TextField text;

    public BotonSubmitEventHandler(Stage stage, Juego juego, TextField nombre) {
        this.stage = stage;
        this.juego = juego;
        this.text = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignarNombre(text.getText());

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, juego);

        Scene escenaJugadores = new Scene(contenedorJugadores,1100,700);
        escenaJugadores.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaJugadores);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}