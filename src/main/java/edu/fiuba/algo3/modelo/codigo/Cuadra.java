package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;

import java.util.ArrayList;

public class Cuadra {
    private Esquina esquinaUno;
    private Esquina esquinaDos;
    private ArrayList<Obstaculo> obstaculos;

    public Cuadra(Esquina esquinaUno, Esquina esquinaDos) {
        this.esquinaUno = esquinaUno;
        this.esquinaDos = esquinaDos;
        this.obstaculos = new ArrayList<>();
    }

    public boolean mismaCuadra(Esquina esquinaInicial, Esquina esquinaFinal) {
        return (esquinaUno.mismaEsquina(esquinaInicial) || esquinaUno.mismaEsquina(esquinaFinal))
                && (esquinaDos.mismaEsquina(esquinaInicial) || esquinaDos.mismaEsquina(esquinaFinal));
    }

    public void agregarObstaculo(Obstaculo obstaculo) {
        this.obstaculos.add(obstaculo);
    }

    public void aplicarObstaculos(Vehiculo unVehiculo) {
        for (Obstaculo obstaculo : obstaculos) {
            obstaculo.activar(unVehiculo);
        }
    }
}

