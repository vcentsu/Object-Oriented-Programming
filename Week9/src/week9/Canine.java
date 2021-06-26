/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;

/**
 *
 * @author vince
 */
public class Canine extends Animal{
    private int walk_speed;
    
    public Canine(String name, String gender, String genus, int speed){
        super(name,gender,genus);
        this.walk_speed = speed;
    }
    
    public int getSpeed(){
        return walk_speed;
    }
    
    public void setSpeed(int speed){
        this.walk_speed = speed;
    }
    
    @Override 
    public void roam(){
        int total_range;
        total_range = (int)(super.roamingTime * walk_speed);
        System.out.print("Roaming for total range of " + total_range + " in " + super.roamingTime + " minutes");
    }
    
    @Override
    public void makeSound(int x){
        System.out.println("ruff ruff <3");
    }
    
    @Override
    public void makeSound(){
        System.out.println("awooo!!");
    }
}
