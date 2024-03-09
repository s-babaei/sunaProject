package ir.fanap.loyalty.suna.config;

public enum Gender {
    MALE("مرد"),FEMALE("زن"),NONE("نامشخص");

    public static Gender convertGender(int code) {
        switch (code) {
            case 1:
                return MALE;
            case 0:
                return FEMALE;
            default:
                return NONE;
        }
    }

    Gender(String persianValue) {
        this.persianValue = persianValue;
    }

    private String persianValue;

    public String getPersianValue() {
        return persianValue;
    }
}
