package unit2;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ObjectMethodExample {
    public static void main(String[] args) {
        try {
            // Get the InetAddress instances for a specific hostname
            InetAddress address1 = InetAddress.getByName("www.facebook.com");
            InetAddress address2 = InetAddress.getByName("www.google.com");

            // Using toString() method
            System.out.println("toString(): " + address1.toString());

            // Using hashCode() method
            System.out.println("hashCode(): " + address1.hashCode());

            // Using equals() method
            System.out.println("address1.equals(address2): " + address1.equals(address2));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
