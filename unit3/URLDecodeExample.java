package unit3;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
public class URLDecodeExample {
    public static void main(String[] args) {
        try {
            String encodedString = "Hello%20World%21%20%402023";
            String decodedString = URLDecoder.decode(encodedString, "UTF-8");
            System.out.println("Encoded String: " + encodedString);
            System.out.println("Decoded String: " + decodedString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
