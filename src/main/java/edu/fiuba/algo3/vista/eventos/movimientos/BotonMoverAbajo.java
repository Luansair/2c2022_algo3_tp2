package edu.fiuba.algo3.vista.eventos.movimientos;


import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionInferior;
import edu.fiuba.algo3.modelo.codigo.Direccion.DireccionSuperior;
import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.vista.ContenedorMeta;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
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
        juego.moverHaciaAbajo();
        juego.imprimirEstado();
        if (juego.juegoTerminado())  {
            ContenedorMeta contenedorMeta = new ContenedorMeta(juego);
            Scene escenaMeta = new Scene(contenedorMeta,1100,700);
            escenaMeta.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
            stage.setScene(escenaMeta);
        } else {
            ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal( stage, juego);
            Scene escenaPrincipal = new Scene(contenedorPrincipal,1235,957);
            escenaPrincipal.getStylesheets().add(getClass().getResource("/escenas/escenaPrincipal.css").toExternalForm());
            stage.setScene(escenaPrincipal);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(false);
        }
    }
}
