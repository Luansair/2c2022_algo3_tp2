package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAutoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;

    public BotonAutoEventHandler(Juego juego)  {
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignarAuto();
        System.out.println("Auto Asignado");
    }
}
