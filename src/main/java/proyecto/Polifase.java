package proyecto;

import java.io.*;
import java.util.*;

/**
 * La clase polifase, contiene todos los metodos para la elaboracion del ordenamiento por medio del nombre o del apellido. Este algoritmo de ordenamiento
 * se divide en dos partes, la primer contiene la lectura y separacion de las claves, la segunda permite la intercalacion de los bloques y se crea el archivo
 * final
 * @author Equipo 11, primer proyecto EDA II.
 */

public class Polifase {
    static Map<String,String> miTablita=new HashMap<>();
    static Map<String,String> miTablita1=new HashMap<>();
    static Map<String,String> miTablita2=new HashMap<>();
    public String direccionL;
    public String direccionE1;
    public String direccionE2;
    public String direccionE0;
    public String direccionE3;
    public String direccionOrden;
    
    /**
     * En este método se crean los primeros arhivos F1 y F2 en donde se van a escribir los datos que se toman del archivo de lectura "Prueba" en base al
     * nombre
     * @param rutaCarpeta Es la dirección de la carpeta donde se contiene al archivo a ordenar. En esta carpeta se almacenarán los archivos auxiliares
     * @param rutaArchivo Es la dirección específica donde se ubica el archivo a ordenar.
     */
            
    public Polifase(String rutaArchivo,String rutaPolifase){
        this.direccionL=rutaArchivo;
        this.direccionE2=rutaPolifase+"\\F2.txt";
        this.direccionE1=rutaPolifase+"\\F1.txt";
        this.direccionE2=rutaPolifase+"\\F2.txt";
        this.direccionE0=rutaPolifase+"\\F0.txt";
        this.direccionE3=rutaPolifase+"\\F3.txt";
        this.direccionOrden= rutaPolifase+"\\FF.txt";
        eliminarCarpeta(rutaPolifase);
    }

    /**
     *Este metodo realiza la poliFase por medio del criterio de nombres, en ese caso se realiza  la lectura de los archivos y se separan las claves
     * de los demas datos para trabajar unicamente con estas.
     */
    public void polifaseNombre(){
		String acumulador;
		String guarda;
		int numeroArchivo=0;
		int cantidadElementos=0;
                int contador=0;
                List<String> apoyo = new LinkedList<>();
                List<String> apoyoA = new LinkedList<>();
                List<String> apoyoC = new LinkedList<>();
		try{
                    BufferedWriter escribir1= crearArchivo(0);
                    BufferedWriter escribir2= crearArchivo(1);
                    BufferedReader lecturaB = leerArchivo(4);
                    while((guarda=lecturaB.readLine())!=null){
                            StringTokenizer secciones= new StringTokenizer(guarda,",");
                            while(secciones.hasMoreTokens()){
                                apoyo.add(secciones.nextToken());
                                apoyoA.add(secciones.nextToken());
                                apoyoC.add(secciones.nextToken());
                                miTablita.put(apoyo.get(contador),apoyoA.get(contador)+","+apoyoC.get(contador));
                                cantidadElementos+=1;
                                contador+=1;
                                if(contador==10){
                                    contador=0;
                                }
                                if(cantidadElementos==10){
                                    numeroArchivo+=1;
                                    cantidadElementos=0;
                                    
                                    if(numeroArchivo%2==0){
                                        acumulador="";
                                        for(String x: apoyo){
                                            acumulador=acumulador+x+",";
                                        }
                                        escribir2.write(ordenar(acumulador,1));
                                        escribir2.write("/");
                                        
                                        
                                    }else{
                                        acumulador="";
                                        for(String x: apoyo){
                                            acumulador=acumulador+x+",";
                                        }
                                        escribir1.write(ordenar(acumulador,1));
                                        escribir1.write("/");
                                    }
                                    apoyo.clear();
                                    apoyoA.clear();
                                    apoyoC.clear();
                                } 
                            }
			}  
                    if(!apoyo.isEmpty()){
                        numeroArchivo+=1;
                        if(numeroArchivo%2==0){
                            acumulador="";
                            for(String x: apoyo){
                                acumulador=acumulador+x+",";
                            }
                            escribir2.write(ordenar(acumulador,1));
                            escribir2.write("/");
                            
                        }else{
                            acumulador="";
                            for(String x: apoyo){
                                acumulador=acumulador+x+",";
                            }
                            escribir1.write(ordenar(acumulador,1));
                            escribir1.write("/");
                        }
                        apoyo.clear();
                    }
                    escribir1.write("\n");
                    escribir2.write("\n");
                    lecturaB.close();
                    escribir1.close();
                    escribir2.close();
                }catch(IOException e){}
                
	}
  
