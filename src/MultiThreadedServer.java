import java.net.*;
import java.io.*;

public class MultiThreadedServer {
    public static void main(String[] args) {
        try
        {
            ServerSocket serverSocket = new ServerSocket(9090);
            boolean stop = false;
            while(!stop)
            {
                System.out.println("Waiting for clients...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client is connected.");
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
class ClientThread extends Thread{

   private Socket socket = null;
   public ClientThread(Socket socket){
       this.socket = socket;
   }
    public void run(){

    }
}
