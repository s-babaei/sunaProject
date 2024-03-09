package ir.fanap.loyalty.suna.config;


import lombok.Getter;

@Getter
public enum RequestStatus {
        PENDING("درانتظار"), ACTIVE("فعال"), EXPIRED("منقضی"), INACTIVE("غیرفعال"), DONE("انجام شده");

        RequestStatus(String persianValue) {
            this.persianValue = persianValue;
        }

        private final String persianValue;

}
