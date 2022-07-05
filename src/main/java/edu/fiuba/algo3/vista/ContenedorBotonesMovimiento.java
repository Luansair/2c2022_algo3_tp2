package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverAbajo;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverArriba;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverDerecha;
import edu.fiuba.algo3.vista.eventos.movimientos.BotonMoverIzquierda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorBotonesMovimiento extends VBox {
    private Stage stage;
    private Juego juego;
    private Button botonArriba;
    private Button botonAbajo;
    private Button botonDerecha;
    private Button botonIzquierda;


    public ContenedorBotonesMovimiento(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
        this.getStyleClass().add("fondo-mapa");
        this.setPadding(new Insets(10,10,10,10));
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(150);

        VBox pantallaInformacionJugador = new VBox();
        Label labelJugadorTurno = new Label("Jugador de turno:");
        labelJugadorTurno.getStyleClass().add("texto-predeterminado");

        Label labelNombreJugador = new Label(juego.getJugadorTurno());
        labelNombreJugador.getStyleClass().add("texto-predeterminado");

        Label labelPuntuacion = new Label("Puntaje:");
        labelPuntuacion.getStyleClass().add("texto-predeterminado");

        Label labelpuntuacionActual = new Label(String.valueOf(juego.puntaje()));
        labelpuntuacionActual.getStyleClass().add("texto-predeterminado");

        pantallaInformacionJugador.setAlignment(Pos.TOP_CENTER);
        pantallaInformacionJugador.setSpacing(20);
        pantallaInformacionJugador.getChildren().addAll(labelJugadorTurno, labelNombreJugador, labelPuntuacion, labelpuntuacionActual);


        GridPane pantallaBotones = new GridPane();
        pantallaBotones.getStyleClass().addAll("panel-semitransparente");
        botonArriba = new Button("");
        botonAbajo = new Button("");
        botonDerecha = new Button( "");
        botonIzquierda = new Button("");

        botonArriba.getStyleClass().add("boton-movimiento");
        botonAbajo.getStyleClass().add("boton-movimiento");
        botonDerecha.getStyleClass().add("boton-movimiento");
        botonIzquierda.getStyleClass().add("boton-movimiento");

        pantallaBotones.add(botonArriba,1,0);
        pantallaBotones.add(botonDerecha,2,1);
        pantallaBotones.add(botonIzquierda,0,1);
        pantallaBotones.add(botonAbajo,1,2);

        BotonMoverArriba botonMoverArriba = new BotonMoverArriba(juego, stage);
        botonArriba.setOnAction(botonMoverArriba);

        BotonMoverAbajo botonMoverAbajo = new BotonMoverAbajo(juego, stage);
        botonAbajo.setOnAction(botonMoverAbajo);

        BotonMoverIzquierda botonMoverIzquierda = new BotonMoverIzquierda(juego,stage);
        botonIzquierda.setOnAction(botonMoverIzquierda);

        BotonMoverDerecha botonMoverDerecha = new BotonMoverDerecha(juego,stage);
        botonDerecha.setOnAction(botonMoverDerecha);

        this.getChildren().addAll(pantallaInformacionJugador, pantallaBotones);
    }

}
