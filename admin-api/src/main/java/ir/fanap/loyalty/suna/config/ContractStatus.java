package ir.fanap.loyalty.suna.config;

public enum ContractStatus {
    EXPIRED("منقضی شده"), RUNNING("فعال"), RESERVE("رزرو");

    ContractStatus(String persianValue) {
        this.persianValue = persianValue;
    }

    private String persianValue;

    public String getPersianValue() {
        return persianValue;
    }
}
