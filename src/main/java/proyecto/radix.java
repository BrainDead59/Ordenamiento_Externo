package proyecto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *La clase radix será quien se encargue de ordenar únicamente los números de cuenta.
 * Para esto se crean tres métodos, el primero para realizar el proceso de radixSort con la ayuda de los otros dos métodos, 
 * uno para escribir en los archivos, crearArchivos, y el otro para leer los archivos, leerArchivos. 
 * @author Equipo 11, primer proyecto EDA II.
 * @version 1.0
 */
public class radix{
    /**
     *El método radixSort ordena mediante el algoritmo Radix Sort la lista de números de cuenta recibida.
     * Escribe en cada archivo para cada dígito los números que le correspondan, así como las iteraciones en un propio archivo 
     * y, dependiendo el caso, escribe en un archivo nuevo o en el original, la lista de elementos ya ordenados por números de cuenta.
     * @param direccion Carpeta donde se ubica al archivo original.
     * @param archivoOrigen Dirección completa donde se encuentra el archivo a ordenar (incluye extensión txt).
     * @param lista ArrayList donde se encuentran únicamente los números de cuenta.
     * @param archivo Objeto tipo archivo para poder acceder al hashmap dentro de la clase archivo.
     * @param opcion Dependiendo del número ingresado se escribirá en un nuevo archivo o se sobreescribirá el archivo original con las claves ordenadas por número de cuenta. 1: Escribir nuevo archivo. 2: Sobreescribir el archivo original.
     */
    public void radixSort(String direccion, String archivoOrigen, ArrayList<String> lista, archivo archivo, int opcion){
        //Si no es la primera vez que se ejecuta el programa, se eliminan los archivos para no ocasionar conflicto.
        eliminarCarpeta(direccion);
        //Try-Catch para agarrar los errores y mandar un mensaje al usuario.
            try{
                int tam = lista.size(); //Almacena el tamaño de la lista original, ya que la lista se vacía en cada iteración.
                int itc=0; //Conteo de iteraciones de forma ascendente.
                for(int i=5;i>=0;i--){ //Revisa desde el último dígito hasta el primero, o sea, desde el dígito menos significativo hasta el más significativo.
                    for(String nm:lista){ //Para cada elemento de la lista (número de cuenta) se realiza lo siguiente:
                        //Creación de escritura de archivos. Si el archivo no existe, se crea uno nuevo.
                        BufferedWriter digito0 = crearArchivos(0,direccion,archivoOrigen); 
                        BufferedWriter digito1 = crearArchivos(1,direccion,archivoOrigen); 
                        BufferedWriter digito2 = crearArchivos(2,direccion,archivoOrigen); 
                        BufferedWriter digito3 = crearArchivos(3,direccion,archivoOrigen); 
                        BufferedWriter digito4 = crearArchivos(4,direccion,archivoOrigen); 
                        BufferedWriter digito5 = crearArchivos(5,direccion,archivoOrigen); 
                        BufferedWriter digito6 = crearArchivos(6,direccion,archivoOrigen); 
                        BufferedWriter digito7 = crearArchivos(7,direccion,archivoOrigen); 
                        BufferedWriter digito8 = crearArchivos(8,direccion,archivoOrigen); 
                        BufferedWriter digito9 = crearArchivos(9,direccion,archivoOrigen); 
                        switch(nm.charAt(i)){ //Verificamos en qué Queue se añadirá el dígito. Las queues serán los archivos para cada dígito
                            case '0':
                                digito0.write(nm+"\n");
                                break;
                            case '1':
                                digito1.write(nm+"\n");
                                break;
                            case '2':
                                digito2.write(nm+"\n");
                                break;
                            case '3':
                                digito3.write(nm+"\n");
                                break;
                            case '4':
                                digito4.write(nm+"\n");
                                break;
                            case '5':
                                digito5.write(nm+"\n");
                                break;
                            case '6':
                                digito6.write(nm+"\n");
                                break;
                            case '7':
                                digito7.write(nm+"\n");
                                break;
                            case '8':
                                digito8.write(nm+"\n");
                                break;
                            case '9':
                                digito9.write(nm+"\n");
                                break;
                        }   //Una vez guardado el número por su dígito, los cerramos para después abrirlos en modo lectura
                        digito0.close();
                        digito1.close();
                        digito2.close();
                        digito3.close();
                        digito4.close();
                        digito5.close();
                        digito6.close();
                        digito7.close();
                        digito8.close();
                        digito9.close();
                    }
                    lista.clear();
                    BufferedReader digito0_L = leerArchivos(0,direccion);
                    BufferedReader digito1_L = leerArchivos(1,direccion);
                    BufferedReader digito2_L = leerArchivos(2,direccion);
                    BufferedReader digito3_L = leerArchivos(3,direccion);
                    BufferedReader digito4_L = leerArchivos(4,direccion);
                    BufferedReader digito5_L = leerArchivos(5,direccion);
                    BufferedReader digito6_L = leerArchivos(6,direccion);
                    BufferedReader digito7_L = leerArchivos(7,direccion);
                    BufferedReader digito8_L = leerArchivos(8,direccion);
                    BufferedReader digito9_L = leerArchivos(9,direccion);
                    BufferedWriter iteracion = crearArchivos(-1,direccion,archivoOrigen);
                    iteracion.write("Iteración ["+itc+"]: [");
                    
                    //Se leen todos los números de cada archivo de cada dígito, así, se escriben de forma ascendente en el archivo para las iteraciones y se almacenan en la lista.
                    for (int j = 0; j < tam; j++) {
                        String guarda; 
                        int cuenta=1;
                        while((guarda=digito0_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito1_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito2_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito3_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito4_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito5_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito6_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito7_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito8_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        while((guarda=digito9_L.readLine())!=null){
                            if(j<tam-1 && cuenta<tam)
                                iteracion.write(guarda+",");
                            else if(j<tam-1 && cuenta == tam)
                                iteracion.write(guarda);
                            lista.add(guarda);
                            cuenta++;
                        }
                        if(j==tam-1)
                            iteracion.write("]");
                    }
                    if(i>0)
                        iteracion.write("\n");
                    iteracion.close();
                    digito0_L.close();
                    digito1_L.close();
                    digito2_L.close();
                    digito3_L.close();
                    digito4_L.close();
                    digito5_L.close();
                    digito6_L.close();
                    digito7_L.close();
                    digito8_L.close();
                    digito9_L.close();
                    //Se borran todos los elementos de cada archivo de cada dígito
                    PrintWriter writer = new PrintWriter(direccion+"\\Digito_0.txt");
                    writer.print("");
                    writer.close();
                    PrintWriter writer1 = new PrintWriter(direccion+"\\Digito_1.txt");
                    writer1.print("");
                    writer1.close();
                    PrintWriter writer2 = new PrintWriter(direccion+"\\Digito_2.txt");
                    writer2.print("");
                    writer2.close();
                    PrintWriter writer3 = new PrintWriter(direccion+"\\Digito_3.txt");
                    writer3.print("");
                    writer3.close();
                    PrintWriter writer4 = new PrintWriter(direccion+"\\Digito_4.txt");
                    writer4.print("");
                    writer4.close();
                    PrintWriter writer5 = new PrintWriter(direccion+"\\Digito_5.txt");
                    writer5.print("");
                    writer5.close();
                    PrintWriter writer6 = new PrintWriter(direccion+"\\Digito_6.txt");
                    writer6.print("");
                    writer6.close();
                    PrintWriter writer7 = new PrintWriter(direccion+"\\Digito_7.txt");
                    writer7.print("");
                    writer7.close();
                    PrintWriter writer8 = new PrintWriter(direccion+"\\Digito_8.txt");
                    writer8.print("");
                    writer8.close();
                    PrintWriter writer9 = new PrintWriter(direccion+"\\Digito_9.txt");
                    writer9.print("");
                    writer9.close();
                    itc++;
                }
                
                //Dependiendo de la opción deseada, si crear nuevo archivo para las claves ya ordenadas, ó sobreescribir el archivo existente,
                //se escriben las claves ya ordenadas con ayuda del hashmap creado en la clase archivo y modificado en el método leerClaves.
                if(opcion==1){
                    BufferedWriter archivoNuevo = crearArchivos(-2,direccion,archivoOrigen); 
                    archivoNuevo.write("Orden por numeros de cuenta:\n");
                    for (int i = 0; i < lista.size(); i++) {
                        if(i<lista.size()-1)
                            archivoNuevo.write(archivo.hashMapleerClaves.get(lista.get(i))+", "+lista.get(i)+"\n");
                        if(i==lista.size()-1)
                            archivoNuevo.write(archivo.hashMapleerClaves.get(lista.get(i))+", "+lista.get(i));
                    }
                        archivoNuevo.close();
                        System.out.println("Se ha creado un archivo con las claves ordenadas en la carpeta \"RadixSort\".\n Nombre del archivo: \"ordenado.txt\"");
                }else if(opcion==2){
                    BufferedWriter archivoOriginal = crearArchivos(-3,archivoOrigen,archivoOrigen); 
                    archivoOriginal.write("Orden por numeros de cuenta:\n");
                    for (int i = 0; i < lista.size(); i++) {
                        if(i<lista.size()-1)
                            archivoOriginal.write(archivo.hashMapleerClaves.get(lista.get(i))+", "+lista.get(i)+"\n");
                        if(i==lista.size()-1)
                            archivoOriginal.write(archivo.hashMapleerClaves.get(lista.get(i))+", "+lista.get(i));
                    }
                        archivoOriginal.close();
                        System.out.println("Se ha sobreescrito el archivo original con las claves ordenadas.");
                }

        }catch(IOException e){
            System.out.println("Error al abrir el archivo. Intente de nuevo.\n"
                            + "Revise el manual de usuario para más información.");
        }
    }
    
    /**
     * Crea o abre un búfer para la escritura de archivos.
     * @param digito Dependiendo el dígito, se abrirá el búfer para escribir en dicho archivo.
     * @param direccion Dirección de la carpeta que contiene al archivo original, misma donde se crearán los demás archivos.
     * @param dirOriginal Dirección original donde se ubica el archivo a ordenar.
     * @return Regresa el búfer para escribir dependiendo de cuál archivo se haya elegido abrir.
     */
    public BufferedWriter crearArchivos(int digito, String direccion, String dirOriginal){
        File iteracion=new File(direccion+"\\Iteraciones_RADIX_SORT.txt");
        File digito0=new File(direccion+"\\Digito_0.txt");
        File digito1=new File(direccion+"\\Digito_1.txt");
        File digito2=new File(direccion+"\\Digito_2.txt");
        File digito3=new File(direccion+"\\Digito_3.txt");
        File digito4=new File(direccion+"\\Digito_4.txt");
        File digito5=new File(direccion+"\\Digito_5.txt");
        File digito6=new File(direccion+"\\Digito_6.txt");
        File digito7=new File(direccion+"\\Digito_7.txt");
        File digito8=new File(direccion+"\\Digito_8.txt");
        File digito9=new File(direccion+"\\Digito_9.txt");
        File nuevo = new File(direccion+"\\ordenado.txt");
        File original = new File(dirOriginal);
       try{
           switch(digito){
               case -3:
                   BufferedWriter escritoOriginal=new BufferedWriter(new FileWriter(original,false));
                    return escritoOriginal;
               case -2:
                    BufferedWriter escritoNuevo=new BufferedWriter(new FileWriter(nuevo,false));
                    return escritoNuevo;
                case -1:
                    BufferedWriter escritoIteracion=new BufferedWriter(new FileWriter(iteracion,true));
                    return escritoIteracion;
                case 0:
                    BufferedWriter escritodigito0=new BufferedWriter(new FileWriter(digito0,true));
                    return escritodigito0;
                case 1:
                    BufferedWriter escritodigito1=new BufferedWriter(new FileWriter(digito1,true));
                    return escritodigito1;
                case 2:
                    BufferedWriter escritodigito2=new BufferedWriter(new FileWriter(digito2,true));
                    return escritodigito2;
                case 3:
                    BufferedWriter escritodigito3=new BufferedWriter(new FileWriter(digito3,true));
                    return escritodigito3;
                case 4:
                    BufferedWriter escritodigito4=new BufferedWriter(new FileWriter(digito4,true));
                    return escritodigito4;
                case 5:
                    BufferedWriter escritodigito5=new BufferedWriter(new FileWriter(digito5,true));
                    return escritodigito5;
                case 6:
                    BufferedWriter escritodigito6=new BufferedWriter(new FileWriter(digito6,true));
                    return escritodigito6;
                case 7:
                    BufferedWriter escritodigito7=new BufferedWriter(new FileWriter(digito7,true));
                    return escritodigito7;
                case 8:
                    BufferedWriter escritodigito8=new BufferedWriter(new FileWriter(digito8,true));
                    return escritodigito8;
                case 9:
                    BufferedWriter escritodigito9=new BufferedWriter(new FileWriter(digito9,true));
                    return escritodigito9;
                default:
                    break;
           }
       }catch(IOException a){}
       return null;
   }
   
    /**
     * Crea o abre un búfer para la lectura de archivos
     * @param digito Dependiendo el dígito, se abrirá el búfer para leer en dicho archivo
     * @param direccion Dirección de la carpeta que contiene al archivo original, misma donde se contiene a los demás archivos.
     * @return Regresa el búfer para leer dependiendo de cuál archivo se haya elegido abrir.
     */
    public BufferedReader leerArchivos(int digito, String direccion){
       File iteracion=new File(direccion+"\\Iteraciones_RADIX_SORT.txt");
       File digito0=new File(direccion+"\\Digito_0.txt");
       File digito1=new File(direccion+"\\Digito_1.txt");
       File digito2=new File(direccion+"\\Digito_2.txt");
       File digito3=new File(direccion+"\\Digito_3.txt");
       File digito4=new File(direccion+"\\Digito_4.txt");
       File digito5=new File(direccion+"\\Digito_5.txt");
       File digito6=new File(direccion+"\\Digito_6.txt");
       File digito7=new File(direccion+"\\Digito_7.txt");
       File digito8=new File(direccion+"\\Digito_8.txt");
       File digito9=new File(direccion+"\\Digito_9.txt");
       File aux = new File(direccion+"\\auxiliar.txt");
       
       try{
           switch(digito){
               case -2:
                    BufferedReader escritoAux=new BufferedReader(new FileReader(aux));
                    return escritoAux;
                case -1:
                    BufferedReader leerIteracion=new BufferedReader(new FileReader(iteracion));
                    return leerIteracion;
                case 0:
                    BufferedReader leerdigito0=new BufferedReader(new FileReader(digito0));
                    return leerdigito0;
                case 1:
                    BufferedReader leerdigito1=new BufferedReader(new FileReader(digito1));
                    return leerdigito1;
                case 2:
                    BufferedReader leerdigito2=new BufferedReader(new FileReader(digito2));
                    return leerdigito2;
                case 3:
                    BufferedReader leerdigito3=new BufferedReader(new FileReader(digito3));
                    return leerdigito3;
                case 4:
                    BufferedReader leerdigito4=new BufferedReader(new FileReader(digito4));
                    return leerdigito4;
                case 5:
                    BufferedReader leerdigito5=new BufferedReader(new FileReader(digito5));
                    return leerdigito5;
                case 6:
                    BufferedReader leerdigito6=new BufferedReader(new FileReader(digito6));
                    return leerdigito6;
                case 7:
                    BufferedReader leerdigito7=new BufferedReader(new FileReader(digito7));
                    return leerdigito7;
                case 8:
                    BufferedReader leerdigito8=new BufferedReader(new FileReader(digito8));
                    return leerdigito8;
                case 9:
                    BufferedReader leerdigito9=new BufferedReader(new FileReader(digito9));
                    return leerdigito9;
                default:
                    break;
           }
       }catch(IOException a){}
       return null;
   }
    
    public void eliminarCarpeta(String direccion) {
        File carpeta = new File(direccion);
        File[] archivos = carpeta.listFiles();
        File temp;
        if (archivos.length != 0) {
            for (int i = 0; i < archivos.length; i++) {
                temp = new File(archivos[i].toString());
                temp.delete();
            }
        }
    }
}

