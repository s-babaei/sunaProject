package ir.fanap.loyalty.suna.config;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import java.util.Date;

@Entity
@Table(name = "MERCHANTS_DATA")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MerchantData extends BaseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name ="ID")
    private String id;




    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MERCHANT_ID")
    private Merchant merchant;

    private int terminalCount;
    private int activeTerminalsCount;
    private long newCustomerCount;
    private long activeCustomersCount;
    protected long purchaseCount;
    protected long purchaseAmount;
    private long discountCount;
    protected long discountAmount;
    private long couponCount;
    private long couponAmount;
    private long averageReturn;
    protected Date transactionDate;
    protected long totalPurchaseCount=0;
    protected long totalPurchaseAmount=0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    protected int year;





}
