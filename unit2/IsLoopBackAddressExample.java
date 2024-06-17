package unit2;

import java.net.InetAddress;

public class IsLoopBackAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("127.3.0.1");
            if(address.isLoopbackAddress()){
                System.out.println("This is a loopback address");
            }else{
                System.out.println("This is not a loopback address");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
