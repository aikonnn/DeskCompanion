package main;

import main.assets.Dog;
import main.assets.Cat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    final int tileSize = 16; 
    final int scale = 3;

    public final int finalTileSize = tileSize*scale;
    final int maxScreenCol = 8;
    final int maxSceenRow = 6;
    final int screenWidth = finalTileSize * maxScreenCol;
    final int screenHeight = finalTileSize * maxSceenRow;

    //FPS
    int FPS = 60;

    Thread gameThread; 
    MouseHandler mouseH = new MouseHandler();
    KeyHandler keyH = new KeyHandler();

    Cat pet = new Cat(this, keyH, mouseH);//init as dog for prototyping


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.ORANGE);
        this.setDoubleBuffered(true); //drawing component in offscreen buffer
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.setFocusable(true);//gamePanel can be focused to receive input

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS; //deltaTime in nanoseconds
        double deltaTime = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            
            currentTime = System.nanoTime();

            deltaTime += (currentTime - lastTime)/drawInterval;

            lastTime = currentTime;

            if(deltaTime >=1){
                
                //UPDATE
                update();

                //DRAW
                repaint();

                deltaTime -=1;
            }

        }
    }

    public void update(){
        pet.update();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        pet.paintComponent(g2);

        g2.dispose(); //save memory
    }
}