    /**
     *
     *Este metodo realiza la poliFase por medio del criterio de apellido, en ese caso se realiza  la lectura de los archivos y se separan las claves
     * de los demas datos para trabajar unicamente con estas.
     */
    public void polifaseApellido(){
		String acumulador;
		String guarda;
		int numeroArchivo=0;
		int cantidadElementos=0;
                int contador=0;
                List<String> apoyoN = new LinkedList<>();
                List<String> apoyo = new LinkedList<>();
                List<String> apoyoC = new LinkedList<>();
		try{
                    BufferedWriter escribir1= crearArchivo(0);
                    BufferedWriter escribir2= crearArchivo(1);
                    BufferedReader lecturaB = leerArchivo(4);
                    while((guarda=lecturaB.readLine())!=null){
                            StringTokenizer secciones= new StringTokenizer(guarda,",");
                            while(secciones.hasMoreTokens()){
                                apoyoN.add(secciones.nextToken());
                                apoyo.add(secciones.nextToken().replace(" ",""));
                                apoyoC.add(secciones.nextToken());
                                miTablita1.put(apoyo.get(contador),apoyoN.get(contador));
                                miTablita2.put(apoyo.get(contador),apoyoC.get(contador));
                                cantidadElementos+=1;
                                contador+=1;
                                if(contador==10){
                                    contador=0;
                                }
                                if(cantidadElementos==10){
                                    numeroArchivo+=1;
                                    cantidadElementos=0;
                                    
                                    if(numeroArchivo%2==0){
                                        acumulador="";
                                        for(String x: apoyo){
                                            acumulador=acumulador+x+",";
                                        }
                                        escribir2.write(ordenar(acumulador,2));
                                        escribir2.write("/");
                                        
                                        
                                    }else{
                                        acumulador="";
                                        for(String x: apoyo){
                                            acumulador=acumulador+x+",";
                                        }
                                        escribir1.write(ordenar(acumulador,2));
                                        escribir1.write("/");
                                    }
                                    apoyo.clear();
                                    apoyoN.clear();
                                    apoyoC.clear();
                                } 
                            }
			}  
                    if(!apoyo.isEmpty()){
                        numeroArchivo+=1;
                        if(numeroArchivo%2==0){
                            acumulador="";
                            for(String x: apoyo){
                                acumulador=acumulador+x+",";
                            }
                            escribir2.write(ordenar(acumulador,2));
                            escribir2.write("/");
                            
                        }else{
                            acumulador="";
                            for(String x: apoyo){
                                acumulador=acumulador+x+",";
                            }
                            escribir1.write(ordenar(acumulador,2));
                            escribir1.write("/");
                        }
                        apoyo.clear();
                    }
                    escribir1.write("\n");
                    escribir2.write("\n");
                    lecturaB.close();
                    escribir1.close();
                    escribir2.close();
                }catch(IOException e){}
                
	}
   /**
    * En esta segunda parte del polifase donde se comienza el proceso de lectura de los archivos y el ordenamiento de los paquetes, que en este caso son
    * de 10 elementos
    * @param opcion Este parametro permite el ejecutar el tipo de ordenamiento posteriormente de forma automatica, sin indicarlo como en los anteriores
     * @param rutaCarpeta Ruta de la carpeta con la que se verificará en dónde está la última iteración de la parte dos de polifase
     * @param apellidos Objeto de la clase archivo, utilizado para reordenar los apellidos con sus nombres y números de cuenta correspondientes mediante el método ordenFinal
    */
    public void polifaseParteDos(int opcion, String rutaCarpeta,archivo apellidos){
        String aux1,aux2,ultimo = null;
        int linea=1,w=-1,contador=0; 
        Scanner dir= new Scanner(System.in);
        try{
            BufferedReader lecturaB1 = leerArchivo(0);
            BufferedReader lecturaB2 = leerArchivo(1);
                    
            BufferedWriter escritoArchivoF0=crearArchivo(2);
            BufferedWriter escritoArchivoF3=crearArchivo(3);
            while(true){
                w++;
                        
                aux1=leerLinea(linea,lecturaB1);
                aux2=leerLinea(linea,lecturaB2);
                
                String[] archivo1=aux1.split("/");
                String[] archivo2=aux2.split("/");
                
                if(archivo1.length<archivo2.length){
                    aux1=aux1+"A/";
                    archivo1=aux1.split("/");
                }
                if(archivo1.length>archivo2.length){
                    aux2=aux2+"A/";
                    archivo2=aux2.split("/");
                }
                
                if(aux1.equals("") || aux2.equals("")|| aux1.equals(aux2)){
                    break;
                }
                if(aux2==null){
                    break;
                }
                if(aux1==null){
                    break;
                }
                
                contador++;
                for(int i=0;i<archivo1.length || i<archivo2.length;i++){
                    if(i%2==0){
                        String valor=archivo1[i]+archivo2[i];
                        escritoArchivoF0.write(ordenar(valor,opcion)+"/");
                        if(contador%2==0){
                            ultimo = "\\F1";
                        }else{
                            ultimo = "\\F0";
                        }
                    }
                    else{
                        String valor=archivo1[i]+archivo2[i];
                        escritoArchivoF3.write(ordenar(valor,opcion)+"/");
                        if(contador%2==0){
                            ultimo = "\\F2";
                        }else{
                            ultimo = "\\F3";
                        }
                    }
                }
                escritoArchivoF0.write("\n");
                escritoArchivoF3.write("\n");
                escritoArchivoF0.close();
                escritoArchivoF3.close();
                if(aux1.equals("") || aux2.equals("")|| aux1.equals(aux2)){
                    break;
                }
                
                if(w%2==0){
                    escritoArchivoF0=crearArchivo(0);
                    escritoArchivoF3=crearArchivo(1);
                    lecturaB1 = leerArchivo(2);
                    lecturaB2 = leerArchivo(3);
                }
                else{
                    escritoArchivoF0=crearArchivo(2);
                    escritoArchivoF3=crearArchivo(3);
                    lecturaB1 = leerArchivo(0);
                    lecturaB2 = leerArchivo(1);
                    linea+=1;
                }
            }
            escritoArchivoF0.close();
            escritoArchivoF3.close();
            lecturaB1.close();
            lecturaB2.close();
        }catch(IOException e){
            System.out.println("Valio");
        }
        
        String direccionF1=rutaCarpeta+ultimo+".txt";
        
        ordenFinal(linea,direccionF1,opcion,apellidos);
   }
   /**
    * Este metodo permite el ordenar la linea ordenada de nombres o apellidos dentro del arhivo de origen, de acuerdo al tipo de dato
    * @param linea Indica la linea en el documento donde se guardo el orden final, para leerla y posteriormente ordenarla en el arhivo de origen
    * @param direccionF Indica la direcicion final del docuemento que es la direccion del ultimo arhivo, donde se guarda el orden
    * @param opcion Indica la opcion en caso de que sea ordenamiento por Nombre o por Apellido
     * @param apellidos Objeto de la clase archivo, utilizado para reordenar los apellidos con sus nombres y números de cuenta correspondientes utilizando su hashmap
    */
    public void ordenFinal(int linea,String direccionF,int opcion, archivo apellidos){
        String aux;
        if(opcion==1){
            try{
                File archivoF= new File(direccionF);
                FileReader archivoR= new FileReader(archivoF);
                BufferedReader archivoRB= new BufferedReader(archivoR);

                File archivoL= new File(direccionOrden);
                FileWriter archivoLW= new FileWriter(archivoL,true);
                BufferedWriter archivoWB= new BufferedWriter(archivoLW); 

                aux=leerLinea(linea,archivoRB);
                String[] archivo=aux.split(",");
                archivoWB.write("Archivo Ordenado por Nombres\n");
                for(int i=0;i<archivo.length;i++){
                    if(miTablita.get(archivo[i])==null){
                        i++;
                    }else{
                        archivoWB.write(archivo[i]+","+miTablita.get(archivo[i])+"\n");
                    }    
                }
               archivoRB.close();
               archivoWB.close();
            }catch(IOException e){}
        }else{
            try{
                File archivoF= new File(direccionF);
                FileReader archivoR= new FileReader(archivoF);
                BufferedReader archivoRB= new BufferedReader(archivoR);

                File archivoL= new File(direccionOrden);
                FileWriter archivoLW= new FileWriter(archivoL,true);
                BufferedWriter archivoWB= new BufferedWriter(archivoLW); 

                aux=leerLinea(linea,archivoRB);
                String[] ln=aux.split(",");
                archivoWB.write("Archivo Ordenado por Apellidos\n");
                for(int i=0;i<ln.length;i++){
                    if(miTablita1.get(ln[i])==null || miTablita2.get(ln[i])==null){
                        i++;
                    }else{
                        archivoWB.write(miTablita1.get(ln[i])+","+apellidos.hashMapleerClaves.get(ln[i])+","+miTablita2.get(ln[i])+"\n");
                    }    
                }
               archivoRB.close();
               archivoWB.close();
                System.out.println("Se han agregado al archivo original los apellidos ordenados.\n\n");
            }catch(IOException e){}
        }
    }
    /**
     * En este metodo se crean los archivos y se crea la escritura en caso de que existan.
     * @param opcion Indica la direccion que se va autilizar para crear/escribir sobre el archivo
     * @return BufferedWriter Este regresa la referencia del archivo que permite la escritura
     */
   public BufferedWriter crearArchivo(int opcion){
       File archivo1=new File(direccionE1);
       File archivo2=new File(direccionE2);
       File archivo3=new File(direccionE0);
       File archivo4=new File(direccionE3);
       FileWriter escritor;
       try{
           switch(opcion){
               case 0:
                   escritor=new FileWriter(archivo1,true);
                   BufferedWriter escritoArchivo1=new BufferedWriter(escritor);
                   return escritoArchivo1;
               
               case 1:
                   escritor=new FileWriter(archivo2,true);
                   BufferedWriter escritoArchivo2=new BufferedWriter(escritor);
                   return escritoArchivo2;
                   
               case 2:
                   escritor=new FileWriter(archivo3,true);
                   BufferedWriter escritoArchivo3=new BufferedWriter(escritor);
                   return escritoArchivo3;  
                   
               case 3:
                   escritor=new FileWriter(archivo4,true);
                   BufferedWriter escritoArchivo4=new BufferedWriter(escritor);
                   return escritoArchivo4;
                   
               default:
                   break;
           }
       }catch(IOException a){}
       return null;
   }
   /**
    * Este metodo permite la lectura de los archivos en base a una opccion que indica que archivo se va a leer
    * @param opcion Indica la direccion que se va autilizar para leer el archivo
    * @return BufferedReader Este regresa la referencia del archivo que permite la lectura
    */
   public BufferedReader leerArchivo(int opcion){
       File archivo=new File(direccionL);
       File archivo1=new File(direccionE1);
       File archivo2=new File(direccionE2);
       File archivo3=new File(direccionE0);
       File archivo4=new File(direccionE3);
       FileReader lector;
       try{
           switch(opcion){
               case 0:
                   lector=new FileReader(archivo1);
                   BufferedReader leerArchivo1=new BufferedReader(lector);
                   return leerArchivo1;
               
               case 1:
                   lector=new FileReader(archivo2);
                   BufferedReader leerArchivo2=new BufferedReader(lector);
                   return leerArchivo2;
                   
               case 2:
                   lector=new FileReader(archivo3);
                   BufferedReader leerArchivo3=new BufferedReader(lector);
                   return leerArchivo3;  
                   
               case 3:
                   lector=new FileReader(archivo4);
                   BufferedReader leerArchivo4=new BufferedReader(lector);
                   return leerArchivo4;
               
               case 4:
                   lector=new FileReader(archivo);
                   BufferedReader leerArchivo=new BufferedReader(lector);
                   return leerArchivo;
                   
               default:
                   break;
           }
       }catch(IOException a){}
       return null;
   }
   
