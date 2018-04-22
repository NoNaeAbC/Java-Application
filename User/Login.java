package User;

import javax.swing.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Login extends JFrame {
    Path p1 = Paths.get("accounts.virus");
    void setVisible(){
        setVisible(true);
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
}
