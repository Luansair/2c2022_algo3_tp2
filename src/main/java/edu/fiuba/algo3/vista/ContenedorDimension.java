package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.codigo.Juego;
import edu.fiuba.algo3.vista.eventos.OpcionDimensionEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorDimension extends BorderPane {
    private Juego juego;
    private Stage stage;
    private BarraDeMenu menuBar;

    public ContenedorDimension(Stage stage, Juego juego)  {
        this.juego = juego;
        this.stage = stage;

        this.setMenu();
        this.setCentro();
    }

    private void setMenu() {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro()  {
        VBox pantallaDimension = new VBox();

        pantallaDimension.setAlignment(Pos.TOP_CENTER);
        pantallaDimension.setSpacing(70);
        pantallaDimension.setPadding(new Insets(50,50,50,50));
        Image imagen = new Image("file:imagenes/pantallaComienzo.png");
        BackgroundImage backgroundImage = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pantallaDimension.setBackground(new Background(backgroundImage));


        Label label = new Label("Ingresar la dimension del mapa");
        label.getStyleClass().add("texto-predeterminado");


        HBox pantallaOpciones = new HBox();
        pantallaOpciones.setAlignment(Pos.CENTER);
        pantallaOpciones.setPadding(new Insets(30,40,40,10));
        pantallaOpciones.setSpacing(60);
        ComboBox<Integer> opcionesDimensionIzquierda = new ComboBox<>();
        opcionesDimensionIzquierda.getItems().addAll(2,3,4,5,6,7);
        opcionesDimensionIzquierda.getStyleClass().add("opcion");

        ComboBox<Integer> opcionesDimensionDerecha = new ComboBox<>();
        opcionesDimensionDerecha.getItems().addAll(2,3,4,5,6,7);

        Label separador = new Label("X");
        separador.getStyleClass().add("texto-predeterminado");
        pantallaOpciones.getChildren().addAll(opcionesDimensionIzquierda, separador, opcionesDimensionDerecha);


        Button botonContinuar = new Button("Continuar");
        OpcionDimensionEventHandler opcionDimensionEventHandler = new OpcionDimensionEventHandler(opcionesDimensionIzquierda, opcionesDimensionDerecha, juego, stage);
        botonContinuar.setOnAction(opcionDimensionEventHandler);


        pantallaDimension.getChildren().addAll(label, pantallaOpciones,botonContinuar);
        this.setCenter(pantallaDimension);

    }
}
