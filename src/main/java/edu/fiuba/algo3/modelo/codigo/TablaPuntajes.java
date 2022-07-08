package edu.fiuba.algo3.modelo.codigo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class TablaPuntajes {
    ArrayList<Pair<String, Integer>> puntajes;

    public void cargarPuntajes(String csvFile) throws Exception {
        puntajes = (new ArchivoPuntuacion()).leerArchivo(csvFile);
    }

    public void ordenarPuntajes(){
        Pair<String,Integer> [] vpuntajes = new Pair[puntajes.size()];
        int i = 0;
        for (Pair<String,Integer> puntaje:puntajes) {
            vpuntajes[i] = puntaje;
            i++;
        }

        for(i=0; i < vpuntajes.length; i++) {
            for (int j = 0; j < vpuntajes.length; j++) {
                int a = vpuntajes[i].getValue();
                int b = vpuntajes[j].getValue();
                if (a < b) {
                    Pair<String, Integer> aux = vpuntajes[i];
                    vpuntajes[i] = vpuntajes[j];
                    vpuntajes[j] = aux;
                }
            }
        }
        puntajes = new ArrayList<>(Arrays.asList(vpuntajes));
    }

    public void imprimir(){
        System.out.println("\nTabla Puntajes");
        for (Pair<String,Integer> puntaje:puntajes) {

            System.out.println(puntaje.getKey() + " " + puntaje.getValue());
        }
    }
}
