/*Ejercicio #5
 * Marinés García - 23391
 * MAIN
 */

import java.util.*;
import java.io.*;  

public class Torneo{

    public static void Menu(){
        System.out.println("\n<<<TORNEO DE VOLEYBALL>>>");
        System.out.println("\nMENÚ");
        System.out.println("\n1.Agregar jugador y mostrar MVP");
        System.out.println("2.Catálogo");
        System.out.println("3.Salir");
    }
    public static void main(String[] args) throws IOException{

        //Definir variables
        Scanner sc = new Scanner(System.in);
        ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>(); 
        boolean salir = false;

        while(!salir){
            Menu();
            System.out.println("\nIngrese un índice: ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch(opc){

            case 1: //agrega un jugador al torneo 
                System.out.println("\nIngrese el nombre del jugador: ");
                String name = sc.nextLine();
                System.out.println("\nIngrese el país del jugador: ");
                String país = sc.nextLine();
                System.out.println("\nIngrese la cantidad de errores del jugador: ");
                int errores = sc.nextInt();
                System.out.println("\nIngrese la cantidad de aces del jugador: ");
                int aces = sc.nextInt();
                System.out.println("\nIngrese el total de servicios del jugador: ");
                int servicios = sc.nextInt();  
                
                System.out.println("\nIngrese el tipo de jugador: \n1.Líbero \n2.Pasador \n3.Auxiliares/Opuestos ");
                int indexJugador = sc.nextInt(); 
                
                if(indexJugador == 1){ //Agrega info a líberos
                    System.out.println("\n==Líbero==");

                    System.out.println("\nIngrese el total de recibos del jugador: ");
                    int recibos = sc.nextInt();

                    //Se agrega info a array
                    listaJugadores.add(new Libero(name, país, errores, aces, servicios, recibos));

                    //Calcula los 3 mejores líbanos
                    System.out.println("\n== 3 mejores Líbanos ==");
                    for(int i = 0; i<Math.min(3, listaJugadores.size()); i++){
                        Libero mvpLiberos = new Libero(name, país, errores, aces, servicios, recibos);
                        System.out.println(mvpLiberos.getNombre() + ": " + mvpLiberos.getMvpLibero());
                    }

                } if (indexJugador == 2) { //Agrega info a pasador
                    System.out.println("\n==Pasador==");

                    System.out.println("\nIngrese el total de pases del jugador: ");
                    int pases = sc.nextInt();
                    System.out.println("\nIngrese el total de fintas del jugador: ");
                    int fintas = sc.nextInt();

                    //Agrega info a Array
                    listaJugadores.add(new Pasador(name, país, errores, aces, servicios, pases, fintas));

                    //Pasadores con más de 80% efect
                    System.out.println("\n== Pasadores con 80% de efectividad ==");
                    int pasadorEfectividad = 0;
                    for(Jugador j : listaJugadores){
                        if(j instanceof Libero){
                            Libero efectLibero = (Libero) j;
                            if(efectLibero.getMvpLibero() > 85){
                                pasadorEfectividad++;
                            }
                        }
                    }
                    System.out.println("\nCantidad de Pasadores con más de 85% de efectividad: " + pasadorEfectividad);
                    

                } if(indexJugador == 3){ //Agrega info a Auxiliares/Opuestos
                    System.out.println("\n==Auxiliares/Opuestos==");

                    System.out.println("\nIngrese el total de ataques del jugador: ");
                    int ataques = sc.nextInt();
                    System.out.println("\nIngrese el total de bloqueos efectivos del jugador: ");
                    int bloqueos = sc.nextInt();
                    System.out.println("\nIngrese el total de bloqueos fallidos del jugador: ");
                    int failBloquos = sc.nextInt();

                    //Agrega info a Array
                    listaJugadores.add(new AuxOp(name, país, errores, aces, servicios, ataques, bloqueos, failBloquos));

                } else {
                    //System.out.println("Favor ingrese un índice correcto...");
                }
                
                break;

            case 2: 
                System.out.println("\n<<<Archivo Lista de Jugadores>>>\n");
                
                //Crea archivo CSV
                File file = new File("Lista de Jugadores");
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Nombre,País,Errores,Aces,Servicios,Tipo"); //Nombre de columnas archivo
                bw.newLine();

                //Agrega info de Array a archivo
                for(int i = 0; i<listaJugadores.size(); i++){
                    bw.write(listaJugadores.get(i+1) + "," + listaJugadores.get(i++));
                    bw.newLine();
                }
                bw.close();
                fw.close();
                break;

            case 3:
                System.out.println("Gracias por utilizar el programa!");
                salir = true;                
                break;

            default: 
                System.err.print("Opcion no valida...");
            }  
        }   
        sc.close();
    }
}