package programs;

import java.io.IOException;
import java.net.InetAddress;


//InetAddress is the class to that is used to get the ip address and host name
public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());


            InetAddress address2 = InetAddress.getByName("google.com");
            System.out.println(address2.getHostName());
            System.out.println(address2.getHostAddress());

        }catch(IOException ex){
            System.out.println(ex.toString());
        }
    }
}
