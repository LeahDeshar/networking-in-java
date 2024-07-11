package unit3;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.MalformedURLException;

public class URLSplitter {
    public static void main(String[] args) {
        String urlString = "https://www.example.com/path/to/resource?param1=value1&param2=value2#section";

        try {
            URL url = new URL(urlString);

            // Get individual components of the URL
            String protocol = url.getProtocol(); // "https"
            String authority = url.getAuthority(); // "www.example.com"
            String host = url.getHost(); // "www.example.com"
            String path = url.getPath(); // "/path/to/resource"
            String query = url.getQuery(); // "param1=value1&param2=value2"
            String fragment = url.getRef(); // "section"

            // Print each component
            System.out.println("URL: " + url.toString());
            System.out.println("to external links: " + url.toExternalForm());

            URI uri = url.toURI();
            System.out.println("URL as URI: " + uri);


            System.out.println("Protocol: " + protocol);
            System.out.println("Authority: " + authority);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            System.out.println("Host: " + host);
            System.out.println("The user info is " + url.getUserInfo());

//            get the specific query parameters
            String[] queryParameters = query.split("&");
            for (String queryParameter : queryParameters) {
                String[] keyValue = queryParameter.split("=");
                System.out.println("Key: " + keyValue[0] + ", Value: " + keyValue[1]);
            }
            System.out.println("Fragment: " + fragment);

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + urlString);
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
