package proyecto;

import java.io.File;
import java.util.*;

/**
 *Clase principal que contiene el método para el menú de usuario y la llamada a los métodos para ordenar las claves.
 * @author Equipo 11, primer proyecto EDA II.
 * @version 1.0
 */
public class Main {

    /**
     *Método principal que contiene el menú de usuario y las respectivas llamadas a los métodos para ordenar claves.
     * @param args Entrada de argumentos. NO DISPONIBLE.
     */
    public static void main(String[] args) {
        int veces=0;
        archivo archivo = new archivo();
        Scanner s = new Scanner(System.in);
        System.out.println("Deberás introducir la ruta que contiene el archivo a ordenar.\nSe te pedirá introducir la ruta paso a paso.");
        System.out.println("1. Inserta el nombre de tu carpeta usuario");
        String usuario=s.next();
        System.out.println("C:\\Users\\"+usuario+"\\Desktop\\CARPETA\\");
        System.out.println("2. Inserta el nombre de tu carpeta en el escritorio:");
        String carpeta=s.next();
        String direccionCarpeta = ("C:\\Users\\"+usuario+"\\Desktop\\"+carpeta);
        System.out.println("C:\\Users\\"+usuario+"\\Desktop\\"+carpeta+"\\ARCHIVO_A_ORDENAR");
        
        int opcion,subop;
        boolean salir = false;
        while(!salir){
            
            if(veces!=0){
                System.out.println("¿Deseas ordenar otro archivo?\n1.Sí\n2.No");
                int ordenarOtro = s.nextInt();
                if(ordenarOtro!=1)
                    break;
            }
            System.out.println("3. Introduce el nombre del archivo que se ordenará(no incluyas la extensión .txt):");
            String archivoNombre=s.next();
            String ruta="C:\\Users\\"+usuario+"\\Desktop\\"+carpeta+"\\"+archivoNombre+".txt";
            
            veces++;
            System.out.println("\n***MENÚ PRINCIPAL***\n"
                                + "Elige una opción:\n"
                                + "1)Ordenar mediante POLIFASE\n"
                                + "2)Ordenar mediante MEZCLA EQUILIBRADA\n"
                                + "3)Ordenar mediante RADIX\n4)Salir");
            try{
                System.out.println("Opción: ");
                opcion = s.nextInt();
                switch(opcion){
                    case 1:
                        String direccionPolifase = direccionCarpeta+"\\Polifase";
                        File directorioPolifase = new File(direccionPolifase);
                        if(!directorioPolifase.exists()) 
                            directorioPolifase.mkdir();
                        Polifase polifaseUno= new Polifase(ruta,direccionPolifase);
                        polifaseUno.eliminarCarpeta(direccionPolifase);
                        System.out.println("¿Qué deseas ordenar mediante POLIFASE?\n1)Nombres\n2)Apellidos");
                        subop = s.nextInt();
                        try{
                            if(subop==1){
                                System.out.println("* Se ordenarán NOMBRES mediante POLIFASE *");
                                archivo nombres = new archivo();
                                nombres.leerClaves(ruta, 2);
                                polifaseUno.polifaseNombre();
                                polifaseUno.polifaseParteDos(1,direccionCarpeta,nombres);
                                
                                
                            }else if(subop==2){
                                System.out.println("* Se ordenarán APELLIDOS mediante POLIFASE *");
                                archivo apellidos = new archivo();
                                apellidos.leerClaves(ruta, 3);
                                polifaseUno.polifaseApellido();
                                polifaseUno.polifaseParteDos(2,direccionCarpeta,apellidos);
                            }
                        }catch(InputMismatchException ep){
                            System.out.println("Introduce una opción válida para ordenar\n");
                        }
                        break;
                    case 2: 
                        System.out.println("¿Qué deseas ordenar mediante MEZCLA EQUILIBRADA?\n1)Nombres\n2)Apellidos");
                        subop = s.nextInt();
                        try{
                            if(subop==1){
                                System.out.println("* Se ordenarán NOMBRES mediante MEZCLA EQUILIBRADA *");
                                //llamar a mezcla equilibrada con nombres
                            }else if(subop==2){
                                System.out.println("* Se ordenarán APELLIDOOS mediante MEZCLA EQUILIBRADA *");
                                //llamar a mezcla equilibrada con apellidos
                            }
                        }catch(InputMismatchException ep){
                            System.out.println("Introduce una opción válida para ordenar\n");
                        }
                        break;
                    case 3:
                        System.out.println("Se ordenarán los números de cuenta mediante RADIX");
                        System.out.println("¿Deseas que se sobreescriba el archivo original o se cree uno nuevo?\n"
                                            + "1. Escribir en un archivo nuevo\n"
                                            + "2. Sobreescribir el archivo original");
                        int radix_opc=s.nextInt();
                        archivo temp = new archivo();
                        radix radixs = new radix();
                        
                        String direccionRadix = direccionCarpeta+"\\RadixSort";
                        File directorioRadix = new File(direccionRadix);
                        if(!directorioRadix.exists()) 
                            directorioRadix.mkdir();
                        radixs.radixSort(direccionRadix,ruta,temp.leerClaves(ruta, 1),temp,radix_opc);
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Introduce un número válido\n");
                }
            }
               catch(InputMismatchException e){
                System.out.println("Introduce una opción válida: \n");
                s.next();
            }
        }
    }
}
