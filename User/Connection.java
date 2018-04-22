package User;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection  extends Exception{
    int getPubKey(String user){
        return 0;
    }
    boolean vrfy(String passHash,String user){
        boolean b = false;
        try (Socket s = new Socket("127.0.0.1", 1337)) {
            OutputStream outputStream = s.getOutputStream();
            InputStream inputStream= s.getInputStream();

            String msg = "BOOL VRFY :"+passHash+":"+user;

            outputStream.write(msg.length());
            outputStream.write(msg.getBytes());

            int i = inputStream.read()%2;

            if(i!=0){
                b = true;
            }


            outputStream.close();
            inputStream.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }
    boolean newUser(String user, String pass, String pk){
        boolean b = false;
        try (Socket s = new Socket("127.0.0.1", 1337)) {
            OutputStream outputStream = s.getOutputStream();
            InputStream inputStream= s.getInputStream();

            String msg = "BOOL USER :"+pass+":"+user;

            outputStream.write(msg.length());
            outputStream.write(msg.getBytes());

            int i = inputStream.read()%2;

            if(i!=0){
                b = true;
            }


            outputStream.close();
            inputStream.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }


    void send(String usr,String msg) throws Connection{
        try (Socket s = new Socket("127.0.0.1", 1337)) {
            OutputStream outputStream = s.getOutputStream();
            InputStream inputStream= s.getInputStream();

            String msgts1 = "BOOL SEND";
            String msgts = usr+":"+msg;

            outputStream.write(msgts1.length());
            outputStream.write(msgts1.getBytes());

            byte[] p = new byte[16];
            inputStream.read(p);

            outputStream.write(Main.login.user.getBytes());

            msgts = Crypto_.encrypt(new String(p),Main.login.user,msgts);


            outputStream.write(msgts.length());
            outputStream.write(msgts.getBytes());

            if(inputStream.read() == 0){
                throw this;
            }

            outputStream.close();
            inputStream.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
