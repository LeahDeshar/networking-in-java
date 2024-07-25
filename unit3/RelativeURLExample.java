package unit3;
import java.net.MalformedURLException;
import java.net.URL;

public class RelativeURLExample {
    public static void main(String[] args) {
        try {
            // Base URL
            URL baseURL = new URL("https://www.example.com/folder/");

            // Constructing relative URLs based on the base URL
            URL relativeURL1 = new URL(baseURL, "page1.html");
            URL relativeURL2 = new URL(baseURL, "images/photo.jpg");
            URL relativeURL3 = new URL(baseURL, "../index.html");
            URL relativeURL4 = new URL(baseURL, "./contact.html");

            // Printing the absolute URLs
            System.out.println("Base URL: " + baseURL);
            System.out.println("Relative URL (page1.html): " + relativeURL1);
            System.out.println("Relative URL (images/photo.jpg): " + relativeURL2);
            System.out.println("Relative URL (../index.html): " + relativeURL3);
            System.out.println("Relative URL (./contact.html): " + relativeURL4);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
