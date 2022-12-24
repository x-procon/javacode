package cc.procon.model.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndexPo  implements Serializable {

    /**
     * 指标中文名
     */
    private String indexCnName;
    /**
     * 指标名称中文简称
     */
    private String indexShortName;
    /**
     * 签名,中文名的MD5生成，用来保证名称唯一
     */
    private String cnSignature;
    /**
     * 指标名称英文
     */
    private String indexEnName;
    /**
     * 指标编码
     */
    private String indexCode;
    /**
     * 来源
     */
    private String sourceName;
    /**
     * 数据来源-主数据名称
     */
    private String dataName;
    /**
     * 数据来源-主数据编码
     */
    private String dataClassifyCode;
    /**
     * 数据来源-值名称
     */
    private String valueName;
    /**
     * 数据来源-值编码
     */
    private String valueCode;
    /**
     * 频度
     */
    private String frequency;
    /**
     * 保留位数
     */
    private Integer places;
    /**
     * 指标状态 1:正常维护 2停止维护
     */
    private Integer status;
    /**
     * 衍生公式;
     */
    private String deriveFormula;
    /**
     * 是否对外，1：是，0：否
     */
    private Integer isForeign;
    /**
     * 维护方式 1:人工 2:爬虫 3:计算 4:对接;
     */
    private Integer maintainType;
    /**
     * 框架id
     */
    private String frameId;


    /**
     * 目标信息表id
     */
    private String infoTableId;
    /**
     * 目标信息表名
     */
    private String infoTableName;
    /**
     * 目标信息表名
     */
    private String infoTableEsName;
    /**
     * 目标数据表id
     */
    private String dataTableId;
    /**
     * 目标数据表名
     */
    private String dataTableName;
    /**
     * 目标数据表ES表名
     */
    private String dataTableEsName;
    /**
     * 单位
     */
    private String units;

    /**
     * 英文描述
     */
    private String enRemarks;

    /**
     * 中文描述
     */
    private String cnRemarks;

    private Integer isEnable;

}