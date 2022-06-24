package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonAutoEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonCuatroPorCuatroEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonMotoEventHandler;
import edu.fiuba.algo3.vista.eventos.TextoNombreEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class IngresarJugadorVista {

    private Juego juego;
    private VBox jugadorVista;

    public IngresarJugadorVista(VBox jugadorVista, Juego juego) {
        this.jugadorVista = jugadorVista;
        this.juego = juego;

        jugadorVista.setAlignment(Pos.CENTER);

        //INGRESAR NOMBRE DELC JUGADOR
        VBox pantallaNombre = new VBox();
        Label label = new Label("Jugador:");
        TextField  textoNombre = new TextField();
        textoNombre.setPromptText("Ingresar nombre del jugador");

        TextoNombreEventHandler textoNombreEventHandler = new TextoNombreEventHandler(juego, textoNombre);
        textoNombre.setOnAction(textoNombreEventHandler);

        pantallaNombre.getChildren().addAll(label,textoNombre);

        //ELEGIR VEHICULOS
        GridPane pantallaVehiculos = new GridPane();

        Button botonAuto = new Button("Auto");
        Button botonMoto = new Button("Moto");
        Button botonCuatroPorCuatro = new Button("4x4");

        pantallaVehiculos.add(botonMoto,0,0);
        pantallaVehiculos.add(botonAuto,2,0);
        pantallaVehiculos.add(botonCuatroPorCuatro,1,1);

        pantallaVehiculos.setAlignment(Pos.CENTER);

        BotonAutoEventHandler botonAutoEventHandler = new BotonAutoEventHandler(juego);
        botonAuto.setOnAction(botonAutoEventHandler);

        BotonMotoEventHandler botonMotoEventHandler = new BotonMotoEventHandler(juego);
        botonMoto.setOnAction(botonMotoEventHandler);

        BotonCuatroPorCuatroEventHandler botonCuatroPorCuatroEventHandler = new BotonCuatroPorCuatroEventHandler(juego);
        botonCuatroPorCuatro.setOnAction(botonCuatroPorCuatroEventHandler);

        jugadorVista.setSpacing(30);
        jugadorVista.getChildren().addAll(pantallaNombre, pantallaVehiculos);
    }


}
