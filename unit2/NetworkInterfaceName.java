package unit2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaceName {
    public static void main(String[] args) {
        try {
            // Get NetworkInterface by Name
            String interfaceName = "eth0"; // Change this to your network interface name
            NetworkInterface networkInterfaceByName = NetworkInterface.getByName(interfaceName);
            if (networkInterfaceByName != null) {
                System.out.println("Network Interface (by name): " + networkInterfaceByName.getDisplayName());
            } else {
                System.out.println("No Network Interface found with name: " + interfaceName);
            }



        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
