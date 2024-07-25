package unit3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class ProxyExample {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "192.168.254.254");
        System.setProperty("http.proxyPort", "8080");
        try {
            URL url = new URL("https://en.wikipedia.org/wiki/Google");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
