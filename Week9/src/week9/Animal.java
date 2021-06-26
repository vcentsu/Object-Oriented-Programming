/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;

import java.io.Serializable;

/**
 *
 * @author vince
 */
public class Animal implements Serializable{
    
    String gender;
    String name;
    String genus;
    String mood;
    float roamingTime;

    public Animal() {}

    public Animal(String name, String gender, String genus) {
            super();
            this.gender = gender;
            this.name = name;
            this.genus = genus;
    }

    public void makeSound(int x) {
            System.out.println("animal: use growl!!");
    }
    
    public void makeSound() {
            System.out.println("animal: use growl!!");
    }

    public void selfComfort() {
            System.out.println("animal comforting themselves");
    }

    public void roam() {
            System.out.println("animal roams free");
    }
    
    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }
    
    public String getGender() {
            return gender;
    }

    public void setGender(String gender) {
            this.gender = gender;
    }
    
    public String getGenus(){
        return genus;
    }
    
    public void setGenus(String genus){
        this.genus = genus;
    }
    
    public String getMood() {
            return mood;
    }

    public void setMood(String mood) {
            this.mood = mood;
    }
    
    public void setRoamingTime(int time){
        this.roamingTime = time;
    }
        
    public float getRoamingTime(){
        return roamingTime;
    }
}
