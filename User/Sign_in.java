package User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sign_in extends JFrame implements KeyListener,MouseListener {
    TextField textField = new TextField();
    JPasswordField passwordField = new JPasswordField();
    JButton button = new JButton("OK");
    public Sign_in(){
        super("Warum läuft javafx nicht!!!!!!!!!!!!!!");
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
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.print("dg");
        if(((JButton)e.getSource()).getText().equals("OK")){
            String name = textField.getText().replace(':','_');
            String pass = new String(passwordField.getPassword());
            byte[] b = new byte[16];
            for (int i = 0; i<16; i++){
                try {
                    b[i] = pass.getBytes()[i];
                }catch (ArrayIndexOutOfBoundsException e1 ){

                } finally{
                    b[i] = 0;
                }
            }
            pass=new String(b);
            String key = pass;
            String iv = name;
            b = new byte[16];
            for (int i = 0; i<16; i++){
                try {
                    b[i] = name.getBytes()[i];
                }catch (ArrayIndexOutOfBoundsException e1 ){

                } finally{
                    b[i] = 0;
                }
            }
            iv=new String(b);
            pass = Crypto_.sha512(pass);
            if(Main.c.newUser(name,pass,"")){
                Main.login.addUser(name,pass,Crypto_.encrypt(key,iv,""),"");
                setVisible(false);
                Main.login.setVisible();
            }
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
