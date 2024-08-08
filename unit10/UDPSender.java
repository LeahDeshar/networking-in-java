package unit10;

import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String message = "Hello, UDP Server!";
        byte[] data = message.getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9876;
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        socket.send(packet);
        socket.close();
    }
}
