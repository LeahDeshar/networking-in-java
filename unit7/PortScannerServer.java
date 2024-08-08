package unit7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortScannerServer {

    private static final int SERVER_PORT = 9090;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Port Scanner Server is listening on port " + SERVER_PORT + "...");

            // Initialize thread pool
            ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            while (true) {
                // Accept client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Handle client connection in a separate thread
                threadPool.execute(new PortScannerHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PortScannerHandler implements Runnable {
    private Socket clientSocket;

    public PortScannerHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the port range from the client
            int startPort = 0;
            int endPort = 0;

            try (var input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 var output = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String range = input.readLine();
                String[] parts = range.split("-");
                if (parts.length == 2) {
                    startPort = Integer.parseInt(parts[0].trim());
                    endPort = Integer.parseInt(parts[1].trim());
                } else {
                    output.println("Invalid range format.");
                    return;
                }

                // Perform port scanning
                StringBuilder result = new StringBuilder();
                for (int port = startPort; port <= endPort; port++) {
                    if (isPortOpen(port)) {
                        result.append("Port ").append(port).append(" is open.\n");
                    } else {
                        result.append("Port ").append(port).append(" is closed.\n");
                    }
                }

                // Send the results to the client
                output.println(result.toString());
            }
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

    private boolean isPortOpen(int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", port), 1000);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
