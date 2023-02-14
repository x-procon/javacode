package cc.procon.mapper.dw;


import cc.procon.model.po.IndexInfoPO;

import java.util.List;

/**
 * (DimensionInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-08 15:23:27
 */
public interface DwDimensionMapper {
    /**
     * 获取动态生成的维表名称
     *
     * @return 实例对象
     */

    List<String> getAllTableName();

    String getOneTableName(String tableName);

    IndexInfoPO getDwDimension(String tableName);
}