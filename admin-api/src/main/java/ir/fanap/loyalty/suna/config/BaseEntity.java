package ir.fanap.loyalty.suna.config;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

 import java.io.Serializable;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", updatable = false, nullable = false, referencedColumnName = "id")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATED_BY", nullable = false, referencedColumnName = "id")
    private User updatedBy;

    @Column(name = "CREATE_DATE", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate = new Date();

    @Column(name = "UPDATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateDate = new Date();

    @Column(name = "IS_DELETED")
    @Builder.Default
    private Boolean isDeleted = false;

}
    