package cc.procon.model.po;

import lombok.Data;

import java.math.BigDecimal;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-01-29

*/
@Data
public class PpwTableDetail {
    private String id;

    private String tableName;

    private String exportTableName;

    private String tablePk;

    private String colMapping;

    private Integer pkType;

    private BigDecimal total;

    private String updatetime;

    private String tableCols;
}