package ir.fanap.loyalty.suna.config;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

 import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "USER_ROLES")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends BaseEntity implements Serializable {
    @Transient
    private static final long serialVersionUID = -823365159107677806L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    protected String id;

    @ManyToOne
    private User user;

    private String role;




}
