package edu.fiuba.algo3.vista.eventos.movimientos;


import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionInferior;
import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionSuperior;
import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMoverAbajo implements EventHandler<ActionEvent> {

    private Juego juego;
    private Stage stage;

    public BotonMoverAbajo(Juego juego, Stage stage)  {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        DireccionSuperior direccionSuperior = new DireccionSuperior(juego.obtenerMapa());
        juego.moverVehiculo(direccionSuperior);
        juego.imprimirEstado();
        juego.siguienteTurno();

        ContenedorMapa contenedorMapa = new ContenedorMapa(stage, juego);

        Scene escenaMapa = new Scene(contenedorMapa,2200,1400);
        escenaMapa.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
        stage.setScene(escenaMapa);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}
