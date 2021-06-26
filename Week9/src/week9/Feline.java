/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author vince
 */
public class Feline extends Animal {
    private int walk_speed = ThreadLocalRandom.current().nextInt(1, 80 + 1);
    
    public Feline(String name, String gender, String genus){
        super(name,gender,genus);
    }
    
    public int getSpeed(){
        return walk_speed;
    }
    
    public void setSpeed(int speed){
        this.walk_speed = speed;
    }
    
    @Override 
    public void roam(){
        double total_range;
        total_range = (float)(super.roamingTime * walk_speed);
        System.out.print("Roaming for total range of " + total_range + " in " + super.roamingTime + " minutes");
    }
    
    @Override
    public void makeSound(int x){
        System.out.println("meow meow <3");
    }
    
    @Override
    public void makeSound(){
        System.out.println("hiss!!");
    }
}
