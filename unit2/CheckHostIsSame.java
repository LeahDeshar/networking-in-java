package unit2;

import java.net.InetAddress;

public class CheckHostIsSame {
    public static void main(String[] args) {
//        google and drive
        try {
            InetAddress addressOne = InetAddress.getByName("google.com");
            InetAddress addressTwo = InetAddress.getByName("drive.google.com");


            if(addressOne.equals(addressTwo)){
                System.out.println("Both Hosts are same");
            }else{
                System.out.println("Both Hosts are different");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
