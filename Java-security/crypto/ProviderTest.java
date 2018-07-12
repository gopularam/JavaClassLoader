package crypto;

import java.security.Provider;
import java.security.Security;

public class ProviderTest {
    public static void main(String[] args) {
        Provider[] pp = Security.getProviders();

        for(Provider p: pp) {
            System.out.println("provider: "+p.toString());
        }
        
    }
}