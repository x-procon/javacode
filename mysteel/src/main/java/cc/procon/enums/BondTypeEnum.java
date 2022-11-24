package cc.procon.enums;

/**
 * @Author huang
 */
public enum BondTypeEnum {
    FUTURES(1, "期货"),
    SHARES(2, "股票"),
    BOND(3, "债券");

    private Integer code;
    private String value;

    BondTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String findValueByCode(Integer code) {
        for (BondTypeEnum v : values()) {
            if (v.code.equals(code)) {
                return v.value;
            }
        }
        return null;
    }
}
