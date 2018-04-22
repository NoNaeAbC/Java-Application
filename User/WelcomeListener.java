package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WelcomeListener implements KeyListener,MouseListener {
    int toggleMouse = 0;
    @Override
    public void keyTyped(KeyEvent e) {

        System.out.println(e.getKeyChar());
        System.out.println("4zg");
        if(e.getKeyChar() == '\t'){
            if(toggleMouse ==0){
                toggleMouse = 1;
                try {
                    Robot r = new Robot();
                    r.mouseMove(250,110);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }else{
                toggleMouse = 0;
                try {
                    Robot r = new Robot();
                    r.mouseMove(350,110);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(((JButton)e.getSource()).getText().equals("Log in")){

        }else{
            Main.welcome.setVisible(false);
            Sign_in s = new Sign_in();
        }
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
