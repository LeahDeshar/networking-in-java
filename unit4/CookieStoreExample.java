package unit4;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class CookieStoreExample {
    public static void main(String[] args) throws Exception {
        // Create a CookieManager and retrieve the CookieStore
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Create a new cookie and add it to the store
        HttpCookie cookie = new HttpCookie("sessionId", "abc123");
        cookieStore.add(new URI("http://example.com"), cookie);

        // Retrieve and print the cookies for a specific URI
        List<HttpCookie> cookies = cookieStore.get(new URI("http://example.com"));
        for (HttpCookie c : cookies) {
            System.out.println("Cookie: " + c);
        }

        // Remove a specific cookie
        boolean removed = cookieStore.remove(new URI("http://example.com"), cookie);
        System.out.println("Cookie removed: " + removed);

        // Retrieve and print all cookies in the store
        List<HttpCookie> allCookies = cookieStore.getCookies();
        for (HttpCookie c : allCookies) {
            System.out.println("Stored cookie: " + c);
        }

        // Clear all cookies
        boolean cleared = cookieStore.removeAll();
        System.out.println("All cookies removed: " + cleared);
    }
}
