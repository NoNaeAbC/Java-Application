package User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Sign_in extends JFrame implements KeyListener {
    TextField textField = new TextField();
    JPasswordField passwordField = new JPasswordField();
    public Sign_in(){
        super("Warum läuft javafx nicht!!!!!!!!!!!!!!");
        setBounds(100,100,500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(2);

        textField.setBounds(0,100,200,100);
        add(textField);

        passwordField.setBounds(200,100,200,100);
        add(passwordField);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
