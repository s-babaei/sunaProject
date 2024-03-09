package ir.fanap.loyalty.suna.config;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "TOKENS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    @Id
    @Column(length = 755)
    protected String token;
    private String userId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    private boolean valid = true;

}
