/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.pkgclass;
import java.util.*;

/**
 *
 * @author vince
 */
public class Week4Class {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner centsu = new Scanner(System.in);
        
        //Romawi IV. Nomor 2
        String paragraf, temp; 
        System.out.println("Masukkan paragraf: ");
        paragraf = centsu.nextLine();
        
        temp = paragraf.toLowerCase();
        temp = temp.replaceAll("[^a-z ]","");
        
        System.out.println("\n" + temp);
        
        String kata[] = temp.split(" ");
        //String kataBanding[] = null;
        
        System.out.println("\nJumlah kata :");
        int banyak, prnt=0;
        for (int i=0; i<kata.length; i++){
            banyak=0;
            for (int x=0; x<kata.length; x++){
                if (kata[i].equals(kata[x])){
                    banyak++;
                }
            }
            if (banyak==1)
                System.out.println(kata[i] + " : " + banyak);
            else if ((banyak>1) && (prnt!=1)){
                System.out.println(kata[i] + " : " + banyak);
                prnt++; //ini untuk menjaga agar tidak ter print lebih dari sekali.
            } 
        }
    }
    
}
