package unit2;

import java.net.NetworkInterface;
import java.net.SocketException;

public class ListNetworkInterfaces {
    public static void main(String[] args) {
        try {
            java.util.Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Network Interface: " + networkInterface);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
