package unit8;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8443;

    public static void main(String[] args) {
        try {
            // Load the truststore from a file (if client authentication is required)
            String trustStoreFile = "client.truststore";
            char[] trustStorePassword = "truststorepassword".toCharArray();

            KeyStore trustStore = KeyStore.getInstance("JKS");
            try (FileInputStream trustStoreStream = new FileInputStream(trustStoreFile)) {
                trustStore.load(trustStoreStream, trustStorePassword);
            }

            // Initialize TrustManagerFactory with the truststore
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            // Initialize SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            // Create SSLSocketFactory
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();

            // Create and connect SSLSocket
            try (SSLSocket socket = (SSLSocket) socketFactory.createSocket(HOST, PORT)) {
                System.out.println("Connected to server: " + HOST + ":" + PORT);

                // Get input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a message to the server
                out.println("Hello, secure server!");

                // Read and print the response
                String response = in.readLine();
                System.out.println("Received: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
