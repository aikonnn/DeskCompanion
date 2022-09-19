package main.assets;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;


public class Cat extends Dog {
    GamePanel gp;
    KeyHandler keyH;
    MouseHandler mouseH;

    public Cat(GamePanel gp, KeyHandler keyH, MouseHandler mouseH)
    {
        super(gp, keyH, mouseH);
        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        setDefault();
    }

    @Override
    public void setDefault() {
        // TODO Auto-generated method stub
        super.setDefault();
        this.speed = 1;
        this.hunger = 10;
        this.MAX_HUNGER = 50;
        this.hunger_rate = 600;
        this.lifetime = 0;
    }
}
