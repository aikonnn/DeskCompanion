package main.assets;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;

import java.awt.Graphics2D;
import java.awt.Color;

public class Dog extends Pet{
    GamePanel gp;
    KeyHandler keyH;
    MouseHandler mouseH;

    public Dog(GamePanel gp, KeyHandler keyH, MouseHandler mouseH)
    {
        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        setDefault();
    }

    public void setDefault(){
        this.x = 100;
        this.y = 100;
        this.speed = 2;
    }

    public void update(){
        if(mouseH.targetX != x || mouseH.targetY != y){

            if(mouseH.targetX > x) {
                if(mouseH.targetX - x == 1) x +=1;
                else x+=speed;
            }
            else if(mouseH.targetX < x) {
                if(mouseH.targetX - x == -1) x -=1;
                else x-=speed;
            }

            if(mouseH.targetY > y) {
                if(mouseH.targetY - y == 1) y +=1;
                else y+=speed;
            }
            else if(mouseH.targetY < y) {
                if(mouseH.targetY - y == -1) y-=1;
                else y-=speed;
            }
        }
    }

    public void paintComponent(Graphics2D g2){
        
        g2.setColor(Color.BLACK);

        g2.fillRect(x,y,gp.finalTileSize,gp.finalTileSize);
    }
}