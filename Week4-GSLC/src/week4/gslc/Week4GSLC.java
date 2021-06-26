/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4.gslc;
import java.util.*;

/**
 *
 * @author vince
 */
public class Week4GSLC {
    
    public static void menu(){
        System.out.print("Main Menu: \n1. Input Paragraf \n2. Tambah Paragraf \n3. Lihat Paragraf \n4. Cari Kata \n5. Exit \n");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner centsu = new Scanner(System.in);
        int choose;
        String paragraf="", temp, cariKata;
        Character simpan;
        
        do{
            menu();
            System.out.print("\nChoose: ");
            choose = centsu.nextInt();
            
            
            switch (choose){
                case 1: {
                    System.out.println("Silahkan masukkan paragraf: ");
                    centsu.nextLine();
                    temp = centsu.nextLine();
                    
                    do{
                        System.out.print("Apakah anda akan menyimpan [Y/T]: ");
                        simpan = centsu.next().charAt(0);
                    }while (!simpan.equals('Y') && !simpan.equals('T'));
                    
                    if (simpan.equals('Y')){
                        paragraf = temp;
                    }
                    break;
                }
                
                case 2: {
                    System.out.println("Paragraf yang sudah anda input: \n" + paragraf);
                    System.out.println("\nSilahkan tambahkan kedalam paragraf: ");
                    centsu.nextLine();
                    temp = centsu.nextLine();
                    
                    do{
                        System.out.print("Apakah anda akan menyimpan [Y/T]: ");
                        simpan = centsu.next().charAt(0);
                    }while (!simpan.equals('Y') && !simpan.equals('T'));
                    
                    if (simpan.equals('Y')){
                        paragraf = paragraf.concat(" " + temp);
                    }
                    break;
                }
                
                case 3: {
                    System.out.println(paragraf);
                    
                    System.out.print("\nTekan enter untuk kembali ke main menu...");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 4: {
                    String kata[] = paragraf.split(" ");
                    
                    System.out.print("Masukkan kata yang akan dicari: ");
                    cariKata = centsu.next();
                    
                    int banyak = 0;
                    for (int i=0; i<kata.length;i++) {
                        if (cariKata.equals(kata[i])) {
                            banyak++;
                        }
                    }
                    System.out.print("Hasil: \nKata " + cariKata +" sebanyak " + banyak + " kali. \n");
                    
                    int x = 1;
                    for (int i=0; i< kata.length; i++){
                        if (cariKata.equals(kata[i])){
                            System.out.println("\n" + cariKata + " " + x);
                            if (i-1 > 0)
                                System.out.println("Kata sebelumnya : " + kata[i-1]);
                            else
                                System.out.println("Kata sebelumnya tidak ada.");
                           
                            if (i+1 < kata.length)
                                System.out.println("Kata setelahnya : " + kata[i+1]);
                            else
                                System.out.println("Kata setelahnya tidak ada.");
                            x++;
                        } else 
                            System.out.println("Kata tidak ditemukan dalam paragraf.");
                    }      
                    
                    System.out.print("\nTekan enter untuk kembali ke main menu...");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 5: {
                    break;
                }
                
            }
        }while(choose != 5);
    }
}
