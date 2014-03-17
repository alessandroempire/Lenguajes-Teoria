/**
* Tarea 1 de teoria, pregunta C
**/
import java.util.*;
import java.io.*;
import java.lang.Math;

public class BuddySystem {

    public int Capacidad;
    public List buddies[];
    public List lista;
    
    public BuddySystem(int cap){
        Capacidad = cap;
        int i = log2 (cap), aux = cap, address = 0;
        buddies = new List [i];
        while (aux > 0) {
            buddies[i-1] = new ArrayList();
            buddies[i-1].add(address);
            aux -= (int) Math.pow(2,i); //2^i
            address += (int) Math.pow(2,i) + 1;
            i = log2(aux);
        }
    }

    public int log2(int a){
       return (int) (Math.log(a)/Math.log(2));
    }

    public int getCapacidad(){
        return Capacidad;
    }

    public static void main (String[] args) {
        
        System.out.println("Prueba");

        BuddySystem buddy = new BuddySystem(3000);

        for (int i = 0; i < buddy.buddies.length; i++){
            System.out.println(buddy.buddies[i]);
        }
        
    }
}




