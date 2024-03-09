package ir.fanap.loyalty.suna.config;

 import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

 import java.util.Date;

@Entity
@Table(name = "MERCHANTS_INFO")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class MerchantInfo extends BaseEntity {

    @Id
    private String id;

    @OneToOne
    @MapsId
    private Merchant merchant;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String shabaNo;
    private String lastNameEn;
    private String firstNameEn;
    private String rentContractDueDate;
    private String companyNationalCode;
    private String financialName;
    private String accountNo;
    private String projectId;
    private Double latitude;
    private Double longitude;
    private String city;
    private String state;
    private String nationalCode;


    private Boolean isPremium = false;

    @Column(nullable = true)
    private long remainSMS;

    private String merchantWebAddress;
    @Column(name = "TOTAL_CUSTOMERS_COUNT")
    private long totalCustomersCount;

    private Long advertisePackCount = 0L;
    private Long servicePackCount = 0L;
    private Long advertiseSmsCount = 0L;
    private Long serviceSmsCount = 0L;

    private String instagramId;
    private String telegramId;

    private Boolean messageOnLowCredit = true;
    private String description;

    private Long podId;
    private Long userId;
    private String ssoId;
    private String apiToken;

    private String clientId;
    private String clientSecret;
    private String privateKey;
    private Long defaultProductId;
    private Long entityId;
    private String internalNumber;
    private Boolean activeAutoCashBack;
    private Boolean autoMerchant = false;

    private String introducerMobile;

    private Boolean terminalFlag;
    private String guildCode;

    private Boolean giftShelfPolicyAccepted = false;
    @Temporal(TemporalType.TIMESTAMP)
    private Date giftShelfPolicyAcceptDate = null;

    private String accountId;

    private Integer podStateCode;
    private Integer podCityCode;








}
