/*Ejercicio #5
 * Marinés García - 23391
 * CLASSE HIJO
 */

public class Pasador extends Jugador {
    
    private int pases;
    private int fintas; 

    public Pasador(String nombre, String pais, int errores, int aces, int servicio, int pases, int fintas){
        super(nombre, pais, errores, aces, servicio);
        this.pases = pases;
        this.fintas = fintas;
    }

    public int getPases(){
        return this.pases;
    }

    public int getFintas(){
        return this.fintas;
    }

    public void setPases(int pases){
        this.pases = pases;
    }

    public void setFintas(int fintas){
        this.fintas = fintas;
    }

    public double getMvpLibero(){
        return (((pases + fintas - errores) * 100 / (pases + fintas + errores)) + aces * 100 / servicio); 
    }
}
