/*Ejercicio #5
 * Marinés García - 23391
 * CLASSE PADRE
 */

public class Jugador {
     //Declaración variables 
     protected String nombre;
     protected String pais;
     protected int errores;
     protected int aces;
     protected int servicio;
 
     public Jugador(String nombre, String pais, int errores, int aces, int servicio){
         this.nombre = nombre;
         this.pais = pais;
         this.errores = errores;
         this.aces = aces;
         this.servicio = servicio; 
     }

     public String toString(){
         return this.nombre + " de " + this.pais + " Errores: " + this.errores + "Aces:" + this.aces + "Total de servicio: " + this.servicio;
     }

     protected String getNombre(){
        return this.nombre;
     }
}
