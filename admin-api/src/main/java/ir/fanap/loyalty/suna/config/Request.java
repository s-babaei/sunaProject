package ir.fanap.loyalty.suna.config;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

 import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "REQUESTS")
@NoArgsConstructor
@SuperBuilder
@ToString
public class Request extends BaseEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;

    private String mobile;

    private String otp;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @Enumerated(EnumType.STRING)
    private RequestMethodEnum requestMethodEnum;

    @Column(nullable = false)
    private int count = 0;
}
