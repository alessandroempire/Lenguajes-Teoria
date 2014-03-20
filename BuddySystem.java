/**
* Tarea 1 de teoria, pregunta C
**/
import java.util.*;
import java.io.*;
import java.lang.Math;

public class BuddySystem {

    private int Capacidad;
    private List Buddies[];

    //Definimos Tipo Tuplas
    private class Tuplas {
        private int inic;
        private int fin;
        
        public Tuplas(int x, int y) {
            inic = x;
            fin = y;
        }
        
        public int getInic(){
            return inic;
        }

        public int Memory(){
            return Math.abs(inic - fin);
        }

        public void reduce(int newIni){
            inic = newIni+1;
        }
        
        public void printTuplas(){
            System.out.println("Inicial " + inic + " Final " + fin);
        }
    }
    
    //Constructor del BuddySystem
    public BuddySystem(int cap){
        Capacidad = cap;
        int i = log2 (cap);
        Tuplas tupla = new Tuplas(0,cap-1);
        if (cap <= Math.pow(2,i)){
            Buddies = new List[i];
            Buddies[i-1] = new ArrayList();
            Buddies[i-1].add(tupla);
        }
        else {
            Buddies = new List[i+1];
            Buddies[i] = new ArrayList();
            Buddies[i].add(tupla);
        }
    }
    
    //Funcion que reserva un bloque de memoria
    public int reservar(int cap){
        if (cap > Capacidad)
            return -1;
        
        int pos = log2(cap)-1;
        
        for (; pos < Buddies.length;){
            if (Buddies[pos] == null)
                pos += 1;
            else if (Buddies[pos].isEmpty())
                pos += 1;
            else{
                int length = Buddies[pos].size();
                for (int i = 0; i < length; i++){
                    Tuplas t = (Tuplas) Buddies[pos].get(i);
                    if (t.Memory() > cap){
                        Buddies[pos].remove(i);
                        int address = t.getInic(); 
                        t.reduce(cap);
                        addTuplas(t);
                        return address;
                    }
                }
                pos += 1; 
            }
        }
        
        return -1; 
    }
    
    //Funcion que agrega una tupla en el arreglo
    public void addTuplas(Tuplas t){
        int mem = t.Memory();
        int i = log2(mem);
        if (mem <= Math.pow(2,i)){
            if (Buddies[i-1] == null)
                Buddies[i-1] = new ArrayList();
            Buddies[i-1].add(t);
        }
        else {
            if (Buddies[i] == null)
                Buddies[i] = new ArrayList();
            Buddies[i].add(t);
        }
    }
    
    //Funcion que calcula el logaritmo de a
    private int log2(int a){
        return (int) (Math.log(a)/Math.log(2));
    }

    //Funcion que imprime el arreglo
    public void imprimirBuddies(){
        for (int i = 0; i < Buddies.length; i++) {
            if (Buddies[i] == null)
                System.out.println("pos " + i + " " + Buddies[i]);
            else{
                if (Buddies[i].isEmpty())
                    System.out.println("pos " + i + " Vacio");
                else {
                    Object array[] = Buddies[i].toArray();
                    for (int j = 0; j < array.length; j++){
                        Tuplas t = (Tuplas) array[j];
                        System.out.print("pos " + i + " ");
                        t.printTuplas();
                    }
                }
            }      
        }
    }
    
    //Clase para probar casos
    public static void main (String[] args) {
        
        System.out.println("Prueba del buddySystem");
        
        BuddySystem b = new BuddySystem(1025);
        
        b.reservar(1000);
        
        b.imprimirBuddies();
    }
        
}
