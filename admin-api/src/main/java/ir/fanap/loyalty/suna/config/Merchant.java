package ir.fanap.loyalty.suna.config;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

 import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="MERCHANTS")
@SuperBuilder
@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
public class Merchant extends BaseEntity {


    @Id
    private String id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER", referencedColumnName = "USER_ID")
    private User user;

    @Column(name ="ACTIVE")
     private boolean active = true;

    @Column(name ="REAGENT")
    private String reagent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="REGISTER_DATE")
    private Date registerDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="UPDATE_DATE")
    private Date updateDate;


    @Transient
    private String merchantType = getClass().getSimpleName();

    @OneToOne(mappedBy = "merchant", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name ="MERCHANT_INFO")
    private MerchantInfo merchantInfo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MERCHANT_REQUEST",referencedColumnName = "MERCHANT_REQUEST_ID")
    private MerchantRequest merchantRequest;

    @Column(name ="MERCHANT_NAME")
    private String merchantName;

    @Column(name ="MERCHANT_ALIAS")
    private String merchantAlias;

    @Column(name ="IS_BRANCH")
    private Boolean isBranch = false;

    @Column(name ="IS_POD_MERCHANT")
    private Boolean isPodMerchant = false;


    @Column(name ="EXTERNAL_BRANCH_CODE")
    private String externalBranchCode;

    @Column(name ="MERCHANT_CODE")
    private String merchantCode;


    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "MERCHANT_DATAS", referencedColumnName = "ID")
    private Set<MerchantData> merchantDatas;

    @OneToOne(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Column(name ="MERCHANT_SETTING")
    private MerchantSetting merchantSetting;

    @OneToOne
    @Column(name ="PARENT_MERCHANT")
    private Merchant parentMerchant;


    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "CONTRACTS", referencedColumnName = "ID")
    private Set<Contract> contracts;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MERCHANT_CATEGORY",referencedColumnName = "MERCHANT_CATEGORY_ID")
    private MerchantCategory merchantCategory;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOM_MERCHANT_CATEGORY",referencedColumnName = "CUSTOM_MERCHANT_CATEGORY_ID")
    private MerchantCategory customMerchantCategory;

    @Column(name ="RATING")
    private Double rating;

    @Column(name ="DYNAMIC_LEVELING")
    private Boolean dynamicLeveling = false;

    public Merchant(String id) {
        this.id = id;
    }



}

