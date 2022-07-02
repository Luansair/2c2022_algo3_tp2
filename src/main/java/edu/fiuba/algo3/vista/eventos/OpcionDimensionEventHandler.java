package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorJugador;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class OpcionDimensionEventHandler implements EventHandler<ActionEvent> {

    private ComboBox<Integer> comboBoxIzquierda;
    private ComboBox<Integer> comboBoxDerecha;
    private Juego juego;
    private Stage stage;

    public OpcionDimensionEventHandler(ComboBox<Integer> comboBoxIzquierda, ComboBox<Integer> comboBoxDerecha, Juego juego, Stage stage) {
        this.comboBoxIzquierda = comboBoxIzquierda;
        this.comboBoxDerecha = comboBoxDerecha;
        this.juego = juego;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (comboBoxDerecha.getValue() != null & comboBoxIzquierda.getValue() != null) {

            juego.crearMapa(/*comboBoxIzquierda.getValue(), comboBoxDerecha.getValue()*/ );
            comboBoxIzquierda.setEditable(false);
            comboBoxDerecha.setEditable(false);
            ContenedorJugador contenedorJugador = new ContenedorJugador(stage, juego);
            Scene escenaJugador = new Scene(contenedorJugador,1100,700);
            escenaJugador.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
            stage.setScene(escenaJugador);

        }
        else {
            Alert alertInfo = new Alert(Alert.AlertType.ERROR);
            alertInfo.setTitle("Error!");
            alertInfo.setContentText("Ingresar los dos parametros de la dimension");
            alertInfo.showAndWait();
        }
    }
}
