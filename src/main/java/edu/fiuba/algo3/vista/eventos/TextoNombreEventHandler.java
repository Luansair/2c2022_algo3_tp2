package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.codigo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class TextoNombreEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private TextField textoNombre;

    public TextoNombreEventHandler(Juego juego, TextField textoNombre)  {
        this.juego = juego;
        this.textoNombre = textoNombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
       juego.getNombreJugador(textoNombre.getText());
    }
}
