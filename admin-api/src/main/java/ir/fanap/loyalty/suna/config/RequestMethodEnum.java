package ir.fanap.loyalty.suna.config;

import lombok.Getter;

@Getter
public enum RequestMethodEnum {
    POS("پوز"),
    PORTAL("پورتال"),
    FILE("فایل"),
    WEBSERVICE("وب سرویس"),
    CARDHOLDER("دارنده‌کارت"),
    OTHER("سایر");

    private final String persianValue;

    RequestMethodEnum(String persianValue) {
        this.persianValue = persianValue;
    }

}
