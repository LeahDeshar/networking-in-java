package unit2;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetClassExampleTwo {
    public static void main(String[] args) {
        try {
            // Get all InetAddress objects for facebook.com
            InetAddress[] inetAddresses = InetAddress.getAllByName("facebook.com");
            InetAddress[] inetAddressesNTC = InetAddress.getAllByName("www.ntc.net.np");

            for (InetAddress inetAddress : inetAddresses) {
                // Print the IP address
                String ipAddress = inetAddress.getHostAddress();
                System.out.println("IP Address: " + ipAddress);

                // Print the hostname
                String hostName = inetAddress.getHostName();
                System.out.println("Host Name: " + hostName);

                // Check if it is IPv4 or IPv6
                if (inetAddress instanceof java.net.Inet4Address) {
                    System.out.println("This is an IPv4 address.");
                } else if (inetAddress instanceof java.net.Inet6Address) {
                    System.out.println("This is an IPv6 address.");
                }
                System.out.println();
            }

            for (InetAddress ntc : inetAddressesNTC) {
                // Print the IP address
                String ipAddress = ntc.getHostAddress();
                System.out.println("IP Address: " + ipAddress);

                // Print the hostname
                String hostName = ntc.getHostName();
                System.out.println("Host Name: " + hostName);

                // Check if it is IPv4 or IPv6
                if (ntc instanceof java.net.Inet4Address) {
                    System.out.println("This is an IPv4 address.");
                } else if (ntc instanceof java.net.Inet6Address) {
                    System.out.println("This is an IPv6 address.");
                }
                System.out.println();
            }
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host");
            e.printStackTrace();
        }
    }
}
