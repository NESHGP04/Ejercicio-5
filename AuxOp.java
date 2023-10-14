/*Ejercicio #5
 * Marinés García - 23391
 * CLASSE HIJO
 */

public class AuxOp extends Jugador{

    private int ataques;
    private int bloqueos;
    private int failBlock; 

    public AuxOp(String nombre, String pais, int errores, int aces, int servicio, int ataques, int bloqueos, int failBlock){
        super(nombre, pais, errores, aces, servicio);
        this.ataques = ataques;
        this.bloqueos = bloqueos;
        this.failBlock = failBlock;
    }

    public int getAtaques(){
        return this.ataques;
    }

    public int getBloqueos(){
        return this.bloqueos;
    }

    public int getFailBlock(){
        return this.failBlock;
    }

    public void setAtaques(int ataques){
        this.ataques = ataques;
    }

    public void setBloqueos(int bloqueos){
        this.bloqueos = bloqueos;
    }

    public void setFailBlock(int failBlock){
        this.failBlock = failBlock;
    }

    public double getMvpLibero(){
        return ((ataques + bloqueos - failBlock - errores) * 100 / bloqueos + failBlock + errores) + aces * 100 / servicio; 
    }
}
