package unit8;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureServer {

    private static final int PORT = 8443;

    public static void main(String[] args) {
        try {
            // Load the keystore from a file
            String keyStoreFile = "E:\\6thsem\\NETWORKING\\Learning\\unit8\\server.keystore";
            char[] keyStorePassword = "keystorepassword".toCharArray();

            KeyStore keyStore = KeyStore.getInstance("JKS");
            try (FileInputStream keyStoreStream = new FileInputStream(keyStoreFile)) {
                keyStore.load(keyStoreStream, keyStorePassword);
            }

            // Initialize KeyManagerFactory with the keystore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, keyStorePassword);

            // Initialize SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Create SSLServerSocketFactory
            SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();

            // Create SSLServerSocket
            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(PORT);
            System.out.println("Secure server started on port " + PORT);

            while (true) {
                try (SSLSocket clientSocket = (SSLSocket) serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    // Get input and output streams
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    // Simple echo server logic
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println("Received: " + line);
                        out.println("Echo: " + line);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
