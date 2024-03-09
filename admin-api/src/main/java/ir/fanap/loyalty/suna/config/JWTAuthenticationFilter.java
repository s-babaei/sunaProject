package ir.fanap.loyalty.suna.config;

 import ir.fanap.loyalty.suna.exeption.AuthorizationException;
 import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {


        try {
            authenticationService.doAuthenticate(httpServletRequest);
            filterChain.doFilter(httpServletRequest, httpServletResponse);

        } catch (AuthorizationException ex) {
            httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        }
    }
}
