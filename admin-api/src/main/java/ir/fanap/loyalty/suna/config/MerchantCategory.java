package ir.fanap.loyalty.suna.config;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

 import java.util.Date;

@Entity
@Table(name = "MERCHANTS_CATEGORY")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MerchantCategory extends BaseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "CODE")
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHANGE_DATE")
    private Date changeDate;

    @Column(name = "VALID")
    private Boolean valid;


}
