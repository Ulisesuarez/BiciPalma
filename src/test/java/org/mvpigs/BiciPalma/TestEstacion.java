package org.mvpigs.BiciPalma;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestEstacion {
    /* caso TEST visualizar estado de la estacion
     * muestra id, direccion, anclaje
     * */
    private Estacion estacion1;
    @Before
    public void setUp()  {
        estacion1=new Estacion(1,"Palma",10);

    }

    @Test
    public void testEstacion(){
        estacion1.consultarEstacion();

    }

    @Test
    public void testAnclajesLibres(){

        Assert.assertEquals(10,estacion1.anclajesLibres());
    }

    @Test
    public void testGenerarAnclajes(){
        System.out.println(estacion1.generarAnclaje());
        System.out.println(estacion1.generarAnclaje());
        System.out.println(estacion1.generarAnclaje());
        System.out.println(estacion1.generarAnclaje());
    }

    @Test
    public void testEstacionVacia(){
    TarjetaUsuario tarjetaUsuario=new TarjetaUsuario("soyunusuario",true);
        estacion1.retirarBicicleta(tarjetaUsuario);

    }
    @Test
    public void testTarjetaDesactivada() {
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("soyunusuario", false);
        estacion1.retirarBicicleta(tarjetaUsuario);
    }
    }