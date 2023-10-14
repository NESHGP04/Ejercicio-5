/*Ejercicio #5
 * Marinés García - 23391
 * CLASSE HIJO
 */

public class Libero extends Jugador{
    
    private int recibos;

    public Libero(String nombre, String pais, int errores, int aces, int servicio, int recibos){
        super(nombre, pais, errores, aces, servicio);
        this.recibos = recibos;
    }

    public int getRecibos(){
        return this.recibos;
    }

    public double getMvpLibero(){
        return (((recibos - errores) * 100 / (recibos + errores)) + aces * 100 / servicio); 
    }

    public String toString(){
        return nombre + "->  " + this.recibos ;
    }

}
