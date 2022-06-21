package edu.fiuba.algo3.modelo.codigo;

import edu.fiuba.algo3.modelo.codigo.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.codigo.vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.codigo.sorpresas.Sorpresa;

import java.util.ArrayList;

public class Cuadra {
    private Esquina esquinaUno;
    private Esquina esquinaDos;
    private ArrayList<Obstaculo> obstaculos;
    private ArrayList<Sorpresa> sorpresas;

    public Cuadra(Esquina esquinaUno, Esquina esquinaDos) {
        this.esquinaUno = esquinaUno;
        this.esquinaDos = esquinaDos;
        this.obstaculos = new ArrayList<>();
        this.sorpresas = new ArrayList<>();
    }

    public boolean mismaCuadra(Esquina esquinaInicial, Esquina esquinaFinal) { //siempre devuelve true porque mismaEsquina siempre da true
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

    public void agregarSorpresa(Sorpresa sorpresa) {
        this.sorpresas.add(sorpresa);
    }

    public void aplicarSorpresas(Jugador unJugador) {
        for (Sorpresa sorpresa : sorpresas) {
            sorpresa.activar(unJugador);
        }
    }
}

