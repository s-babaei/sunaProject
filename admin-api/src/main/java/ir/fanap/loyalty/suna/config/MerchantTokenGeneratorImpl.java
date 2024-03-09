package ir.fanap.loyalty.suna.config;


  import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantTokenGeneratorImpl implements MerchantTokenGenerator {


    @Override
    public String generateToken(String username, String userId, List<String> roleList, Merchant merchant) {
        return TokenAuthenticationService.generateToken(username, userId, roleList, merchant);
    }
}
