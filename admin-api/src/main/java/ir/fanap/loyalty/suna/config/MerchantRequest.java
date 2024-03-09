package ir.fanap.loyalty.suna.config;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@Entity
@NoArgsConstructor
@SuperBuilder
@ToString
@Setter
public class MerchantRequest extends Request {
    private String merchantCode;
    private String apiToken;
    private String ssoId;
    private Long podId;
    private Long userId;
    private String username;
    private String name;




}
