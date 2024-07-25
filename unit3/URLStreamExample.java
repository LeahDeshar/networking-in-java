package unit3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
public class URLStreamExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream));
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
