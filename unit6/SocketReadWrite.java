package unit6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketReadWrite {
    public static void main(String[] args) {
        String hostname = "example.com";
        int port = 80; // HTTP port

        try (Socket socket = new Socket(hostname, port);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send HTTP GET request
            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + hostname);
            writer.println("Connection: close");
            writer.println(); // Blank line indicates end of request headers

            // Read the response from the server
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
