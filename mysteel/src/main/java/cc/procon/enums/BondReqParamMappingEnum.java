package cc.procon.enums;

/**
 * 指标英文名称和请求同花顺接口参数的映射关系枚举
 *
 * @Author huang
 */
public enum BondReqParamMappingEnum {
    //期货指标日行情请求参数
    DAILY_MARKET("行情指标|日行情", ""),

    //期货指标周行情请求参数
    WEEKLY_MARKET("行情指标|周行情", ""),

    //期货指标月行情请求参数
    MONTHLY_MARKET("行情指标|月行情", ""),

    //会员持仓请求参数
    MEMBER_POSITIONS("会员持仓", "1001"),

    //仓单指标请求参数
    WAREHOUSE_RECEIPTS("仓单指标", ""),

    //期货指标区间行情请求参数
    RANGE_MARKET("行情指标|区间行情", ""),

    //国债期货专用请求参数
    THS_CTD_FUTURE("国债期货专用", "100"),

    //合约基础请求参数
    CONTRACT_BASIS("合约基础", "");


    private String code;
    private String value;

    BondReqParamMappingEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String findValueByCode(String code) {
        for (BondReqParamMappingEnum v : values()) {
            if (v.code.equals(code)) {
                return v.value;
            }
        }
        return null;
    }
}
