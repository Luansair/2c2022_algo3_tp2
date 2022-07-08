package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class BotonMotoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Button botonAuto;
    private Button botonCuatroPorCuatro;

    private Button botonDeshabilitado;
    public BotonMotoEventHandler(Juego juego, Button botonAuto, Button botonCuatroPorCuatro, Button botonDeshabilitado) {
        this.juego = juego;
        this.botonAuto = botonAuto;
        this.botonCuatroPorCuatro = botonCuatroPorCuatro;
        this.botonDeshabilitado = botonDeshabilitado;

    }
        @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignarMoto();
        botonAuto.setDisable(true);
        botonCuatroPorCuatro.setDisable(true);
        botonDeshabilitado.setDisable(false);
    }
}
