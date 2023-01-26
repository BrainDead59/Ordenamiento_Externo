package proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *Clase creada para la lectura del archivo a ordenar, se requiere de un hashmap para poder ordenar las listas por separado sin perder los campos que pertenecen a cada clave.
 * @author Equipo 11, primer proyecto EDA II.
 * @version 1.0
 */
public class archivo {
    //En este hashmap, dependiendo del campo a ordenar, se almacenarán los elementos del archivo original.
    Map<String,String> hashMapleerClaves=new HashMap<>();
    
    /**
     *El método leerClaves separa cada campo del archivo en ArrayList.
     * @param ruta Ruta donde se encuentra el archivo donde leer las claves.
     * @param opc Elección de claves a leer. 1: Números de cuenta. 2: Nombres. 3: Apellidos.
     * @return ArrayList donde se encuentran únicamente las claves escogidas.
     */
    public ArrayList<String> leerClaves(String ruta, Integer opc){
    
    File archivo = new File(ruta); //Archivo de donde obtener las claves.
    //ArrayLists para cada clave.
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> apellidos = new ArrayList<>();
    ArrayList<String> ncuenta = new ArrayList<>();
    Scanner scan = null;
    //Verificamos que se pueda leer el archivo, si hay algún error, el programa avisará al usuario.
    try {
        scan = new Scanner(archivo);
        //Se leerá línea por línea, cada campo separado por coma se almacenará en su respectivo ArrayList.
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineArray = line.split(",");
            //Eliminamos los espacios de cada clave
            String names = lineArray[0].replaceAll("\\s+","");
            String ap_juntos = lineArray[1].replaceAll("\\s+","");
            String nCuenta = lineArray[2].replaceAll("\\s+","");
            //Según la opción indicada, se almacenará en el HashMap asignando como llave el campo elegido.
            if(opc==1){
                hashMapleerClaves.put(nCuenta,lineArray[0]+","+lineArray[1]);
            }else if(opc==2){
                hashMapleerClaves.put(names,lineArray[1] +", "+ nCuenta);
            }else if(opc==3){
                hashMapleerClaves.put(ap_juntos, lineArray[1]);
            }
            apellidos.add(lineArray[1]);
            ncuenta.add(nCuenta);
        }
    } catch (FileNotFoundException e) { //Error. Se refiere al manual de usuario para saber qué ocurrió.
        System.out.println("Hubo un error al verificar la integridad del archivo. Intente de nuevo\n"
                         + "Para más información revise el manual de usuario");
    } finally {
        scan.close();
        System.out.println();
        //Si se desea, se pueden conocer las llaves y valores antes de proceder.
        //Se regresa el ArrayList únicamente con las claves del campo deseado.
        if(opc==1){ 
            //System.out.println("NUMEROS DE CUENTA");
            //hashMapleerClaves.forEach((key, value) -> System.out.println(key + ":" + value));
            return ncuenta;
        }
        if(opc==2){
            //System.out.println("NOMBRES");
            //hashMapleerClaves.forEach((key, value) -> System.out.println(key + ":" + value));
            
            return nombres;
        }
        if(opc==3){
            //System.out.println("APELLIDOS");
            //hashMapleerClaves.forEach((key, value) -> System.out.println(key + ":" + value));
            return apellidos;
        }
        System.out.println("\n\n");
    }
    return null;
    }
}