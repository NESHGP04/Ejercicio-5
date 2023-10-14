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
                
                if(indexJugador == 1){
                    System.out.println("\n==Líbero==");

                    System.out.println("\nIngrese el total de recibos del jugador: ");
                    int recibos = sc.nextInt();

                    listaJugadores.add(new Libero(name, país, errores, aces, servicios, recibos));

                    System.out.println("\n== 3 mejores Líbanos ==");
                    for(int i = 0; i<Math.min(3, listaJugadores.size()); i++){
                        Libero mvpLiberos = new Libero(name, país, errores, aces, servicios, recibos);
                        mvpLiberos.getMvpLibero();
                        System.out.println(mvpLiberos.getNombre() + ": " + mvpLiberos.getMvpLibero());
                    }

                } if (indexJugador == 2) {
                    System.out.println("\n==Pasador==");

                    System.out.println("\nIngrese el total de pases del jugador: ");
                    int pases = sc.nextInt();
                    System.out.println("\nIngrese el total de fintas del jugador: ");
                    int fintas = sc.nextInt();

                    listaJugadores.add(new Pasador(name, país, errores, aces, servicios, pases, fintas));

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
                    

                } if(indexJugador == 3){
                    System.out.println("\n==Auxiliares/Opuestos==");

                    System.out.println("\nIngrese el total de ataques del jugador: ");
                    int ataques = sc.nextInt();
                    System.out.println("\nIngrese el total de bloqueos efectivos del jugador: ");
                    int bloqueos = sc.nextInt();
                    System.out.println("\nIngrese el total de bloqueos fallidos del jugador: ");
                    int failBloquos = sc.nextInt();

                    listaJugadores.add(new AuxOp(name, país, errores, aces, servicios, ataques, bloqueos, failBloquos));

                } else {
                    //System.out.println("Favor ingrese un índice correcto...");
                }
                
                break;

            case 2: 
                System.out.println("\n<<<Archivo Lista de Jugadores>>>\n");
                
                File file = new File("Lista de Jugadores");
                //String format = "%-10s %-8s %-4s%n";

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Nombre,País,Errores,Aces,Servicios,Tipo");
                bw.newLine();

                for(int i = 0; i<listaJugadores.size(); i++){
                    bw.write(listaJugadores.get(i+1) + "," + listaJugadores.get(i++));
                    bw.newLine();
                }
                bw.close();
                fw.close();
                

                // try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                //     bw.write("Nombre,País,Errores,Aces,Servicios,Tipo");
                //     System.out.printf(format, "Nombre,País,Errores,Aces,Servicios,Tipo");

                //     for(Jugador j : listaJugadores){
                //         System.out.println(j);
                //     }

                // }
                
                //     String format = "%-10s %-8s %-4s%n";

                //     try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                //         bw.write("Nombre,País,Errores,Aces,Servicios,Tipo");

                //         System.out.printf(format, "Nombre,País,Errores,Aces,Servicios,Tipo");
                //         for (int i=0 ;i <listaJugadores.size() ; ++i ){
                //             for(int j =0; j < listaJugadores.size(); j++){
                //                 String s = String.format(",%s,%s,%s", listaJugadores.get(j));
                //                 System.out.printf(format, listaJugadores.get(j));
                //                 bw.write(s);
                //             }
                //         }
                //     } catch (Exception e){
                //         e.printStackTrace();
                //     }

                    //Collections.sort(listaJugadores, (a,b) -> Double.compare(b.getMvpLibero(), a.getMvpLibero()));
                // try{  
                //     BufferedReader brSalon = new BufferedReader(new FileReader("Jugadores.csv"));  //Lee salones.csv
                //     while ((line = brSalon.readLine()) != null){  
                //         jugador = line.split(splitBy);    // use comma as separator  
                //         System.out.println("\nJugador: " + jugador[0] + "\nPaís: " + jugador[1] + "\nErrores: " + jugador[2] + "\nAces: " + jugador[3] + "\nServicios: " + jugador[4]);  //Ordena datos separados por comas
                //         }  
                //     System.out.println("\nSe ha cargado el archivo exitosamente!");        
                // } catch (IOException e)   {  
                //         //e.printStackTrace();  
                //     }
                
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