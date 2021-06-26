/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;
import java.util.*;

/**
 *
 * @author vince
 */
public class Week6 {

    public static void beginning(){
        System.out.print(" _______       ___             _______   __   __   _______   ______     _______ \n");
        System.out.print("|  _    |     |   |           |       | |  | |  | |   _   | |   _  |   |       |\n");
        System.out.print("| |_|   |     |   |   ____    |  _____| |  |_|  | |  |_|  | |  | | |   |    ___|\n");
        System.out.print("|       |     |   |  |____|   | |_____  |       | |       | |  |_| |_  |   |___ \n");
        System.out.print("|  _   |   ___|   |           |_____  | |       | |       | |   __   | |    ___|\n");
        System.out.print("| |_|   | |       |            _____| | |   _   | |   _   | |  |  |  | |   |___ \n");
        System.out.print("|_______| |_______|           |_______| |__| |__| |__| |__| |__|  |__| |_______|\n\n");
    }
    
    public static void menu(){
        System.out.print("+=======================+\n");
        System.out.print("+        Options        +\n");
        System.out.print("+=======================+\n");
        System.out.print("+ 1. Start Sharing      +\n");
        System.out.print("+ 2. Update Participant +\n");
        System.out.print("+ 3. Delete Participant +\n");
        System.out.print("+ 4. Close App          +\n");
        System.out.print("+=======================+\n");
        System.out.print("Choice [1-4] >> ");
    }
    
    public static void headerShareList(){
        System.out.println("+===============================+");
        System.out.println("+           Share List          +");
        System.out.println("+===============================+");
    }
    
    public static void newHeaderShareList(){
        System.out.println("Here's the completed share list");
        System.out.println("Remember, sharing is caring, happy sharing :D");

        System.out.println("+=======================================+");
        System.out.println("+ Share List                            +");
        System.out.println("+=======================================+");
        System.out.println("+ Username      | Before    | After     +");
        System.out.println("+=======================================+");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        beginning();
        
        Scanner centsu = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        int choice;
        Character simpan;
        
        do{
            menu();
            choice = centsu.nextInt();
            
            switch (choice){
                case 1:{
                    int tempnumber=0,size;
                    String tempname; 
                    boolean check;
                    
                    do{   
                        try{
                            System.out.print("Input a number [0-100]: ");
                            tempnumber = centsu.nextInt();
                            check = true;
                        }catch (Exception e){
                            System.out.println("input must be numeric");
                            check = false;
                        }
                        if (Collections.frequency(number,tempnumber) != 0){
                            System.out.println("Number has already been taken!!");
                        }
                    }while(tempnumber>100 || tempnumber<0 || check == false || Collections.frequency(number,tempnumber) != 0);
                    centsu.nextLine();
                    
                    do{
                        System.out.print("Could you give me your username [5-20 characters]? ");
                        tempname = centsu.nextLine();
                        if (Collections.frequency(name,tempname) != 0){
                            System.out.println("Username has already been taken!!");
                        }
                    }while(tempname.length()<5 || tempname.length()>20 || Collections.frequency(name,tempname) != 0);
                    
                    do{
                        System.out.print("Apakah anda akan menyimpan [Y/T]: ");
                        simpan = centsu.next().charAt(0);
                    }while (!simpan.equals('Y') && !simpan.equals('y') && !simpan.equals('T') && !simpan.equals('t'));
                    
                    if (simpan.equals('Y') || simpan.equals('y')){
                        if(name.isEmpty()){
                            size = 1;
                        }else{
                            size = name.size() + 1;
                        }
                    
                        System.out.println("You are the " + size + " participant that joins the game");
                        System.out.println("Your share number : " + tempnumber + "\n");
                        
                        number.add(tempnumber);
                        name.add(tempname);
                        System.out.print("Successfully Added. ");
                    }
                    
                    System.out.print("Press ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    
                    break;
                }
                
                case 2:{
                    int no=1, participant=0, tempnumber=0;
                    boolean check;
                    
                    if(name.isEmpty()==true && name.isEmpty()==true){
                        System.out.println("There is no participant");
                     }else{
                        headerShareList();
                        for(int i=0; i<name.size(); i++){
                            System.out.printf("| %-3s | %-15s | %-5s |\n", no, name.get(i), number.get(i));
                            no++;
                        }
                        System.out.println("+===============================+");
                        
                        do{
                            try{
                                System.out.print("Which participant you would like to update [1 - "+ name.size() +"] [0 to exit] ? ");
                                participant = centsu.nextInt();
                                check = false;
                            }catch(Exception e){
                                System.out.println("Input must be numeric"); 
                                check = true;
                            }
                        }while(participant<0 || participant>name.size() || check==true);
                        centsu.nextLine();
                        
                        if(participant==0){
                            break;
                        }else{
                            do{
                                System.out.print("Input a number [0 - 100] : ");
                                tempnumber = centsu.nextInt();
                                if (Collections.frequency(number,tempnumber) != 0){
                                    System.out.println("Numberd has already been taken!!");
                                }
                            }while(tempnumber<0 || tempnumber>100 || Collections.frequency(number,tempnumber)!= 0);
                            
                            do{
                                System.out.print("Apakah anda akan menyimpan [Y/T]: ");
                                simpan = centsu.next().charAt(0);
                            }while (!simpan.equals('Y') && !simpan.equals('y') && !simpan.equals('T') && !simpan.equals('t'));
                            
                            if (simpan.equals('Y') || simpan.equals('y')){
                                number.set((participant-1), tempnumber);
                                System.out.print("Successfully Updated. ");
                            }   
                        }
                    }
                    
                    System.out.print("Press ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    
                    break;
                }
                
                case 3:{
                    int no=1, participant=0;
                    boolean check;
                    
                    if(name.isEmpty()==true && name.isEmpty()==true){
                        System.out.println("There is no participant");
                    }else{
                        headerShareList();
                        for(int i=0; i<name.size(); i++){
                            System.out.printf("| %-3s | %-15s | %-5s |\n", no, name.get(i), number.get(i));
                            no++;
                        }
                        System.out.println("+===============================+");
                        
                        do{
                            try{
                                System.out.print("Which participant you would like to delete [1 - "+ name.size() +"] [0 to exit] ? ");
                                participant = centsu.nextInt();
                                check = false;
                            }catch(Exception e){
                                System.out.println("Input must be numeric"); 
                                check = true;
                            }
                        }while(participant<0 || participant>name.size() || check==true);
                        centsu.nextLine();
                        
                        if(participant==0){
                            break;
                        }else{
                            name.remove(participant-1);
                            number.remove(participant-1);
                            System.out.print("Participant successfully removed from event.");   
                        }
                    }
                    
                    System.out.print("Press ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    
                    break;
                }
                
                case 4:{
                    if(name.isEmpty()==true && name.isEmpty()==true){
                        System.out.println("There is no participant");
                    }else{
                        ArrayList<Integer> newNumber = new ArrayList<>();
                        newNumber.addAll(number);
                        Collections.shuffle(newNumber);
                        
                        newHeaderShareList();
                        for(int i=0; i<name.size(); i++){
                            System.out.printf("| %-13s | %-9s | %-9s |\n",name.get(i), number.get(i), newNumber.get(i));
                        }
                        System.out.println("+=======================================+");
                        
                    System.out.print("Thankyou for your participating, see yaaa!!. Press ENTER to continue");
                    centsu.nextLine();
                    centsu.nextLine();
                    }
                    break;
                }
            }
            
        }while(choice!=4);


        
    }
    
}
