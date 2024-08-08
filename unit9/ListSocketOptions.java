package unit9;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;
public class ListSocketOptions {

    public static void main(String[] args) {
        try {
            // Create and open channels
            SocketChannel socketChannel = SocketChannel.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            DatagramChannel datagramChannel = DatagramChannel.open();

            // List supported options for each channel type
            System.out.println("Supported options for SocketChannel:");
            listSocketOptions(socketChannel);

            System.out.println("\nSupported options for ServerSocketChannel:");
            listSocketOptions(serverSocketChannel);

            System.out.println("\nSupported options for DatagramChannel:");
            listSocketOptions(datagramChannel);

            // Close channels
            socketChannel.close();
            serverSocketChannel.close();
            datagramChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listSocketOptions(SelectableChannel channel) {
        try {
            if (channel instanceof SocketChannel) {
                SocketChannel socketChannel = (SocketChannel) channel;
                System.out.println("SocketChannel:");
                System.out.println("  SO_RCVBUF: " + socketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
                System.out.println("  SO_SNDBUF: " + socketChannel.getOption(StandardSocketOptions.SO_SNDBUF));
                System.out.println("  SO_KEEPALIVE: " + socketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE));
                System.out.println("  SO_LINGER: " + socketChannel.getOption(StandardSocketOptions.SO_LINGER));
                System.out.println("  SO_REUSEADDR: " + socketChannel.getOption(StandardSocketOptions.SO_REUSEADDR));
                System.out.println("  TCP_NODELAY: " + socketChannel.getOption(StandardSocketOptions.TCP_NODELAY));
            } else if (channel instanceof ServerSocketChannel) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) channel;
                System.out.println("ServerSocketChannel:");
                System.out.println("  SO_RCVBUF: " + serverSocketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
                System.out.println("  SO_SNDBUF: " + serverSocketChannel.getOption(StandardSocketOptions.SO_SNDBUF));
                System.out.println("  SO_KEEPALIVE: " + serverSocketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE));
                System.out.println("  SO_LINGER: " + serverSocketChannel.getOption(StandardSocketOptions.SO_LINGER));
                System.out.println("  SO_REUSEADDR: " + serverSocketChannel.getOption(StandardSocketOptions.SO_REUSEADDR));
            } else if (channel instanceof DatagramChannel) {
                DatagramChannel datagramChannel = (DatagramChannel) channel;
                System.out.println("DatagramChannel:");
                System.out.println("  SO_RCVBUF: " + datagramChannel.getOption(StandardSocketOptions.SO_RCVBUF));
                System.out.println("  SO_SNDBUF: " + datagramChannel.getOption(StandardSocketOptions.SO_SNDBUF));
                System.out.println("  SO_KEEPALIVE: " + datagramChannel.getOption(StandardSocketOptions.SO_KEEPALIVE));
                System.out.println("  SO_LINGER: " + datagramChannel.getOption(StandardSocketOptions.SO_LINGER));
                System.out.println("  SO_REUSEADDR: " + datagramChannel.getOption(StandardSocketOptions.SO_REUSEADDR));
                System.out.println("  SO_BROADCAST: " + datagramChannel.getOption(StandardSocketOptions.SO_BROADCAST));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
