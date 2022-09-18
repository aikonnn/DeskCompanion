package main.assets;

public class Dog extends Pet{
    public Dog(){
        this.hunger = 20;
        this.happiness = 30;
        this.age = 20;
        this.sleepiness = 50;
        this.health = 100;
    }

    public void noise(){
        System.out.println("Woof!");
    }

    public void sleep(){
        this.sleepiness = 30;
    }

    public void feed(){
        this.hunger += 10;
    }

    public void cure(){
        this.health = 100;
    }

    public void play(){
        this.happiness+= 20;
        noise();
    }
}
