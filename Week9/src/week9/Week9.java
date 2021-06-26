/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

/**
 *
 * @author vince
 */
public class Week9 {
    public static Scanner centsu = new Scanner(System.in);
    public static ArrayList <Animal> animal = new ArrayList<>();
    public static int nowcan=0, maxcan=0, nowfel=0, maxfel=0, count=0; 

    public static void beginning(){
//        System.out.println(" ______       __       ______    ______    ______    ");
//        System.out.println("/\  == \     /\ \     /\___  \  /\  __ \  /\  __ \   ");
//        System.out.println("\ \  __<    _\_\ \    \/_/  /__ \ \ \/\ \ \ \ \/\ \  ");
//        System.out.println(" \ \_____\ /\_____\     /\_____\ \ \_____\ \ \_____\ ");
//        System.out.println("  \/_____/ \/_____/     \/_____/  \/_____/  \/_____/ ");
    }
    
    public static void menu(){
        System.out.println();
        System.out.println("+=======================+");
        System.out.println("+       MENU LIST       +");
        System.out.println("+=======================+");
        System.out.println("+ 1. Add Zoo Animal     +");
        System.out.println("+ 2. View Zoo Animal    +");
        System.out.println("+ 3. Take For A Walk    +");
        System.out.println("+ 4. Release Zoo Animal +");
        System.out.println("+ 5. Close Program      +");
        System.out.println("+=======================+");
        System.out.print("Choice [1-5] >> ");
    }
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here 

        int choice;
        
