package ir.fanap.loyalty.suna.config;





import java.util.List;

public interface MerchantTokenGenerator {
    String generateToken(String username, String userId, List<String> roleList, Merchant merchant);
}
