package edu.fiuba.algo3.vista.eventos.movimientos;

import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMoverIzquierda implements EventHandler<ActionEvent> {

    private Juego juego;
    private Stage stage;

    public BotonMoverIzquierda(Juego juego, Stage stage)  {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        DireccionIzquierda direccionIzquierda = new DireccionIzquierda(juego.obtenerMapa());
        juego.moverVehiculo(direccionIzquierda);
        juego.imprimirEstado();
        juego.siguienteTurno();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,  juego);

        Scene escenaPrincipal = new Scene(contenedorPrincipal,1235,957);
        escenaPrincipal.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaPrincipal);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}
