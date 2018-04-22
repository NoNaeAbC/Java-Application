package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Login extends JFrame implements MouseListener {
    Path p1 = Paths.get("accounts.virus");
    JTextField textField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton button = new JButton("OK");
    String user = null;
    void setVisible(){
        setVisible(true);
        setBounds(100,100,500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(2);

        textField.setBounds(0,100,200,100);
        add(textField);

        button.addMouseListener(this);
        button.setBounds(0,0,200,50);
        add(button);

        passwordField.setBounds(200,100,200,100);
        add(passwordField);
    }

    Login(){
        super("Ätzend mit Swing");
    }
    void addUser(String userName,String passHash,String sk,String pk){
        try {
            Files.write(p1, new String(userName+":"+passHash+":"+sk+":"+pk+"\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(Main.c.vrfy(Crypto_.sha512(new String(passwordField.getPassword())),textField.getText())){
            setVisible(false);
            Main.s.setVisible();
        }
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
