package ir.fanap.loyalty.suna.config;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;



@Getter
@Entity
@Table(name = "CONTACTS")
@NoArgsConstructor
@Setter
@ToString
@SuperBuilder
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER", updatable = false, nullable = false, referencedColumnName = "USER_ID")
    private User user;
}
