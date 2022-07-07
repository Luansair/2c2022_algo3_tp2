package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorBienvenidos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverMenuEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Juego juego;

    public BotonVolverMenuEventHandler(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
        guardarScores();
        this.juego = new Juego();

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, juego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1100,  700);
        escenaBienvenidos.getStylesheets().add(getClass().getResource("/escenas/escenaBienvenidos.css").toExternalForm());
        stage.setScene(escenaBienvenidos);

        stage.show();
    }

    public void guardarScores() {

    }
}
