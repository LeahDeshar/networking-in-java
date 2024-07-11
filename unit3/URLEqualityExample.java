package unit3;

import java.net.URL;

public class URLEqualityExample {
    public static void main(String[] args) throws Exception {
        URL url1 = new URL("http://www.example.com/path/to/resource");
        URL url2 = new URL("http://example.com/path/to/resource");

        // Check equality
        System.out.println("URL1 equals URL2: " + url1.equals(url2));

        // Check hashCode
        System.out.println("Hash code of URL1: " + url1.hashCode());
        System.out.println("Hash code of URL2: " + url2.hashCode());
    }
}
