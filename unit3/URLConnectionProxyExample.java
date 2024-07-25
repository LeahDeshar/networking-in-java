package unit3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
public class URLConnectionProxyExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.cloudskillsboost.google/");
            Proxy proxy = new Proxy(Proxy.Type.HTTP,
                    new InetSocketAddress("proxy.example.com", 8080));
            URLConnection connection = url.openConnection(proxy);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
