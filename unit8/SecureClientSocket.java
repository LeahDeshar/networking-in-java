package unit8;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SecureClientSocket {
    public static void main(String[] args) {
        try {
            // Create SSLSocketFactory
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            // Create SSLSocket to connect to tufohss.edu.np on port 443
            SSLSocket socket = (SSLSocket) factory.createSocket("tufohss.edu.np", 443);

            // Optional: enable specific cipher suites if needed
            // String[] cipherSuites = {"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"};
            // socket.setEnabledCipherSuites(cipherSuites);

            // Send an HTTP GET request to tufohss.edu.np
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            out.println("GET / HTTP/1.1");
            out.println("Host: tufohss.edu.np");
            out.println("Connection: Close");
            out.println();
            out.flush();

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close the connections
            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
