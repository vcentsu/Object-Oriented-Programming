/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;
import java.util.*; 
/**
 *
 * @author vince
 */
public class Week1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner centsu = new Scanner(System.in);
        int pilih, pizza, p1=0, p2 =0, lanjut, price, bayar, change;
        
        do {
            System.out.println("\nWelcome to Yummy Delivery Pizza: ");
            System.out.println("1. Order Pizza");
            System.out.println("2. Pay");
            System.out.println("3. Exit");
        
        
            System.out.println("Masukkan pilihan : ");
            pilih = centsu.nextInt(); 
        
        
            
            switch(pilih){
                case 1: {
                    System.out.println("Choose an order: ");
                    System.out.println("1. Meat Lover Pizza (@ Rp. 80000,-)");
                    System.out.println("2. Vegetarian Pizza (@ Rp. 50000,-)");

                   
                    do{
                        do {
                            System.out.println("Pilih pizza untuk diorder [1-2]: ");
                            pizza = centsu.nextInt();
                        }while (pizza != 1 && pizza != 2);

                        if (pizza == 1) 
                            p1++;
                        else if (pizza == 2)
                            p2++; 

                        System.out.println("Lanjut order ? 1. Yes 2. No ");
                        lanjut = centsu.nextInt();
                    }while (lanjut == 1);

                    System.out.println("Thankyouuuu!!");
                    break;
                }
            
                case 2 : {
                    if (p1==0 && p2==0)
                        System.out.println("You are not buy anything...");
                    else
                        System.out.println("You have ordered " + p1 + " Meat Lover Pizza and " + p2 + " Vegetarian Pizza");
                    
                    price = (p1 * 80000) + (p2 * 50000);
                    System.out.println("Total Price : Rp. " + price);
                    
                    do {
                        System.out.println("Input your money [minimum Rp. " + price + "]: Rp. ");
                        bayar = centsu.nextInt();  
                    }while (bayar<price);
                    
                    change = bayar - price;
                    if (change != 0)
                        System.out.println("Your change :Rp. " + change);
                    
                    System.out.println("Thankyouuuu!!");
                    break;
                }
                
                case 3:
                    break;
            }
            
        }while (pilih !=3);
    }
    
}
