package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class BotonAutoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Button botonMoto;
    private Button botonCuatroPorCuatro;

    private Button botonDeshabilitado;

    public BotonAutoEventHandler(Juego juego, Button botonMoto, Button botonCuatroPorCuatro, Button botonDesabilitado)  {
        this.juego = juego;
        this.botonMoto = botonMoto;
        this.botonCuatroPorCuatro = botonCuatroPorCuatro;
        this.botonDeshabilitado = botonDesabilitado;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.asignarAuto();
        botonMoto.setDisable(true);
        botonCuatroPorCuatro.setDisable(true);
        botonDeshabilitado.setDisable(false);
    }
}
