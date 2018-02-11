package org.mvpigs.BiciPalma;



import java.lang.reflect.Array;
import java.util.concurrent.ThreadLocalRandom;

public class Estacion {

    private int id =0;
    private String direccion = null;
    private int numeroAnclajes = 0;

    private  Bicicleta[] anclajes;

    public Estacion(int id, String direccion, int numeroAnclajes){
        this.id=id;
        this.direccion=direccion;
        this.numeroAnclajes = numeroAnclajes;
        this.anclajes = new Bicicleta[numeroAnclajes];


    }


    public void consultarEstacion(){
        System.out.println("id:\t"+String.valueOf(this.id));
        System.out.println("dirección:\t"+String.valueOf(this.direccion));
        System.out.println("numero de Anclajes:\t"+String.valueOf(this.numeroAnclajes));

        //muestra un mensaje con id, direccion y numeroAnclajes
    }

    public int anclajesLibres() {
        int anclajesLibres=0;
        for (Bicicleta anclaje : this.anclajes){

            if (anclaje==null){
                anclajesLibres++;

            }
        }
        //devuelve la cantidad de anclajes libres
    return anclajesLibres;}

    public void consultarAnclajes(){
        int posicion=0;
        for (Bicicleta anclaje : this.anclajes) {
            if (anclaje != null) {
                System.out.println("Anclaje " + String.valueOf(posicion+1) + " " + String.valueOf(anclaje.getId()));
                posicion++;
            } else {
                System.out.println("Anclaje " + String.valueOf(posicion+1) + " libre");
                posicion++;

            }
        }
        //recorre el array anclajes y muestra el id de la Bicicleta anclada o si está libre
    }

    public void anclarBicicleta( Bicicleta bicicleta){
        int posicion=0;
        int numeroAnclaje=-1;
        boolean pendiente=true;

        for (Bicicleta anclaje : this.anclajes){
            if(pendiente && anclaje==null  ){

                this.anclajes[posicion]=bicicleta;
                pendiente=false;
                numeroAnclaje=posicion+1;
            }
        posicion++;
        }
        this.mostrarAnclaje(bicicleta,numeroAnclaje);

        // inserta el objeto Bicicletacleta en el primer registro libre del array anclajes y llama a mostrarAnclaje()
    }

    public void mostrarAnclaje(Bicicleta bicicleta, int numeroAnclaje){
        System.out.println("bicicleta: "+String.valueOf(bicicleta.getId())+"  anclada en el anclaje: "+String.valueOf(numeroAnclaje));
        // muestra un mensaje con el id de la Bicicletacleta anclada y en qué anclaje se ha anclado
    }

    public boolean leerTarjetaUsuario( TarjetaUsuario tarjetaUsuario){

    return tarjetaUsuario.isActivada();}

   public void retirarBicicleta( TarjetaUsuario tarjetaUsuario){
        if (tarjetaUsuario.isActivada()){
            int anclajeBici=this.generarAnclaje();
            if (anclajeBici>=0){
                mostrarBicicleta(this.anclajes[anclajeBici],anclajeBici);
                this.anclajes[anclajeBici]=null;


            }else {
                System.out.println("Senitmos no disponer de bicicletas en estos momentos,la estación más cercana está en  "+String.valueOf("this.getDireccionSiguienteEstacion"));
            }
        }
        else{
            System.out.println("Acude a una oficina para activar tu tarjeta");
        }
        //si la tarjeta de usuario está activada retira una Bicicleta del anclaje y muestra su información en pantalla llamando a mostrarBicicletacleta(Bicicletacleta, numeroAnclaje)
    //para simular que un usuario/a del servicio ancla una Bicicleta, debes generar una posición al azar entre los anclajes y eliminar esa Bicicleta con el método generarAnclaje()
    //para eliminar una Bicicleta del array debes poner esa posicion del array a null.*/
    }

    public void mostrarBicicleta(Bicicleta bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta retirada: "+String.valueOf(bicicleta.getId())+" del anclaje: "+String.valueOf(numeroAnclaje+1));
        //muestra un mensaje con el id de la Bicicleta y el número de anclaje donde estaba.
        //generarAnclaje() devuelve una posición al azar entre el número de anclajes. Utiliza ThreadLocalRandom.current()
    }

    public int generarAnclaje() {
        if (this.anclajesLibres() != this.anclajes.length) {
            int posicion = ThreadLocalRandom.current().nextInt(0, this.numeroAnclajes  );
            while (this.anclajes[posicion] == null) {
                posicion = ThreadLocalRandom.current().nextInt(0, this.numeroAnclajes );
            }

            return posicion;
        } else {

            return -1;
        }
    }
}
