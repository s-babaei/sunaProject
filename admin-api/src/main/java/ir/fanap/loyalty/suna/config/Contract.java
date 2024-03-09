package ir.fanap.loyalty.suna.config;


 import jakarta.persistence.*;
 import lombok.*;
import org.hibernate.annotations.GenericGenerator;

 import java.util.Date;

@Entity
@Table(name = "CONTRACTS")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract extends BaseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MERCHANT", referencedColumnName = "MERCHANT_ID")
    private Merchant merchant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBSCRIPTION_INVOICE", referencedColumnName = "SUBSCRIPTION_INVOICE_ID")
    private SubscriptionInvoice subscriptionInvoice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_MEMBERSHIP_DATE")
    private Date startMembershipDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_MEMBERSHIP_DATE")
    private Date endMembershipDate;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONTRACT_STATUS")
    private ContractStatus contractStatus;


}
