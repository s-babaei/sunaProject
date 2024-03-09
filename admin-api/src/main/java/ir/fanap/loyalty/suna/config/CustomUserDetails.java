package ir.fanap.loyalty.suna.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CustomUserDetails extends CustomUser implements UserDetails {
    private final List<String> userRoles;

    private Merchant merchant;

    private String merchantId;

    public CustomUserDetails(CustomUser user, List<String> userRoles) {
        super(user);
        this.userRoles = userRoles;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.getEnable();
    }

    public <T> Optional<T> getParty(Class<T> type) {
        return Optional.of(type.cast(merchant));
    }
}
