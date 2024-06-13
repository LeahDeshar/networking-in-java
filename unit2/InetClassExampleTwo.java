package unit2;


import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetClassExampleTwo {
    public static void main(String[] args) {
        try {
            // Get all InetAddress objects for facebook.com
            InetAddress[] inetAddressesFb = InetAddress.getAllByName("facebook.com");
            InetAddress[] inetAddressesNTC = InetAddress.getAllByName("www.ntc.net.np");

            Diplay(inetAddressesFb);
            Diplay(inetAddressesNTC);
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host");
            e.printStackTrace();
        }
    }

    private static void Diplay(InetAddress[] address) {
        for (InetAddress add : address) {
            // Print the IP address
            String ipAddress = add.getHostAddress();
            System.out.println("IP Address: " + ipAddress);

            // Print the hostname
            String hostName = add.getHostName();
            System.out.println("Host Name: " + hostName);

            // Check if it is IPv4 or IPv6
            if (add instanceof Inet4Address) {
                System.out.println("This is an IPv4 address.");
            } else if (add instanceof Inet6Address) {
                System.out.println("This is an IPv6 address.");
            }
            System.out.println();
        }
    }
}
