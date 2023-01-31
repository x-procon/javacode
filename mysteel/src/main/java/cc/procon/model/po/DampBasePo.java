package cc.procon.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desciption 资产po的基类
 * @Author liuyonghua
 * @Date 2022/4/13 9:49
 **/
@Data
public class DampBasePo implements Serializable {


    private String id;
    private Long createUserId;
    private String createUserName;
    private Long createTime;
    private Long updateUserId;
    private String updateUserName;
    private Long updateTime;


    private Integer isDelete;
}
