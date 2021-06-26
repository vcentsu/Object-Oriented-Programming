/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;
import java.util.*;

/**
 *
 * @author vince
 */
public class Week5 {

    public static void menu(){
        System.out.print("Binary Number Calculation\n");
        System.out.print("=========================\n");
        System.out.print("Main Menu: \n1. Binary Number \n2. Binary Number with step \n3. Exit \n");
    }
    
    public static void binary(int number){
        int nilai[];
        nilai = new int[10];
        int i=0;
        
        while (number>0){
            nilai[i++] = number%2;
            number = number/2;
        }
        for (int x=i-1; x>=0; x--){
            System.out.print(nilai[x]);
        }
        System.out.println();
    }
    
    public static void binaryStep(int number){
        int nilai[];
        nilai = new int[10];
        int i=0,temp=number;
        
        System.out.println("The result of Binary Number");
        while (number>0){
            nilai[i++] = number%2;
            System.out.print("Step "+i+": "+number+"/2, Remainder = "+number%2);
            number = number/2;
            System.out.println(", Quotient = "+number);
        }
        
        System.out.print(temp+ " in decimal = ");
        for (int x=i-1; x>=0; x--){
            System.out.print(nilai[x]);
        }
        System.out.println(" in binary");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner centsu = new Scanner(System.in);
        int pilih, number;
        
        do{
            menu();
            System.out.print("Pilih [1-3]: ");
            pilih = centsu.nextInt();
            
            switch (pilih){
                case 1: {
                    do{
                        System.out.print("\nInput the number [1-100]: ");
                        number = centsu.nextInt();
                    }while (number>100 || number<1);
                    
                    System.out.print("The result of Binary Number "+number+": ");
                    binary(number);
                    
                    System.out.print("\nPress ENTER to continue...");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 2: {
                    do{
                        System.out.print("\nInput the number [1-100]: ");
                        number = centsu.nextInt();
                    }while (number>100 || number<1);
                    
                    binaryStep(number);
                    
                    System.out.print("\nPress ENTER to continue...");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 3: {
                    System.out.print("\nThank you and have a nice day.. ^^");
                    break;
                }
            }
            
        }while(pilih!=3);
    }
    
}
