package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    final int tileSize = 16; 
    final int scale = 3;

    final int finalTileSize = tileSize*scale;
    final int maxScreenCol = 8;
    final int maxSceenRow = 6;
    final int screenWidth = finalTileSize * maxScreenCol;
    final int screenHeight = finalTileSize * maxSceenRow;

    //FPS
    int FPS = 60;

    Thread gameThread; 
    MouseHandler mouseH = new MouseHandler();

    //Pet's default position
    int petX = 100;
    int petY = 100;
    int petSpeed = 2;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.ORANGE);
        this.setDoubleBuffered(true); //drawing component in offscreen buffer
        this.addMouseListener(mouseH);
        this.setFocusable(true);//gamePanel can be focused to receive input

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        double deltaTime = 1000000000/FPS; //deltaTime in nanoseconds
        double nextDrawTime = System.nanoTime()+ deltaTime;

        while(gameThread != null){

            //UPDATE
            update();

            //DRAW
            repaint();

            try{
                double remainingTime = (nextDrawTime - System.nanoTime());
                remainingTime = remainingTime/1000000; //in millis
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); // Stop game thread from proceeding for the remaining delta time
                nextDrawTime += deltaTime;


            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void update(){
        if(mouseH.targetX != petX || mouseH.targetY != petY){
            if(mouseH.targetX > petX) petX+=petSpeed;
            else if(mouseH.targetX < petX) petX -= petSpeed;

            if(mouseH.targetY > petY) petY+=petSpeed;
            else if(mouseH.targetY < petY) petY -= petSpeed;
        }
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);

        g2.fillRect(petX,petY,finalTileSize,finalTileSize);

        g2.dispose(); //save memory
    }
}