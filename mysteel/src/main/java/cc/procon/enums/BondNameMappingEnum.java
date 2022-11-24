package cc.procon.enums;

/**
 * 指标名称和指标英文名称的映射关系枚举
 * @Author huang
 */
public enum BondNameMappingEnum {
    //期货指标日行情
    THS_BASIS_FUTURE("ths_basis_future", "基差"),
    THS_FUTURE_PREMIUM_AND_DISCOUNT_FUTURE("ths_future_premium_and_discount_future", "期货升贴水"),
    THS_PRE_CLOSE_FUTURE("ths_pre_close_future", "前收盘价"),

    THS_PRE_SETTLE_FUTURE("ths_pre_settle_future", "前结算价"),
    THS_OPEN_PRICE_FUTURE("ths_open_price_future", "开盘价"),
    THS_HIGH_PRICE_FUTURE("ths_high_price_future", "最高价"),

    THS_LOW_FUTURE("ths_low_future", "最低价"),
    THS_CLOSE_PRICE_FUTURE("ths_close_price_future", "收盘价"),
    THS_SETTLE_FUTURE("ths_settle_future", "结算价"),

    THS_TRANS_AVG_PRICE_FUTURE("ths_trans_avg_price_future", "成交均价"),
    THS_CHG_FUTURE("ths_chg_future", "涨跌"),
    THS_SETTLE_CHG_FUTURE("ths_settle_chg_future", "涨跌(结算价)"),

    THS_CLOSE_CHG_FUTURE("ths_close_chg_future", "涨跌(收盘价)"),
    THS_CHG_RATIO_FUTURE("ths_chg_ratio_future", "涨跌幅"),
    THS_SETTLE_CHG_RATIO_FUTURE("ths_settle_chg_ratio_future", "涨跌幅(结算价)"),

    THS_CLOSE_CHG_RATIO_FUTURE("ths_close_chg_ratio_future", "涨跌幅(收盘价)"),
    THS_SWING_D_FUTURE("ths_swing_d_future", "日振幅"),
    THS_LIMIT_UP_FUTURE("ths_limit_up_future", "涨停价"),

    THS_LIMIT_DOWN_FUTURE("ths_limit_down_future", "跌停价"),
    THS_POSITION_CHG_FUTURE("ths_position_chg_future", "持仓变化"),
    THS_VOL_FUTURE("ths_vol_future", "成交量"),

    THS_AMT_FUTURE("ths_amt_future", "成交额"),
    THS_OPEN_INTEREST_FUTURE("ths_open_interest_future", "持仓量"),
    THS_POSITION_AMOUNT_FUTURE("ths_position_amount _future", "沉淀资金"),
    THS_CAPITAL_FLOW_FUTURE("ths_capital_flow_future", "资金流向"),

    //期货指标周行情
    THS_CLOSE_W_FUTURE("ths_close_w_future", "周收盘价"),
    THS_SETTLE_W_FUTURE("ths_settle_w_future", "周结算价"),
    THS_HIGH_W_FUTURE("ths_high_w_future", "周最高价"),
    THS_LOW_W_FUTURE("ths_low_w_future", "周最低价"),
    THS_AVG_PRICE_W_FUTURE("ths_avg_price_w_future", "周成交均价"),
    THS_VOL_W_FUTURE("ths_vol_w_future", "周成交量"),
    THS_OI_W_FUTURE("ths_oi_w_future", "周持仓量"),
    THS_OPEN_W_FUTURE("ths_open_w_future", "周开盘价"),
    THS_CHG_W_FUTURE("ths_chg_w_future", "周涨跌"),
    THS_CHG_RATIO_W_FUTURE("ths_chg_ratio_w_future", "周涨跌幅"),
    THS_POSITION_CHG_W_FUTURE("ths_position_chg_w_future", "周持仓变化"),

    //期货指标月行情
    THS_CLOSE_M_FUTURE("ths_close_m_future", "月收盘价"),
    THS_SETTLE_M_FUTURE("ths_settle_m_future", "月结算价"),
    THS_HIGH_M_FUTURE("ths_high_m_future", "月最高价"),
    THS_LOW_M_FUTURE("ths_low_m_future", "月最低价"),
    THS_AVG_PRICE_M_FUTURE("ths_avg_price_m_future", "月成交均价"),
    THS_VOL_M_FUTURE("ths_vol_m_future", "月成交量"),
    THS_OI_M_FUTURE("ths_oi_m_future", "月持仓量"),
    THS_OPEN_M_FUTURE("ths_open_m_future", "月开盘价"),
    THS_CHGM_FUTURE("ths_chgm_future", "月涨跌"),
    THS_CHG_RATIO_M_FUTURE("ths_chg_ratio_m_future", "月涨跌幅"),
    THS_POSITION_CHGM_FUTURE("ths_position_chgm_future", "月持仓变化"),

    //会员持仓
    THS_MEMBER_VOL_FUTURE("ths_member_vol_future", "会员持仓成交量"),
    THS_MEMBER_VOL_CHG_FUTURE("ths_member_vol_chg_future", "成交量增减"),
    THS_VOL_RANK_FUTURE("ths_vol_rank_future", "成交量排名"),
    THS_LONG_VOL_FUTURE("ths_long_vol_future", "多单量"),
    THS_LONG_VOL_CHANGE_FUTURE("ths_long_vol_change_future", "多单量增减"),
    THS_LONG_VOL_RANK_FUTURE("ths_long_vol_rank_future", "多单量排名"),
    THS_SHORT_VOL_FUTURE("ths_short_vol_future", "空单量"),
    THS_SHORT_VOL_CHANGE_FUTURE("ths_short_vol_change_future", "空单量增减"),
    THS_SHORT_VOL_RANK_FUTURE("ths_short_vol_rank_future", "空单量排名"),

    //仓单指标
    THS_REG_WAREHOUSE_RECEIPTS_NUM_FUTURE("ths_reg_warehouse_receipts_num_future", "注册仓单数量"),

    //期货指标区间行情
    THS_HIGH_INT_FUTURE("ths_high_int_future", "区间最高价"),
    THS_LOW_INT_FUTURE("ths_low_int_future", "区间最低价"),
    THS_CHG_INT_FUTURE("ths_chg_int_future", "区间涨跌"),
    THS_INT_CHG_RATIO_FUTURE("ths_int_chg_ratio_future", "区间涨跌幅"),
    THS_DAILY_AVG_VOL_INT_FUTURE("ths_daily_avg_vol_int_future", "区间日均成交量"),
    THS_OPEN_INT_FUTURE("ths_open_int_future", "区间开盘价"),
    THS_CLOSE_INT_FUTURE("ths_close_int_future", "区间收盘价"),
    THS_VOL_INT_FUTURE("ths_vol_int_future", "区间成交量"),
    THS_POSITION_INT_FUTURE("ths_position_int_future", "区间持仓量"),
    THS_OI_CHG_INT_FUTURE("ths_oi_chg_int_future", "区间持仓变化"),

    //国债期货专用
    THS_CTD_FUTURE("ths_ctd_future", "CTD"),

    //合约基础
    THS_LAST_TD_DATE_FUTURE("ths_last_td_date_future", "最后交易日"),
    THS_LAST_DELIVERY_DATE_FUTURE("ths_last_delivery_date_future", "最后交割日");

    private String code;
    private String value;

    BondNameMappingEnum(String code, String value) {
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
        for (BondNameMappingEnum v : values()) {
            if (v.code.equals(code)) {
                return v.value;
            }
        }
        return null;
    }
}
