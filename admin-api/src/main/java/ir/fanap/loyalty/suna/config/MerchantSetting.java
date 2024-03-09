package ir.fanap.loyalty.suna.config;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;


@Entity
@Table(name = "MERCHANTS_SETTING")
@ToString
public class MerchantSetting extends BaseEntity {

    @Id
    private String id;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Merchant merchant;

    private boolean sendNotification = true;

    private Boolean productTax = false;
    private String timeEdgeCsv;

    private String registerCardHolderSms;




}
