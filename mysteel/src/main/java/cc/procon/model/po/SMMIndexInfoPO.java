package cc.procon.model.po;

import java.io.Serializable;

/**
 *  smm api 指标信息表
 * @author YangHui
 * @since  2022-03-29
 */

public class SMMIndexInfoPO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * quota_id
     */

    private String quotaId;

    /**
     * quota_name
     */

    private String quotaName;

    /**
     * mark
     */

    private String mark;

    /**
     * unit
     */

    private String unit;

    /**
     * value_type
     */

    private String valueType;

    /**
     * source
     */

    private String source;

    /**
     * list_order
     */

    private Integer listOrder;

    /**
     * data_start
     */

    private String dataStart;

    /**
     * data_end
     */

    private String dataEnd;

    /**
     * frequency
     */

    private String frequency;

    /**
     * precision
     */

    private Integer precision;

    /**
     * type_code
     */

    private String typeCode;

    /**
     * type_code_all
     */

    private String typeCodeAll;

    /**
     * type_all
     */

    private String typeAll;

    /**
     * tags
     */

    private String tags;

    /**
     * auth_start
     */

    private String authStart;

    /**
     * auth_finish
     */

    private String authFinish;

    /**
     * auth_lang
     */

    private String authLang;

    /**
     * auth_module
     */

    private String authModule;

    /**
     * data_dur
     */

    private String dataDur;

    /**
     * spec
     */

    private String spec;

    /**
     * area
     */

    private String area;

    /**
     * data_state
     */

    private String dataState;

    /**
     * 是否有效
     */

    private Long isDelete;

    /**
     * 是否质检
     */

    private Long isQuality;

    /**
     * 数据创建时间
     */

    private Long dataCreateTime;

    /**
     * 数据更新时间
     */

    private Long dataUpdateTime;

    public SMMIndexInfoPO() {

    }

    public SMMIndexInfoPO(String quotaId, String quotaName, String mark, String unit, String valueType, String source, Integer listOrder, String dataStart, String dataEnd, String frequency, Integer precision, String typeCode, String typeCodeAll, String typeAll, String tags, String authStart, String authFinish, String authLang, String authModule, String dataDur, String spec, String area, String dataState, Long isDelete, Long isQuality, Long dataCreateTime, Long dataUpdateTime) {
        this.quotaId = quotaId;
        this.quotaName = quotaName;
        this.mark = mark;
        this.unit = unit;
        this.valueType = valueType;
        this.source = source;
        this.listOrder = listOrder;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
        this.frequency = frequency;
        this.precision = precision;
        this.typeCode = typeCode;
        this.typeCodeAll = typeCodeAll;
        this.typeAll = typeAll;
        this.tags = tags;
        this.authStart = authStart;
        this.authFinish = authFinish;
        this.authLang = authLang;
        this.authModule = authModule;
        this.dataDur = dataDur;
        this.spec = spec;
        this.area = area;
        this.dataState = dataState;
        this.isDelete = isDelete;
        this.isQuality = isQuality;
        this.dataCreateTime = dataCreateTime;
        this.dataUpdateTime = dataUpdateTime;
    }

    public String getQuotaId() {
        return quotaId;
    }

    public void setQuotaId(String quotaId) {
        this.quotaId = quotaId;
    }

    public String getQuotaName() {
        return quotaName;
    }

    public void setQuotaName(String quotaName) {
        this.quotaName = quotaName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getListOrder() {
        return listOrder;
    }

    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCodeAll() {
        return typeCodeAll;
    }

    public void setTypeCodeAll(String typeCodeAll) {
        this.typeCodeAll = typeCodeAll;
    }

    public String getTypeAll() {
        return typeAll;
    }

    public void setTypeAll(String typeAll) {
        this.typeAll = typeAll;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAuthStart() {
        return authStart;
    }

    public void setAuthStart(String authStart) {
        this.authStart = authStart;
    }

    public String getAuthFinish() {
        return authFinish;
    }

    public void setAuthFinish(String authFinish) {
        this.authFinish = authFinish;
    }

    public String getAuthLang() {
        return authLang;
    }

    public void setAuthLang(String authLang) {
        this.authLang = authLang;
    }

    public String getAuthModule() {
        return authModule;
    }

    public void setAuthModule(String authModule) {
        this.authModule = authModule;
    }

    public String getDataDur() {
        return dataDur;
    }

    public void setDataDur(String dataDur) {
        this.dataDur = dataDur;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public Long getIsQuality() {
        return isQuality;
    }

    public void setIsQuality(Long isQuality) {
        this.isQuality = isQuality;
    }

    public Long getDataCreateTime() {
        return dataCreateTime;
    }

    public void setDataCreateTime(Long dataCreateTime) {
        this.dataCreateTime = dataCreateTime;
    }

    public Long getDataUpdateTime() {
        return dataUpdateTime;
    }

    public void setDataUpdateTime(Long dataUpdateTime) {
        this.dataUpdateTime = dataUpdateTime;
    }
}