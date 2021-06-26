/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;
import java.util.*; 
/**
 *
 * @author vince
 */
public class Week3 {
    
    public static void clrscr(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Scanner centsu = new Scanner(System.in);
        int gas, choose;
        
        gas = 100;
        
        do{
            clrscr();
            System.out.println("\nYour gasoline's car: " + gas +" liters");
            System.out.println("========================================");
            System.out.println("1. Start driving");
            System.out.println("2. Rest");
            System.out.println("3. Exit");
            
            System.out.print("\nChoose: ");
            choose = centsu.nextInt(); 
            
            switch (choose){
                case 1 :{
                    if (gas == 0)
                        System.out.println("Your gasoline is not enough to run the car..");
                    else if (gas < 40){ 
                        //APABILA GAS DIBAWAH 40 MAKA TIDAK AKAN BISA SPEED DIATAS 50 KARENA GAS TIDAK CUKUP
                        System.out.println("Your car speed can't above 50 km/hour");
                        
                        int speed = (int)(Math.random()*(50-1+1)+1); //SPEED LIMIT MAX AKAN 50
                        System.out.println("Your car speed : " + speed +" km/hour");
                        
                        gas = gas - 20;
                        System.out.println("You have spent 20 liters gasoline");
                    }
                    else {
                        int speed = (int)(Math.random()*(100-1+1)+1);
                        System.out.println("Your car speed : " + speed +" km/hour");
                        
                        if (speed>=50){
                            gas = gas - 40;
                            System.out.println("You have spent 40 liters gasoline");
                        }
                        else {
                            gas = gas - 20;
                            System.out.println("You have spent 20 liters gasoline");
                        }
                    }
                    
                    System.out.print("\nPress enter to return to main menu...");
                    centsu.nextLine();
                    centsu.nextLine();
                    //char ch = (char) System.in.read(); //INI UNTUK KEY ENTER
                    break;
                }
                case 2 :{
                    if (gas == 100)
                        System.out.println("Your gasoline is FULL...");
                    else{
                        gas = gas + 20;
                        System.out.println("Successfully recharge 20 liters gasoline...");
                    }
                    
                    System.out.print("\nPress enter to return to main menu...");
                    centsu.nextLine();
                    centsu.nextLine();
                    //char ch = (char) System.in.read(); //INI UNTUK KEY ENTER
                    break;
                }
                case 3 :{
                    break;
                }
            }
        }while (choose != 3);
        
    }
    
}
