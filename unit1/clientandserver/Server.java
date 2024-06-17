package unit1.clientandserver;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Connection Established");
        Socket s = ss.accept();


        DataInputStream dis = new DataInputStream(s.getInputStream());
        String str = (String) dis.readUTF();
        System.out.println("Client Message : " + str);
        dis.close();
        s.close();
        ss.close();
    }
}
