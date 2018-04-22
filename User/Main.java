package User;

import javax.swing.*;
import java.awt.*;

/**
 * @author Neah
 *  https://www.jetbrains.com/idea/download/download-thanks.html?platform=linux&code=IIC
 *  Ugly code thanks to java swing
 */
public class Main {
    static JButton si = new JButton("New account");
    static JButton li = new JButton("Log in");
    static JPanel jPanel = new JPanel();
    static JFrame welcome;
    static WelcomeListener wl = new WelcomeListener();
    static Connection c = new Connection();
    static Login login = new Login();

    public static void main(String[] args) {
        welcome = new JFrame("Swing ist scheiße javafx ist besser");
        welcome.setBounds(100,100,500,500);
        welcome.setLayout(new FlowLayout());
        welcome.setVisible(true);
        welcome.setDefaultCloseOperation(2);

        jPanel.setBounds(0,0,500,500);

        //jPanel.addKeyListener(wl);
        //jPanel.addMouseListener(wl);
        //System.out.print(welcome.isFocusable());


        si.setBounds(100,100,100,100);
        jPanel.add(si);
        si.addMouseListener(wl);

        li.setBounds(100,100,100,100);
        jPanel.add(li);
        li.addMouseListener(wl);

        welcome.add(jPanel);
    }
}
