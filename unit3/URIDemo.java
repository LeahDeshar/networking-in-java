package unit3;

import java.net.URI;
import java.net.URISyntaxException;

public class URIDemo {
    public static void main(String[] args) {
        try {
            // Using different constructors to create URI objects
            URI uri1 = new URI("http://www.example.com/path?key=value#fragment");
            System.out.println("URI 1: " + uri1);

            URI uri2 = new URI("http", "//www.example.com/path?key=value", "fragment");
            System.out.println("URI 2: " + uri2);

            URI uri3 = new URI("http", "www.example.com", "/path", "fragment");
            System.out.println("URI 3: " + uri3);

            URI uri4 = new URI("http", "<username:password@www.example.com>", "/path", "key=value", "fragment");
            System.out.println("URI 4: " + uri4);

            URI uri5 = new URI("http", "username", "www.example.com", 80, "/path", "key=value", "fragment");
            System.out.println("URI 5: " + uri5);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}