   /**
    * Este metodo permite la lectura de una linea especifica del archivo, en este caso se lee i veces antes, para llegar a la que se va a leer, y 
    * regresa la lectura de la linea indicada.
    * @param numLinea Indica la linea a leer
    * @param lista Lector que permite la lectura del archivo que le corresponde
    * @return regresa la lectura de la linea especifica
    */ 
   public String leerLinea(int numLinea,BufferedReader lista){
        try {
            for(int i=1;i<numLinea;i++){
                lista.readLine();
            }
            return lista.readLine(); 
        } catch (IOException e) {}
        return null;
    }
   /**
    * Este metodo ordena los elementos que se envien, por medio de insertionSort, y los regresa como una string
    * @param cadena Es la cadena que contiene los elementos a ordenar y despues se manda a un arreglo para ordenar
    * @param opcion Indica que tipo de dato se va a ordenar, si es el nombre o apellido.
    * @return Regresa la string ordenada de los valores enviados a ordenar
    */
   
   public String ordenar(String cadena,int opcion){
       String [] auxiliar = cadena.split(",");
       ArrayList<String> regreso=insertionSort(auxiliar,auxiliar.length,opcion);
       cadena="";
       for(String x:regreso){
           cadena=cadena+x+",";
       }
       return cadena;
   }
   
   /**
    * Algoritmo de ordenamiento para las cadenas, que devuelve una lista, que tiene los valores ordenados
    * @param arr Es el arreglo que contiene los elementos a ordenar
    * @param n Indica el tamaño del arreglo
    * @param opcion Indica el tipo de ordenamiento, si es nombre o apellidos
    * @return regresa la lista, para que se devuelva al archivo
    */
   
   public ArrayList insertionSort(String[] arr, int n,int opcion){
	if(opcion==1){
            int i,j;
            String aux;
            for(i=1; i<n; i++){
                j=i;
                aux=arr[i];
                while ((j>0 && aux.charAt(0) < arr[j-1].charAt(0))){
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j]=aux;
            }
        }else{
            int i,j;
            String aux;
            for(i=1; i<n; i++){
                j=i;
                aux=arr[i];
                while ((j>0 && aux.charAt(0) < arr[j-1].charAt(0))){
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j]=aux;
            }
        }
        
        ArrayList<String> auxiliarF = new ArrayList<String>();
        for(int k =0;k<arr.length;k++){
           if(!arr[k].equals(" ")){
               auxiliarF.add(arr[k]);
           }
        }
    return auxiliarF;
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
