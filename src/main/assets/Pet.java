package main.assets;

abstract class Pet{
    int hunger, happiness, age, sleepiness, health;
    public abstract void sleep();
    public abstract void feed();
    public abstract void cure();
    public abstract void play();
    public abstract void noise();
}
