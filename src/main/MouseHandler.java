package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener{

    public int targetX = 100;
    public int targetY = 100;

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + "," + e.getY());
        targetX = e.getX();
        targetY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    
}