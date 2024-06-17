package unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetClassExampleOne {
    public static void main(String[] args) {
        InetAddress inetAddressGoogle,inetAddressFacebook,inetAddressBern;
        try {
            // Get InetAddress object for google.com
             inetAddressGoogle = InetAddress.getByName("www.google.com");
            inetAddressFacebook = InetAddress.getByName("www.facebook.com");
            inetAddressBern = InetAddress.getByName("kbc.edu.np");
            // Get the IP address
            String ipAddressGoogle,ipAddressFacebook,ipAddressBern;
            ipAddressGoogle = inetAddressGoogle.getHostAddress();
            ipAddressFacebook = inetAddressFacebook.getHostAddress();
            ipAddressBern = inetAddressBern.getHostAddress();


            System.out.println("IP Address of Google : " + ipAddressGoogle);
            System.out.println("IP Address Facebook: " + ipAddressFacebook);
            System.out.println("IP Address Bern Hardt: " + ipAddressBern);



            // Get the hostname
            String hostNameGoogle,hostNameFacebook,hostNameBern;

            hostNameGoogle = inetAddressGoogle.getHostName();
            hostNameFacebook = inetAddressFacebook.getHostName();
            hostNameBern = inetAddressBern.getHostName();

            System.out.println("Host Name of Google: " + hostNameGoogle);
            System.out.println("Host Name of Facebook: " + hostNameFacebook);
            System.out.println("Host Name of Bern Hardt: " + hostNameBern);
            
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host");
            e.printStackTrace();
        }
    }
}