        beginning();
        //LOAD FILE TXT
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.txt"));
        animal = (ArrayList<Animal>) in.readObject();
        do{
            
            
            menu();
            choice = centsu.nextInt();
            centsu.nextLine();
            
            System.out.println("");
            switch(choice){
                case 1: {
                    addAnimal();
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 2: {
                    viewAnimal();
                    System.out.print("Press ENTER to continue . . .");
                    centsu.nextLine();
                    break;
                }
                
                case 3: {
                    walkAnimal();
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 4: {
                    releaseAnimal();
                    System.out.print("Press ENTER to continue . . .");
                    centsu.nextLine();
                    break;
                }
                
                case 5:{
                    save();
                    break;
                }
             }
            
        }while(choice!=5);
    }
    
    public static void addAnimal() throws FileNotFoundException, IOException{
        String name, gender, genus;
        int speed=0;
        
        do{
            System.out.print("What's the name [5-15 characters]? ");
            name = centsu.nextLine();
        }while (name.length()<5 || name.length()>15);
        
        do{
            System.out.print("What's its gender [male|female]? ");
            gender = centsu.nextLine();
        }while (!gender.equals("male") && !gender.equals("female"));
        
        do{
            System.out.print("What's its genus [canine|feline]? ");
            genus = centsu.nextLine();
        }while (!genus.equals("canine") && !genus.equals("feline"));
        
        if (genus.equals("canine")){ 
            do{
                System.out.print("What's its speed [1 - 80]? ");
                try {
                    speed = centsu.nextInt();
                } catch (Exception e) {
                    System.out.println("Input must be numeric");
                    centsu.nextLine();
                }
            }while (speed<1 || speed>80);
            
            Canine can = new Canine(name,gender,genus,speed);
            animal.add(can);
            
            nowcan++;
            maxcan++;
                    
        }else{
            Feline fel = new Feline(name,gender,genus);
            animal.add(fel);
            
            nowfel++;
            maxfel++;
        }
        
        mood();
        viewAnimal();
        System.out.print("\nAnother animal has joined the zoo!!" + count);
        count++;
        //ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.txt"));
        //out.writeObject(animal);
    }
    
    public static void mood(){
        String mood = null;
        for (int i=0;i<animal.size();i++) {
            if (animal.get(i).getGenus().equals("canine")) {
                if (nowcan == 1 && maxcan == 1) {
                    mood = "happy";
                } else if (nowcan < maxcan) {
                    mood = "happy";
                } else {
                    mood = "unhappy";
                }
            } else if (animal.get(i).getGenus().equals("feline")) {
                if (nowfel == 1 && maxfel == 1) {
                    mood = "unhappy";
                } else if (nowfel < maxfel) {
                    mood = "unhappy";
                } else {
                    mood = "happy";
                }
            }
            animal.get(i).setMood(mood);
        }
    }
    
    public static void viewAnimal(){
        System.out.println("+=========================================================+");
        System.out.println("+ No. | Name             | Genus    | Mood       | Gender +");
        System.out.println("+=========================================================+");
        
        if (animal.isEmpty()){
            System.out.println("+             There is No Zoo Animal Spotted              +");
        }else{
            for(int i=0;i<animal.size();i++)
            {
                System.out.printf("+ %2d. | %-16s | %-8s | %-10s | %-6s |\n",i+1,animal.get(i).getName()
                        ,animal.get(i).getGenus(),animal.get(i).getMood(),animal.get(i).getGender());
            }
        }
        System.out.println("+=========================================================+");
    }
    
    public static void walkAnimal(){
        int pilih=0;

        if(animal.isEmpty()){
            viewAnimal();
        }
        if(!animal.isEmpty()){
            do{
                viewAnimal();
                System.out.print("Choose animal to take for a stroll [1 - " + animal.size() + "]? ");
                try {
                    pilih = centsu.nextInt();
                } catch (Exception e) {
                    System.out.println("Input must be numeric");
                    centsu.nextLine();
                }
            }while (pilih<1 || pilih>animal.size());
            
            int time=0;
            do{
                System.out.print("Input roaming time [0-50]: ");
                try {
                    time = centsu.nextInt();
                } catch (Exception e) {
                    System.out.println("Input must be numeric");
                    centsu.nextLine();
                }
            }while (time<0 || time>50);
            
            if (animal.get(pilih-1).getGenus().equals("canine")) {
                if(time==0){
                    time = 60;
                }
                animal.get(pilih-1).setRoamingTime(time);
                animal.get(pilih-1).roam();
            }else if (animal.get(pilih-1).getGenus().equals("feline")){
                if(time==0){
                    time = 30;
                }else{
                    time = time/2;
                }
                animal.get(pilih-1).setRoamingTime(time);
                
                int rnd = ThreadLocalRandom.current().nextInt(0, 1 + 1);
                if(rnd==0){
                    System.out.println("Feline " + animal.get(pilih-1).getName() 
                            + " doesn't feel like roaming at all today....");
                }else{
                    animal.get(pilih-1).roam();
                }
            }
        }
    }
    
    public static void releaseAnimal(){
        int pilih=0;

        if(animal.isEmpty()){
            viewAnimal();
        }else if(animal.size()==1){
            System.out.println("Can't release if animal less than 2 ");
        }else if(!animal.isEmpty()){
            do{
                viewAnimal();
                System.out.print("Choose animal to take for a stroll [1 - " + animal.size() + "]? ");
                try {
                    pilih = centsu.nextInt();
                } catch (Exception e) {
                    System.out.println("Input must be numeric");
                    centsu.nextLine();
                }
            }while (pilih<1 || pilih>animal.size());
            
            int rnd;
            do{
                rnd = ThreadLocalRandom.current().nextInt(1, animal.size() + 1);
                //System.out.println(rnd);
            }while(rnd==pilih); 
            //ADANYA PERULANGAN PADA RANDOM AGAR RND TIDAK SAMA DENGAN PILIHAN USER
            
            if (animal.get(pilih-1).getGenus().equals("canine") && animal.get(rnd-1).getGenus().equals("canine")){
                if (!animal.get(pilih-1).getGender().equals(animal.get(rnd-1).getGender())){
                    animal.get(pilih-1).makeSound(1);
                    if(pilih>rnd){
                        animal.remove(pilih-1);
                        animal.remove(rnd-1);
                    }else{
                        animal.remove(rnd-1);
                        animal.remove(pilih-1);
                    }
                }else{
                    animal.get(pilih-1).makeSound();
                    animal.remove(pilih-1);
                }
            }else if( animal.get(pilih-1).getGenus().equals("feline") && animal.get(rnd-1).getGenus().equals("feline")){
                if (!animal.get(pilih-1).getGender().equals(animal.get(rnd-1).getGender())){
                    animal.get(pilih-1).makeSound(1);
                    if(pilih>rnd){
                        animal.remove(pilih-1);
                        animal.remove(rnd-1);
                    }else{
                        animal.remove(rnd-1);
                        animal.remove(pilih-1);
                    }
                }else{
                    animal.get(pilih-1).makeSound();
                    animal.remove(pilih-1);
                }
            }else{
                System.out.println("Different Genus can't be release");
            }
        }
    }
    
    public static void save() throws IOException{
//        File file = new File("out.txt");
//        FileWriter fw = new FileWriter(file);
//        PrintWriter pw = new PrintWriter(fw);
//        
//        pw.println(count);
//        for(int i=0;i<count;i++){
//            pw.println(animal.get(i).getName());
//            pw.println(animal.get(i).getGender());
//            pw.println(animal.get(i).getGenus());
//            pw.println(animal);
//        }
//        
//        pw.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.txt"));
        out.writeObject(animal);
        
        
    }
}
