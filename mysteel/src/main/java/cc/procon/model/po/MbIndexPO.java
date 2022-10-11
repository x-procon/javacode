package cc.procon.model.po;

/**
 * 钢联指标PO
 *
 * @author procon
 * @since 2022-09-23
 */

public class MbIndexPO {

    private String indexCode;
    private String dataDate;
    private String publishTime;
    private Long dataCreateTime;
    private Long dataUpdateTime;



    private String msId;

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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


    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }
}
