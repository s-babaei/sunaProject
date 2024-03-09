package ir.fanap.loyalty.suna.config;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class SubscriptionInvoice extends Invoice {

    private String id;



    private long subscriptionAmount;



}
