package proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mezclaEquilibrada {
    static Map<String,String> mapa=new HashMap<>();
    
    static void mezclaE(String direccion, String archivoOrigen, ArrayList<String> lista, archivo archivo, int opcion){
        
            /*int[] lista_int = StringAInt(lista);
            int[] temp;
            int izquierda = 0, izq =0, derecha = lista_int.length - 1, der = derecha;
            System.out.println("no ordenada:");
            */
            
            mezclaDirecta(lista);
            /*do{
                ordenado=true;
                izquierda = 0;
                while(izquierda<derecha){
                    izq=izquierda;
                    while(izq<derecha && lista_int[izq] <= lista_int[izq+1]){
                        izq++;
                    }
                    der=izq+1;
                    while(der==derecha-1 || der<derecha && lista_int[der]<=lista_int[der+1]){
                        der++;
                    }
                    if(der<=derecha){
                        temp = mezclaDirecta(lista_int);
                        
                        
                        ordenado=false;
                    }
                    izquierda=izq;
                }
                
            }while(!ordenado);
                System.out.println("ordenada:");
                for(int z =0;z<lista_int.length;z++){
                    System.out.println(lista_int[z]);
                }
                System.out.println("Lista ordenada int: ");
                for(int x=0; x<lista_int.length;x++){
                    System.out.println(lista_int[x]+":"+mapa.get(String.valueOf(lista_int[x])));
                    //iteracion.write(mapa.get(String.valueOf(lista_int[x]))+"\n");
                imprimir mapa ordenado
                for(int x=0; x<lista_int.length;x++){
                System.out.println(lista_int[x]+":"+mapa.get(String.valueOf(lista_int[x])));
            }
            */     
    }
    /*  19,21,22,22,22,<-F1 e=1
        19,21,<-F2
        10,28,<-F1
        22,11,25,23,12,22,19,19,35,10,19,10,15,25,19,14,14,13,19,22
    
    */
    static ArrayList<String> mezclaDirecta(ArrayList<String> lista){
        ArrayList<String> F1 =  new ArrayList<String>();
        ArrayList<String> F2 = new ArrayList<String>();
        int n=0;
        
        while(n<lista.size()){
            while(lista.get(n).compareTo(lista.get(n+1))<=0){
            F1.add(lista.get(n));
            n++;
            }
        }F1.add(lista.get(n));n++;
        while(lista.get(n).compareTo(lista.get(n+1))<=0){
            F2.add(lista.get(n));
            n++;
        }F2.add(lista.get(n));
        
        /*
        for(int i=0; i<lista.size()-1;i++){
            if((lista.get(i).compareTo(lista.get(i+1))<=0))
                F1.add(lista.get(i));
            else if((lista.get(i).compareTo(lista.get(i+1))>0))
                F1.add(lista.get(i));
            if((lista.get(i+1).compareTo(lista.get(i+2))<=0))
                F2.add(lista.get(i+1));
        }
        */
        System.out.println("F1:");
        for(String s:F1){
            System.out.println(s);
        }
        System.out.println("F2:");
        for(String s:F2){
            System.out.println(s);
        }
        
        return lista;
    }
    
    static int[] StringAInt(ArrayList<String> lista){
        int [] listaInt = new int[lista.size()];
        int k=0;
        Integer valorDeCadena;
        for(String s:lista){
            valorDeCadena=0;
            for(int i=0;i<1;i++) {
                valorDeCadena+= Character.getNumericValue(s.charAt(i));
            }
            mapa.put(String.valueOf(valorDeCadena), s);
            listaInt[k] = valorDeCadena;
            k++;
        }
        return listaInt;
    }
    
    static BufferedWriter crearArchivos(int digito, String direccion){
        File iteracion=new File(direccion+"\\Iteraciones_MEZCLA_EQUILIBRADA.txt");
        
        try{
           switch(digito){
               case 1:
                    BufferedWriter escritoIteracion=new BufferedWriter(new FileWriter(iteracion,true));
                    return escritoIteracion;
               default:
                   break;
           }
        }catch(Exception e){
            System.out.println("No se pudo abrir el archivo");
        }
        return null;
    }
}