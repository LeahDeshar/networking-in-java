package unit5;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestExample {

    public static void main(String[] args) {
        try {
            // URL for the HTTP request
            String urlString = "https://www.java.com/en/";

            // Choose the HTTP method: "GET", "POST", "PUT", "DELETE"
            String requestMethod = "GET";  // Change this to "POST", "PUT", "DELETE" as needed

            // Create URL object
            URL url = new URL(urlString);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);

            // If the request method is POST or PUT, write data to the server
            if ("POST".equals(requestMethod) || "PUT".equals(requestMethod)) {
                conn.setDoOutput(true);
                String jsonInputString = "{\"key\":\"value\"}";  // JSON data to send

                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            // Get the response code
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Response: " + response.toString());
            }

            // Disconnect from the server
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
