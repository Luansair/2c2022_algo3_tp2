package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class BotonMotoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;

    public BotonMotoEventHandler(Juego juego) {
        this.juego = juego;
    }
        @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignarMoto();
        System.out.println("Moto Asignada");
    }
}
