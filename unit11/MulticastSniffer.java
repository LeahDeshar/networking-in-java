package unit11;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
public class MulticastSniffer {

    private static final String MULTICAST_ADDRESS = "230.0.0.0"; // Multicast address
    private static final int PORT = 4446; // Port to listen on

    public static void main(String[] args) {
        try {
            // Create a MulticastSocket
            MulticastSocket socket = new MulticastSocket(PORT);

            // Join the multicast group
            InetAddress group = InetAddress.getByName(MULTICAST_ADDRESS);
            socket.joinGroup(group);

            System.out.println("Listening for multicast packets on " + MULTICAST_ADDRESS + ":" + PORT);

            // Buffer to store incoming packets
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // Extract data from packet
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received packet from " + packet.getAddress() + ":" + packet.getPort());
                System.out.println("Message: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
