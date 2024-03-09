package ir.fanap.loyalty.suna.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
 import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

 import java.util.Date;

@Entity
@Table(name = "INVOICES")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INVOICE_DATE")
    private Date invoiceDate;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MERCHANT", referencedColumnName = "MERCHANT_ID")
    private Merchant merchant;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "TAX")
    private long tax;

    @Enumerated(EnumType.STRING)
    @Column(name = "INVOICE_STATUS")

    private InvoiceStatus invoiceStatus;
    @Column(name = "INVOICE_NAME")

    private String invoiceName;
    @Column(name = "DISCOUNT_AMOUNT")
    private long discountAmount;


}
