package crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigiSign {

	public static void main(String[] args) throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		KeyPair kp = kpg.generateKeyPair();
		PrivateKey prk = kp.getPrivate();
		PublicKey puk = kp.getPublic();
		Signature sig = Signature.getInstance("SHA256withRSA");
		
		//Sign
		sig.initSign(prk);
		String data = new String("ABCDE");
		sig.update(data.getBytes());
		byte[] sign = sig.sign();
		
		//Verify
		sig.initVerify(puk);
		sig.update(data.getBytes());
		System.out.println("Signature verification:"+sig.verify(sign));

	}

}
