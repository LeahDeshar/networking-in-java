package unit6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketInfo {
    public static void main(String[] args) {
        String hostname = "example.com"; // Replace with the server you want to connect to
        int port = 80; // HTTP port, replace if needed

        try (Socket socket = new Socket(hostname, port)) {
            // Get socket information
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Local Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Is Connected: " + socket.isConnected());
            System.out.println("Is Closed: " + socket.isClosed());

            // Optionally send a simple request and read the response
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // Send an HTTP GET request
                out.println("GET / HTTP/1.1");
                out.println("Host: " + hostname);
                out.println("Connection: close");
                out.println(); // Blank line indicates end of request headers

                // Read and print the server's response
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
