package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonAutoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Button botonMoto;
    private Button botonCuatroPorCuatro;

    public BotonAutoEventHandler(Juego juego, Button botonMoto, Button botonCuatroPorCuatro)  {
        this.juego = juego;
        this.botonMoto = botonMoto;
        this.botonCuatroPorCuatro = botonCuatroPorCuatro;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignarAuto();
        botonMoto.setDisable(true);
        botonCuatroPorCuatro.setDisable(true);
        System.out.println("Auto Asignado");
    }
}
