package ir.fanap.loyalty.suna.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomUser {
    private String id;
    private String username;
    private String password;
    private Boolean enable;


    public CustomUser(CustomUser user) {
    }

    public CustomUser(String id, String username) {
    }
}
