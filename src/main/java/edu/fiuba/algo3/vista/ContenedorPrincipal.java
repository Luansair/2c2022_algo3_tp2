package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    private Stage stage;
    private Juego juego;
    private BarraDeMenu menuBar;


    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;

        this.setMenu();
        this.setCentro();
    }

    private void setMenu() {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
        ContenedorNombreJugadores contenedorNombreJugadores = new ContenedorNombreJugadores(stage, juego);
        this.setCenter(contenedorNombreJugadores);
    }
}
