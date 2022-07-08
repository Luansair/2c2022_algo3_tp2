package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorRanking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonRankingEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Juego juego;
    private TextField textoNombre;
    private Label labelVacio;

    public BotonRankingEventHandler(Stage stage, Juego juego, TextField textoNombre, Label labelVacio) {
        this.stage = stage;
        this.juego = juego;
        this.textoNombre = textoNombre;
        this.labelVacio = labelVacio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (textoNombre.getText() == "")  {
            labelVacio.setText("Ingresar Nick del Jugador");
        } else {
            ContenedorRanking contenedorRanking = null;
            try {
                contenedorRanking = new ContenedorRanking(stage, juego, textoNombre.getText());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Scene escenaRanking = new Scene(contenedorRanking,1100,700);
            escenaRanking.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
            stage.setScene(escenaRanking);
        }
    }
}
