package unit3;
import java.net.URI;
import java.net.URISyntaxException;
public class URIRelativeResolveExample {
    public static void main(String[] args) throws URISyntaxException {
        URI absolute = new URI("http://www.example.com/");
        URI relative = new URI("images/logo.png");
        URI resolved = absolute.resolve(relative);
        System.out.println("Resolved URI: " + resolved);
        URI top = new URI("javafaq/books/");
        URI resolvedRelative = top.resolve("jnp3/examples/07/index.html");
        System.out.println("Resolved Relative URI: " + resolvedRelative);

        // Relativizing URIs
        URI absolute2 = new URI("http://www.example.com/images/logo.png");
        URI top2 = new URI("http://www.example.com/");
        URI relative2 = top2.relativize(absolute2);
        System.out.println("Relative URI: " + relative2);
    }
}
