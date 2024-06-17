package unit2;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class GetterMethodExample {
    public static void main(String[] args) {
        try {
            // Get the InetAddress instance for a specific hostname
            InetAddress address = InetAddress.getByName("www.example.com");

            // Get the hostname
            String hostname = address.getHostName();
            System.out.println("Hostname: " + hostname);

            // Get the canonical hostname
            String canonicalHostname = address.getCanonicalHostName();
            System.out.println("Canonical Hostname: " + canonicalHostname);

            // Get the host address
            String hostAddress = address.getHostAddress();
            System.out.println("Host Address: " + hostAddress);

            // Get the raw IP address in byte array form
            byte[] addressBytes = address.getAddress();
            System.out.print("Address (byte array): ");
            for (byte b : addressBytes) {
                System.out.print((b & 0xFF) + " ");
            }
            System.out.println();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
