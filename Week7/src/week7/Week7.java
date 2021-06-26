/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;
import java.util.*;

/**
 *
 * @author vince
 */
class cake{
    private String cakeFlavor;
    private String cakeTopping;
    private int cakeFlour;
    private int cakeSugar=100;
    private boolean cakeStatus=false;

    public cake(String flavor, String topping, int flour) {
            this.cakeFlavor = flavor;
            this.cakeTopping = topping;
            this.cakeFlour = flour;
    }

    public void makeDough() {
            System.out.println("\nMixing " + this.cakeFlavor + " flavor, " 
                                                    + this.cakeFlour + " gram of flour, "
                                                    + this.cakeSugar + " gram of sugar");
    }

    public void baking() {
            System.out.println("Baking the cake..");
            cakeStatus = true;
    }

    public void changeTopping(String topping) {
            this.cakeTopping = topping;

            System.out.println("The topping is changed!");
    }

    public void showCake() {
            System.out.println("Cake flavor: " + cakeFlavor);
            System.out.println("Cake flour: " + cakeFlour + " gram");
            System.out.println("Cake sugar: " + cakeSugar + " gram");
            System.out.println("Cake topping: " + cakeTopping);

            if(cakeStatus) System.out.println("The cake is already baked");
            else System.out.println("The cake has not been baked yet");
    }

    public boolean isBake() {
        return cakeStatus;
    }
    
    String getFlavor() {
        return cakeFlavor;
    }
    
    int getFlour() {
        return cakeFlour;
    }
    
    String getTopping() {
        return cakeTopping;
    }
   
    int getSugar() {
        return cakeSugar;
    }
}

public class Week7 {

    public static void menu(){
        System.out.print("+========================+\n");
        System.out.print("+      HOMEMADE CAKE     +\n");
        System.out.print("+========================+\n");
        System.out.print("+ 1. Add Cake to be Bake +\n");
        System.out.print("+ 2. Bake Cake           +\n");
        System.out.print("+ 3. Change Cake Topping +\n");
        System.out.print("+ 4. View Cake List      +\n");
        System.out.print("+ 5. Exit                +\n");
        System.out.print("+========================+\n");
        System.out.print("Choice [1-5] >> ");
    }
    
    static void showCake (ArrayList <cake> cakes, int size){
        for (int i=0; i<size; i++){
            System.out.println("\nCake number " + (i+1));
            System.out.println("=============");
            System.out.println("Cake flavor: " + cakes.get(i).getFlavor());
            System.out.println("Cake flour: " + cakes.get(i).getFlour());
            System.out.println("Cake sugar: " + cakes.get(i).getSugar());
            System.out.println("Cake topping: " + cakes.get(i).getTopping());

            if(cakes.get(i).isBake()== true){
                System.out.println("The cake is already baked");
            }else{
                System.out.println("The cake has not been baked yet");
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
   
        Scanner centsu = new Scanner(System.in);
        ArrayList <cake> cakes = new ArrayList<>();
        int choice;
        String cakeFlavor, cakeTopping;
        int cakeFlour=0;
        int size = 0;

        
        do{
            menu();
            choice = centsu.nextInt();
            
            switch (choice){
                case 1:{
                    do{
                        System.out.print("Choose cake flavor [Cheese|Chocolate|Vanilla](Case Sensitive): ");
                        cakeFlavor = centsu.next();
                    }while(!cakeFlavor.equals("Cheese") && !cakeFlavor.equals("Chocolate") && !cakeFlavor.equals("Vanilla"));
                    centsu.nextLine();
                   
                    do{
                        System.out.print("Input how many flour will be used (gram)[>0]: ");
                        try{
                            cakeFlour = centsu.nextInt();
                        }catch(Exception e){
                            System.out.println("Input must be numeric");
                            centsu.nextLine();
                        }
                    }while(cakeFlour<=0);
                    
                    
                    do{
                        System.out.print("Choose cake topping [Cream|Oreo](Case Sensitive): ");
                        cakeTopping = centsu.next();
                    }while(!cakeTopping.equals("Cream") && !cakeTopping.equals("Oreo"));
                    
                    System.out.println("\nThe cake is made");
                    
                    if(cakes.isEmpty()){
                        size = 1;
                    }else{
                        size = cakes.size() + 1;
                    }
                    
                    cake kue = new cake(cakeFlavor, cakeTopping, cakeFlour);
                    cakes.add(kue);
                    System.out.println(size + " cake(s) are in the list");
                    
                    System.out.print("\nPress ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 2:{
                    int pilih;
                    
                    if (cakes.isEmpty()==true){
                        System.out.println("“There is no cake that has been made yet!");
                    }else{
                        showCake(cakes,size);
                        System.out.println("");
                        
                        do{
                            System.out.print("Input cake number[1.." + size+"]: ");
                            pilih = centsu.nextInt();
                        }while(pilih<1 || pilih>size);
                        
                        cakes.get(pilih-1).makeDough();
                        cakes.get(pilih-1).baking();
                    }
                    
                    System.out.print("\nPress ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 3:{
                    int pilih;
                    
                    if (cakes.isEmpty()==true){
                        System.out.println("“There is no cake that has been made yet!");
                    }else{
                        showCake(cakes,size);
                        System.out.println("");
                        
                        do{
                            System.out.print("Input cake number[1.." + size+"]: ");
                            pilih = centsu.nextInt();
                        }while(pilih<1 || pilih>size);
                        
                        do{
                            System.out.print("Input your new cake topping [Cream|Oreo](Case Sensitive): ");
                            cakeTopping = centsu.next();
                        }while(!cakeTopping.equals("Cream") && !cakeTopping.equals("Oreo"));
                        
                        cakes.get(pilih-1).changeTopping(cakeTopping);
                    }
                    
                    System.out.print("\nPress ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 4:{
                    if (cakes.isEmpty()==true){
                        System.out.println("“There is no cake that has been made yet!");
                    }else{
                        showCake(cakes,size);
                    }
                    
                    System.out.print("\nPress ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 5:{
                    break;
                }
            }
            
        }while(choice!=5);
    }
    
}