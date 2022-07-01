package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.BotonAutoEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonCuatroPorCuatroEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonMotoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorJugador extends BorderPane {
    private Stage stage;
    private Juego juego;
    private MenuBar menuBar;

    public ContenedorJugador(Stage stage, Juego juego ) {
        this.stage = stage;
        this.juego = juego;
        this.getStyleClass().add("border-vox");
        this.setMenu();
        this.setCentro();
    }

    private void setMenu() {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {

        VBox pantallaPrincipal = new VBox();

        //INGRESAR NOMBRE
        VBox pantallaNombre = new VBox();

        Label etiquetaNombre = new Label("Jugador:");
        etiquetaNombre.getStyleClass().add("texto-predeterminado");
        TextField textoNombre = new TextField();
        textoNombre.setPromptText("Ingresar nombre del jugador:");

        pantallaNombre.getChildren().addAll(etiquetaNombre,textoNombre);


        //ELEGIR VEHICULO
        GridPane pantallaVehiculo = new GridPane();

        Button botonAuto = new Button("Auto");
        botonAuto.getStyleClass().add("boton-vehiculo");

        Button botonMoto = new Button("Moto");
        botonMoto.getStyleClass().add("boton-vehiculo");

        Button botonCuatroPorCuatro = new Button("4x4");
        botonCuatroPorCuatro.getStyleClass().add("boton-vehiculo");

        pantallaVehiculo.add(botonMoto,0,0);
        pantallaVehiculo.add(botonAuto,2,0);
        pantallaVehiculo.add(botonCuatroPorCuatro,1,1);

        pantallaVehiculo.setAlignment(Pos.CENTER);
        pantallaVehiculo.setVgap(100);
        pantallaVehiculo.setHgap(100);


        BotonAutoEventHandler botonAutoEventHandler = new BotonAutoEventHandler(juego);
        botonAuto.setOnAction(botonAutoEventHandler);

        BotonMotoEventHandler botonMotoEventHandler = new BotonMotoEventHandler(juego);
        botonMoto.setOnAction(botonMotoEventHandler);

        BotonCuatroPorCuatroEventHandler botonCuatroPorCuatroEventHandler = new BotonCuatroPorCuatroEventHandler(juego);
        botonCuatroPorCuatro.setOnAction(botonCuatroPorCuatroEventHandler);


        pantallaPrincipal.getChildren().addAll(pantallaNombre, pantallaVehiculo);
        pantallaPrincipal.setPadding(new Insets(70,100,100,100));
        pantallaPrincipal.setSpacing(90);
        this.setCenter(pantallaPrincipal);


    }

}

