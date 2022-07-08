package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonCuatroPorCuatroEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Button botonAuto;
    private Button botonMoto;

    private Button botonDeshabilitado;

    public BotonCuatroPorCuatroEventHandler(Juego juego, Button botonAuto, Button botonMoto, Button botonDesabilitado) {
        this.juego = juego;
        this.botonAuto = botonAuto;
        this.botonMoto = botonMoto;
        this.botonDeshabilitado = botonDesabilitado;
    }


        @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignaCuatroPorCuatro();
        botonMoto.setDisable(true);
        botonAuto.setDisable(true);
        botonDeshabilitado.setDisable(false);
    }
}
