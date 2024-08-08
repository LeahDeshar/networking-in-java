package unit4;
import java.net.*;
import java.util.List;
public class CookieManagerExample {
        public static void main(String[] args) {
            CookieManager cm = new CookieManager();
            CookieStore cs = cm.getCookieStore();
            HttpCookie c1 = new HttpCookie("user1", "1");
            HttpCookie c2 = new HttpCookie("user2", "2");
            HttpCookie c3 = new HttpCookie("user3", "3");
            URI uri1 = URI.create("http://spm.com.np");
            URI uri2 = URI.create("http://spm1.com.np");

            // Add cookies into cookiestore
            cs.add(uri1, c1);
            cs.add(uri2, c2);
            cs.add(null, c3);

            //read stored cookies
            List cl = cs.getCookies();
            System.out.println("cookies list in cookiestore" + cl + "\n");

            //remove cookie of uri
            cs.remove(uri1,c1);
            List cr = cs.getCookies();
            System.out.println("remaining cookiestore" + cr + "\n");

            // remove all cookies
            cs.removeAll();
            List empty = cs.getCookies();
            System.out.println("remove all cookiestore" + empty);

        }
    }
