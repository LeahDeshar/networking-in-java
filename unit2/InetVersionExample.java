package unit2;

import java.net.*;
import java.net.UnknownHostException;
public class InetVersionExample {
    public static void main(String[] args) {
        try {
            // Get an IPv4 address instance
            Inet4Address ipv4Address = (Inet4Address) Inet4Address.getByName("93.184.216.34"); // example.com IPv4 address

            // Get an IPv6 address instance
            Inet6Address ipv6Address = (Inet6Address) Inet6Address.getByName("2606:2800:220:1:248:1893:25c8:1946"); // example.com IPv6 address

            // Display IPv4 address details
            System.out.println("IPv4 Address:");
            System.out.println("Hostname: " + ipv4Address.getHostName());


            // Display IPv6 address details
            System.out.println("\nIPv6 Address:");
            System.out.println("Hostname: " + ipv6Address.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
