package org.mvpigs.BiciPalma;

public class TarjetaUsuario {

    private boolean activada;
    private String id;


    public TarjetaUsuario(String Id, boolean activada) {
        this.id = Id;
        this.activada = activada;

    }

    public boolean isActivada() {
        return activada;
    }
}
    /*public String getId() {
        return id;
    }*/

