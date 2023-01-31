package cc.procon.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desciption 字段
 * @Author liuyonghua
 * @Date 2022/7/12 11:14
 **/
@Data
public class DimDeriveFieldVo implements Serializable {

    /**
     * 主键
     */
    private String id;
    /**
     * 字段名
     */
    private String name;
    /**
     * 字段中文名
     */
    private String cnName;

    public DimDeriveFieldVo() {
    }

    public DimDeriveFieldVo(String name) {
        this.name = name;
    }
}
