package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCuatroPorCuatroEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;

    public BotonCuatroPorCuatroEventHandler(Juego juego) {
        this.juego = juego;
    }

        @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignaCuatroPorCuatro();
    }
}
