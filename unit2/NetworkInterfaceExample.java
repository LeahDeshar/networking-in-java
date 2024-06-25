package unit2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceExample {

    public static void main(String[] args) {
        try {
            // Get NetworkInterface by Name
            InetAddress local = InetAddress.getByName("localhost");
//            String interfaceName = "eth0";
            NetworkInterface networkInterfaceByName = NetworkInterface.getByInetAddress(local);
            if (networkInterfaceByName != null) {
                System.out.println("Network Interface (by name): " + networkInterfaceByName);
            } else {
                System.out.println("No Network Interface found with name: " + local);
            }

            // Get NetworkInterface by Address
//            InetAddress address = InetAddress.getByName("192.168.1.1"); // Change this to your network interface address
//            NetworkInterface networkInterfaceByAddress = NetworkInterface.getByInetAddress(address);
//            if (networkInterfaceByAddress != null) {
//                System.out.println("Network Interface (by address): " + networkInterfaceByAddress.getDisplayName());
//            } else {
//                System.out.println("No Network Interface found with address: " + address.getHostAddress());
//            }
//
//            // List all Network Interfaces
//            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
//            for (NetworkInterface netInterface : Collections.list(interfaces)) {
//                System.out.println("Interface Display Name: " + netInterface.getDisplayName());
//                System.out.println("Interface Name: " + netInterface.getName());
//                Enumeration<InetAddress> inetAddresses = netInterface.getInetAddresses();
//                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
//                    System.out.println("InetAddress: " + inetAddress.getHostAddress());
//                }
//                System.out.println();
//            }

        } catch (SocketException | java.net.UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
