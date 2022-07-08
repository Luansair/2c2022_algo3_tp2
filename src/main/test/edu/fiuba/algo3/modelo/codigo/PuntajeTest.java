package edu.fiuba.algo3.modelo.codigo;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PuntajeTest {
    @Test
    public void test01() throws Exception {
        TablaPuntajes tabla = new TablaPuntajes();

        tabla.cargarPuntajes("F:\\Documentos\\Estudio\\Universitario\\UBA\\2022 1er Cuatrimestre\\Algoritmos III\\algo3_tp2\\src\\main\\resources\\archivo.csv");
        tabla.ordenarPuntajes();
        tabla.imprimir();
    }
}
