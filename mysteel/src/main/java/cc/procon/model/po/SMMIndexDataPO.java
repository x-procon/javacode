package cc.procon.model.po;

import java.io.Serializable;

/**
 *  smm指标data表
 * @author YangHui
 * @since  2022-03-29
 */

public class SMMIndexDataPO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
    * quota_id
    */

    private String quotaId;

    /**
    * permission_state
    */

    private Integer permissionState;

    /**
    * calc_type
    */

    private Integer calcType;

    /**
    * data_date
    */

    private String dataDate;

    /**
    * data_value
    */

    private String dataValue;

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

    public SMMIndexDataPO() {
    }

    public SMMIndexDataPO(String quotaId, Integer permissionState, Integer calcType, String dataDate, String dataValue, Long isDelete, Long isQuality, Long dataCreateTime, Long dataUpdateTime) {
        this.quotaId = quotaId;
        this.permissionState = permissionState;
        this.calcType = calcType;
        this.dataDate = dataDate;
        this.dataValue = dataValue;
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

    public Integer getPermissionState() {
        return permissionState;
    }

    public void setPermissionState(Integer permissionState) {
        this.permissionState = permissionState;
    }

    public Integer getCalcType() {
        return calcType;
    }

    public void setCalcType(Integer calcType) {
        this.calcType = calcType;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
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