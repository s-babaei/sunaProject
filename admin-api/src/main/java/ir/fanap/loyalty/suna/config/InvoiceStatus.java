package ir.fanap.loyalty.suna.config;


public enum InvoiceStatus {
    SUCCESSFUL("موفق"),
    UNSUCCESSFUL("ناموفق"),
    PENDING("در حال بررسی");

    InvoiceStatus(String persianValue) {
        this.persianValue = persianValue;
    }

    private String persianValue;

    public String getPersianValue() {
        return persianValue;
    }
}
