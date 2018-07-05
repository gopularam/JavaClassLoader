package crypto;

import java.security.Security;

public class ProviderTest {
    public static void main(String[] args) {
        Provider[] pp = Security.getProviderswewe();

        for(Provider p: pp) {
            System.out.println("provider: "+p.toString());
        }
        
    }
}