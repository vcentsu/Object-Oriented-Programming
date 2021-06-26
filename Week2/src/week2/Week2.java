/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;
import java.util.*; 
/**
 *
 * @author vince
 */


public class Week2 {
    
    public static String right(String value, int length) {
        return value.substring(value.length() - length);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner centsu = new Scanner(System.in);
        int choice, mathChoice;
        
        do {
            System.out.println("\nSUBJECT ");
            System.out.println("======= ");
            System.out.println("1. Mathematics");
            System.out.println("2. English");
            System.out.println("3. Exit");
        
        
            System.out.print("\nChoice: ");
            choice = centsu.nextInt(); 

            switch(choice){
                case 1: {
                    System.out.println("\nMATH MENU ");
                    System.out.println("========= ");
                    System.out.println("1. Calculate circle area");
                    System.out.println("2. Calculate rectangle area");

                    do {
                        System.out.print("\nChoice: ");
                        mathChoice = centsu.nextInt(); 
                    }while (mathChoice != 1 && mathChoice != 2);

                    if (mathChoice == 1){
                        double areaCircle;
                        String type;
                        do{
                            System.out.print("\nChoose input type[Radius|Diameter](Case Sensitive):");
                            type = centsu.next();
                        }while (type.compareTo("Radius")!=0 && type.compareTo("Diameter")!=0 && type.compareTo("radius")!=0 && type.compareTo("diameter")!=0);

                        double number = (double)(Math.random()*(100-1+1)+1);

                        if (type.compareTo("Radius")==0 || type.compareTo("radius")==0){
                            areaCircle = Math.PI * Math.pow(number,2);
                            System.out.println("The generated radius value is " + number);
                            System.out.println("The area of the circle is " + areaCircle );
                        }
                        else {
                            float jari;
                            jari = (float)(number / 2);
                            areaCircle = Math.PI * Math.pow(jari,2);
                            System.out.println("The generated radius value is " + number);
                            System.out.println("The area of the circle is " + areaCircle);
                        }
                    }
                    else {
                        int width, length, areaRectangle;
                        String rectangle;

//                        System.out.print("Input Width : ");
//                        width = centsu.nextInt();
//                        System.out.print("Input Length : ");
//                        length = centsu.nextInt();
                        
                        System.out.print("\n");
                        do{
                            System.out.print("Input Width and Length[format: Width[1]xLength[1]]: ");
                            rectangle = centsu.next();
                        }while (!rectangle.matches("\\d{1}x\\d{1}"));
                        
                        String[] sp = rectangle.split("x");
                        width = Integer.parseInt(sp[0]);
                        length = Integer.parseInt(sp[1]);

                        areaRectangle = width * length;
                        System.out.println("The area of the rectangle is " + areaRectangle);
                    }

                    System.out.print("\nPress enter key to continue...");
                    char ch = (char) System.in.read(); //INI UNTUK KEY ENTER
                    break;
                }

                case 2: {
                    int len;
                    boolean cek;
                    String word;
                    
                    centsu.nextLine();
                    System.out.print("\n");
                    do {
                        cek = true;
                        System.out.print("Input word[only 1 word | must only be alphabeth]: ");
                        word = centsu.nextLine();
                        
                        //PILIH SALAH SATU BISA 
                        len = word.length();
                        for (int i=0; i<len; i++){
                            if (!Character.isLetter(word.charAt(i))){
                                cek = false;
                            }
                        }
                        //ATAU
                        //cek = word.chars().allMatch(Character::isLetter);
                    }while (cek==false || word.contains(" "));
                    

                    String type;
                    do{
                        System.out.print("\nInput tenses type [Present|Past](Case Sensitive): ");
                        type = centsu.next();
                    }while(type.compareTo("Present")!=0 && type.compareTo("Past")!=0);

                    System.out.println("======================"); 
                    len = word.length();
                    if (type.compareTo("Present")==0){
                        if (right(word,2).compareTo("es")==0 || right(word,1).compareTo("s")==0){
                            System.out.println(word + " is a plural word");
                            System.out.println("It contains of " + len + " character(s)");
                        }
                        else {
                            System.out.println(word + " is a singular/not a plural word");
                            System.out.println("It contains of " + len + " character(s)");
                        }
                    }
                    else {
                        if (right(word,2).compareTo("ed")==0 || right(word,1).compareTo("d")==0){
                            System.out.println(word + " is regular word");
                            System.out.println("It contains of " + len + " character(s)");
                        }
                        else {
                            System.out.println(word + " is irregular word");
                            System.out.println("It contains of " + len + " character(s)");
                        }
                    }

                    System.out.print("\nPress enter key to continue...");
                    char ch = (char) System.in.read();
                    break;
                }


                case 3: break;
            }
        }while(choice!=3);
        
    }  
}
