
package crypto;

import java.security.MessageDigest;

public class Digest {
    public static void main(String args[]) throws Exception {
        System.out.println("digest");

        String data = "hello";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        //1
        md.update(data.getBytes());
        byte[] dig = md.digest();
        System.out.println("Digest:"+new String(dig));
        //2
        md.update(data.getBytes());
        byte[] dig2 = md.digest();
        System.out.println(java.util.Arrays.equals(dig,dig2));
    }
}