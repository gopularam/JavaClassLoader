import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public class GcmIV {

    static final SecretKey KEY = new SecretKeySpec(new byte[16], "AES");
    static final byte[] IV = new byte[0];
    static final GCMParameterSpec SPEC = new GCMParameterSpec(128, IV);

    public static void main(String[] arg) throws Exception {
        for (Provider prov : Security.getProviders()) {
            testProvider(prov);
        }
    }

    private static void testProvider(Provider prov)
        throws NoSuchPaddingException, InvalidKeyException {

        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", prov);
            try {
                cipher.init(Cipher.DECRYPT_MODE, KEY, SPEC);
                throw new RuntimeException("empty IV accepted");
            } catch (InvalidAlgorithmParameterException ex) {
                System.out.println(prov.getName() + " rejects empty IV");
            }
        } catch (NoSuchAlgorithmException ex) {
            if (prov.getName().equals("SunJCE")) {
                throw new RuntimeException("SunJCE should support AES/GCM");
            }
            // skip test when AES/GCM is not supported
            System.out.println(prov.getName() + " does not support AES/GCM");
        }
    }
}
