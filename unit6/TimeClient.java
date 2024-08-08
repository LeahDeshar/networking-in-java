package unit6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        String hostname = "time.nist.gov"; // NIST Internet Time Server
        int port = 13; // Daytime protocol port

        try (Socket socket = new Socket(hostname, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String time;
            while ((time = reader.readLine()) != null) {
                System.out.println("Current time from server: " + time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
