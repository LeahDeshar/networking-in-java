import java.io.*;
import java.net.*;

//class TCPServer {
//    public static void main(String[] args) {
//        final int PORT = 12345;
//
//        try {
//            // Create a server socket
//            ServerSocket serverSocket = new ServerSocket(PORT);
//            System.out.println("Server started...");
//
//            // Wait for client connection
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("Client connected...");
//
//            // Create input and output streams for the client socket
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//
//            // Read message from the client and echo it back
//            String message = in.readLine();
//            System.out.println("Received from client: " + message);
//            out.println("Server echoed: " + message);
//
//            // Close streams and sockets
//            in.close();
//            out.close();
//            clientSocket.close();
//            serverSocket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

public class Main {
    public static void main(String[] args) {
         try{
             ServerSocket serverSocket = new ServerSocket(9090);
             System.out.println("Waiting for the client");
             Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
             out.println("Hello Client");
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             String clientInput = input.readLine();
             System.out.println(clientInput);
             input.close();
             out.close();
             socket.close();

         }catch(Exception ex){
             System.out.println(ex.getStackTrace());
         }




    }
}