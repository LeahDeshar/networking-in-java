package unit2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;


public class NetworkInterfaceLocalHost {

    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getByName("localhost");
            NetworkInterface networkInterfaceByName = NetworkInterface.getByInetAddress(local);
            if (networkInterfaceByName != null) {
                System.out.println("Network Interface  " + networkInterfaceByName);
            } else {
                System.out.println("No Network Interface found with name: " + local);
            }



        } catch (SocketException | java.net.UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
