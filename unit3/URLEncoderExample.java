package unit3;
import java.io.UnsupportedEncodingException;
import java.net.*;
public class URLEncoder {
    public static void main(String[] args) {
        try {
            String originalString = "Hello World! @2023";
            String encodedString = URLEncoder.encode(originalString, "UTF-8");
            System.out.println("Original String: " + originalString);
            System.out.println("Encoded String: " + encodedString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
