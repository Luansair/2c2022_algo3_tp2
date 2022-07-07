package edu.fiuba.algo3.modelo.codigo;

import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArchivoPuntuacion {
    public ArchivoPuntuacion() {

    }
    public ArrayList<Pair<String, Integer>> leerArchivo(String csvFile) throws Exception {
        ArrayList<Pair<String, Integer>> tuplas = new ArrayList<>();

        BufferedReader br = null;
        String line = "";

        String cvsSplitBy = ",";

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(cvsSplitBy);
            //Imprime datos.
            tuplas.add(new Pair<String, Integer>(datos[0], Integer.parseInt(datos[1])));

        }

        for(Pair<String, Integer> tupla:tuplas) {
            System.out.println(tupla.getKey() + " " + tupla.getValue());
        }

        return tuplas;
    }

    public void escribirArchivo(String csvFile, ArrayList<Jugador> jugadores) throws IOException {
        FileWriter writer = new FileWriter(csvFile, true);
        StringBuilder sb = new StringBuilder();

        for(Jugador jugador:jugadores) {
            writer.append(jugador.getNombre());
            writer.append(',');
            int puntuacion = jugador.cantidadDeMovimientos();
            writer.append(String.valueOf(puntuacion));
            writer.append('\n');
        }

        writer.close();
    }
}
