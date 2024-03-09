package ir.fanap.loyalty.suna.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import ir.fanap.loyalty.suna.config.config.CustomUserDetails;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
@NoArgsConstructor
public class TokenAuthenticationService {
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    private static final String SECRET = "7JMr8FQDyrSFdGQTbMWF";
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";
    private static final String ROLE_LIST = "roleList";
    private static final String USER_DETAIL = "userDetail";



    public static String generateToken( String username,String userId, List<String> roleList, Merchant merchant) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put(ROLE_LIST, roleList);
        CustomUserDetails userDetails = new CustomUserDetails(new CustomUser(userId, username), null);
        userDetails.setMerchantId(String.valueOf(merchant.getId()));
        claims.put(USER_DETAIL, userDetails);
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return TOKEN_PREFIX + " " + jwt;
    }

}
