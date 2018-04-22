package User;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Send extends JFrame implements MouseListener {

    JTextField usr = new JTextField();
    JTextField msg = new JTextField();
    JButton button = new JButton("Send");
    void setVisible(){

        setVisible(true);
        setBounds(100,100,500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(2);

        usr.setBounds(0,100,200,100);
        add(usr);

        button.addMouseListener(this);
        button.setBounds(0,0,200,50);
        add(button);

        msg.setBounds(200,100,200,100);
        add(msg);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            Main.c.send(usr.getText(), msg.getText());
        } catch (Connection connection) {
            connection.printStackTrace();
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
