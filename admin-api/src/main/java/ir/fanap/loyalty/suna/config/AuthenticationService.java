package ir.fanap.loyalty.suna.config;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


import ir.fanap.loyalty.suna.config.config.CustomUserDetails;
import ir.fanap.loyalty.suna.exeption.AuthorizationException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {


    private final TokenRepository tokenRepository;
    private final TokenBusiness tokenBusiness;
    private final UserBehaviourBusiness userBehaviourBusiness;


    private static final String SECRET = "7JMr8FQDyrSFdGQTbMWF";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";
    private static final String ROLE_LIST = "roleList";
    private static final String USER_DETAIL = "userDetail";

    public void doAuthenticate(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        log.info("auth token={}", token);
        if (Objects.isNull(token)) {
            log.debug("token is empty!!!");
            return;
        }

        Optional<Token> tokenOptional = tokenRepository.findByTokenAndValidTrue(token);
        if (!tokenOptional.isPresent()) {
            log.error("not valid token");
            throw new AuthorizationException("not authorized");
        }

//        if (!userBehaviourBusiness.isActiveUser(token)) {
//            log.error("user is inactive");
//            throw new AuthorizationException("not authorized");
//        }

        Claims body;
        try {
            body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        } catch (Exception ex) {
            throw new AuthorizationException("not authorized");
        }

        String user = body.getSubject();
//        List<String> access = tokenBusiness.getAccess(user, token, body.getExpiration().getTime());

        Map<String, String> userDetail = (Map<String, String>) body.get(USER_DETAIL);
        log.info("username is {}", userDetail.get("username"));
        User merchantUser = new User(userDetail.get("id"), userDetail.get("username"));
        //i change it this line by adding merchant maybe it we have another result.....i shouldm check it!
        CustomUserDetails principal = new CustomUserDetails(new CustomUser(merchantUser.getId(), merchantUser.getUsername()), null);
        List<GrantedAuthority> authorityList = new ArrayList<>();
//        access.forEach(o -> authorityList.add(new SimpleGrantedAuthority(o)));
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorityList.add(new SimpleGrantedAuthority("ROLE_ASSOCIATE_ADMIN"));
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(principal, null, authorityList));
    }


}
