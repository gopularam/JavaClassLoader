package crypto;

import java.security.SecureRandom;

public class SecureRandomTest {
	public static void main(String[] args) throws Exception {
		//1
		SecureRandom sr = new SecureRandom();
		byte[] bb = new byte[20];
		sr.setSeed(bb);
		byte[] rdata = new byte[20];
		sr.nextBytes(rdata);
		System.out.println("SR: "+sr.getAlgorithm()+": "+new String(rdata));
		//2
		SecureRandom sr2 = SecureRandom.getInstance("SHA1PRNG");
		System.out.println("Int:"+sr.nextInt());	
	}
}
