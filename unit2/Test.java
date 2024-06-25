package unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args)  throws UnknownHostException {
        InetAddress[] address = InetAddress.getAllByName("www.example.com");
        System.out.println(address.toString());

        for (InetAddress addr : address) {
            System.out.println(addr);
            System.out.println("Hostname: " + addr.getHostName());
            System.out.println("Canonical Hostname: " + addr.getCanonicalHostName());
            System.out.println("Host Address: " + addr.getHostAddress());
            byte[] addressBytes = addr.getAddress();
            System.out.print("Address (byte array): ");

//            check type of addressByte
            System.out.println(addressBytes.getClass().getName());
            for (byte b : addressBytes) {
                System.out.print((b & 0xFF) + " " );
            }
            System.out.println();
        }


        InetAddress googleAddress = InetAddress.getByName("www.google.com");
        System.out.println(googleAddress);
    }
}
