package ir.fanap.loyalty.suna.config;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

 import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    protected String id;

    @Setter
    @Column(unique = true, nullable = false)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    @Column(name = "LAST_CHANGE_PASSWORD_DATE")
    @Setter
    private Date lastChangePassword;

    private Date registerDate;

    @Setter
    private Date lastEditOn;

    private Date lastLoginDate;

    @Setter
    @Builder.Default
    private Boolean enable = true;

    @Setter
    private Long userId;

    @Setter
    private String ssoId;

    @Column(name = "USER_TYPE", insertable = false, updatable = false)
    private String userType;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private Set<Contact> contacts;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;


    public User(String id, String username) {
    }
}
