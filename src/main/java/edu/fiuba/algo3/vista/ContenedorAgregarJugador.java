package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorAgregarJugador extends BorderPane {
    private Stage stage;
    private Juego juego;
    private MenuBar menuBar;

    public ContenedorAgregarJugador(Stage stage, Juego juego) {
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
        pantallaNombre.setPadding(new Insets(0,200,0,0));

        Label etiquetaNombre = new Label("Jugador:");
        etiquetaNombre.getStyleClass().add("texto-predeterminado");

        TextField textoNombre = new TextField();
        textoNombre.setPromptText("Ingresar nombre del jugador");
        textoNombre.getStyleClass().add("textfill-nombre");

        pantallaNombre.getChildren().addAll(etiquetaNombre,textoNombre);


        //ELEGIR VEHICULO
        GridPane pantallaVehiculo = new GridPane();
        pantallaVehiculo.getStyleClass().add("panel-semitransparente");
        pantallaVehiculo.setPadding(new Insets(0,120,0,120));
        pantallaVehiculo.setAlignment(Pos.CENTER);
        pantallaVehiculo.setVgap(30);
        pantallaVehiculo.setHgap(30);

        Button botonAuto = new Button("");
        botonAuto.getStyleClass().add("boton-auto");

        Button botonMoto = new Button("");
        botonMoto.getStyleClass().add("boton-moto");

        Button botonCuatroPorCuatro = new Button("");
        botonCuatroPorCuatro.getStyleClass().add("boton-cuatroPorCuatro");



        pantallaVehiculo.add(botonMoto,0,0);
        pantallaVehiculo.add(botonAuto,2,0);
        pantallaVehiculo.add(botonCuatroPorCuatro,1,1);



        BotonAutoEventHandler botonAutoEventHandler = new BotonAutoEventHandler(juego, botonMoto, botonCuatroPorCuatro);
        botonAuto.setOnAction(botonAutoEventHandler);

        BotonMotoEventHandler botonMotoEventHandler = new BotonMotoEventHandler(juego, botonAuto,botonCuatroPorCuatro);
        botonMoto.setOnAction(botonMotoEventHandler);

        BotonCuatroPorCuatroEventHandler botonCuatroPorCuatroEventHandler = new BotonCuatroPorCuatroEventHandler(juego, botonAuto, botonMoto);
        botonCuatroPorCuatro.setOnAction(botonCuatroPorCuatroEventHandler);


        HBox pantallaAgregar = new HBox();
        Button submit = new Button();
        submit.setText("Agregar");
        submit.getStyleClass().add("boton-predeterminado");

        Label labelVacio = new Label();
        labelVacio.getStyleClass().add("texto-preventivo");

        pantallaAgregar.setAlignment(Pos.TOP_RIGHT);
        pantallaAgregar.setPadding(new Insets(0,60,60,60));
        pantallaAgregar.setSpacing(60);
        pantallaAgregar.getChildren().addAll(labelVacio, submit);


        BotonSubmitEventHandler botonSubmitEventHandler = new BotonSubmitEventHandler(stage, juego, textoNombre, labelVacio);
        submit.setOnAction(botonSubmitEventHandler);

        pantallaPrincipal.getChildren().addAll(pantallaNombre, pantallaVehiculo, pantallaAgregar);
        pantallaPrincipal.setPadding(new Insets(70,100,100,70));
        pantallaPrincipal.setSpacing(65);

        this.setCenter(pantallaPrincipal);
    }




}

