package unit3;
import java.net.URI;
import java.net.URISyntaxException;
public class URIToStringExample {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http://example.com/path?query=value#fragment");

        String uriString = uri.toString();
        System.out.println("toString(): " + uriString);

        String asciiUriString = uri.toASCIIString();
        System.out.println("toASCIIString(): " + asciiUriString);
    }
}
