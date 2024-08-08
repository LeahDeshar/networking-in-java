package unit7;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeServer {
    public static void main(String[] args) {
        int port = 9090; // Port to listen on
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port + "...");

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Handle client connection in a separate thread
                new Thread(new DateTimeHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DateTimeHandler implements Runnable {
    private Socket clientSocket;

    public DateTimeHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            // Get the current date and time
            String currentDateTime = getCurrentDateTime();
            // Send the date and time to the client
            out.println("Current Date and Time: " + currentDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCurrentDateTime() {
        // Define the date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Get the current date and time
        Date date = new Date();
        // Format and return the date and time
        return formatter.format(date);
    }
}
