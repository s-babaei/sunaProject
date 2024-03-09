package ir.fanap.loyalty.suna.config;

import java.util.List;

public interface TokenBusiness {
    List<String> getAccess(String username, String token, long tokenExpire);
}
