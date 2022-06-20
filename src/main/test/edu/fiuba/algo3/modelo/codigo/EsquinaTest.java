package edu.fiuba.algo3.modelo.codigo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EsquinaTest {
    @Test
    public void test01CrearEsquinaConCoordenadasPositivasNoDeberiaDarError(){
        new Esquina(1,1);
        new Esquina(3,15);
    }

    @Test
    public void test02CrearEsquinaConCoordenadasNegativasNoDeberiaDarError(){
        new Esquina(-1,-1);
        new Esquina(-13,-4);
    }

    @Test
    public void test03CrearEsquinaConCoordenadasMixtasNoDeberiaDarError(){
        new Esquina(-1,1);
        new Esquina(4,-15);
    }

    @Test
    public void test04CrearEsquinaConCoordenadasNulasNoDeberiaDarError(){
        new Esquina(0,0);
    }

    @Test
    public void test05UnaEsquinaDeberiaSerIgualASiMisma(){
        Esquina esquina = new Esquina(13, -15);

        assertTrue(esquina.mismaEsquina(esquina));
    }

    @Test
    public void test06UnaEsquinaDeberiaSerIgualAOtraDeIgualCoordenadas(){
        Esquina esquina1 = new Esquina(4,5);
        Esquina esquina2 = new Esquina(4,5);

        assertTrue(esquina1.mismaEsquina(esquina2));
    }

    @Test
    public void test07UnaEsquinaDeberiaSerDistintaAOtraDeDistintasCoordenadas(){
        Esquina esquina1 = new Esquina(4,5);
        Esquina esquina2 = new Esquina(-2,7);

        assertFalse(esquina1.mismaEsquina(esquina2));
    }

    @Test
    public void test08ActualizarUnaEsquinaNoDeberiaDarError(){
        Esquina esquina = new Esquina(0,0);
        esquina.actualizar(1,3);
        esquina.actualizar(-10, -5);
        esquina.actualizar(4,-7);
        esquina.actualizar(0,0);
    }

    @Test
    public void test09UnaEsquinaDeberiaSerIgualASiMismaAPesarDeActualizarla(){
        Esquina esquina = new Esquina(0,0);
        esquina.actualizar(15,-9);

        assertTrue(esquina.mismaEsquina(esquina));
    }

    @Test
    public void test10UnaEsquinaDeberiaSerDiferenteAOtraSiLaActualizoAPesarDeSerIgualesInicialmente(){
        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(0,0);

        esquina1.actualizar(1,0);

        assertFalse(esquina1.mismaEsquina(esquina2)) ;
    }

    @Test
    public void test11UnaEsquinaDeberiaSerIgualAOtraSiLaActualizoConValoresNulosAPesarDeSerIgualesInicialmente(){
        Esquina esquina1 = new Esquina(1,1);
        Esquina esquina2 = new Esquina(1,1);

        esquina1.actualizar(0,0);

        assertTrue(esquina1.mismaEsquina(esquina2));
    }

    @Test
    public void test12UnaEsquinaDeCoordUnoCeroDeberiaSerIgualAOtraDeCoordNulasSiActualizoLaPrimeraAMenosUnoCero(){
        Esquina esquina1 = new Esquina(1,0);
        Esquina esquina2 = new Esquina(0,0);

        esquina1.actualizar(-1,0);

        assertTrue(esquina1.mismaEsquina(esquina2));
    }

    @Test
    public void test13ActualizoUnaEsquinaVariasVecesHastaQueResultaIgualAOtra(){
        Esquina esquina1 = new Esquina(15,13);
        Esquina esquina2 = new Esquina(-15,13);

        esquina1.actualizar(-15,-13);
        esquina1.actualizar(-7,6);
        esquina1.actualizar(-8,7);

        assertTrue(esquina1.mismaEsquina(esquina2));
    }

    @Test
    public void test14ActualizoDosEsquinasAUnMismoPuntoYDeberianSerIguales(){
        Esquina esquina1 = new Esquina(0,0);
        Esquina esquina2 = new Esquina(4,0);

        esquina1.actualizar(2,2);
        esquina2.actualizar(-2,2);

        assertTrue(esquina1.mismaEsquina(esquina2));
    }

    @Test
    public void test15SiUnaEsquinaEsIgualAOtraLaSegundaDeberiaSerIgualALaPrimera(){
        Esquina esquina1 = new Esquina(2,1);
        Esquina esquina2 = new Esquina(2,1);

        assertTrue(esquina1.mismaEsquina(esquina2) && esquina2.mismaEsquina(esquina1));
    }

    @Test
    public void test16SiUnaEsquinaEsDistintaAOtraLaSegundaDeberiaSerDistintaALaPrimera(){
        Esquina esquina1 = new Esquina(-1,3);
        Esquina esquina2 = new Esquina(12,-7);

        assertFalse(esquina1.mismaEsquina(esquina2) || esquina2.mismaEsquina(esquina1));
    }
}
