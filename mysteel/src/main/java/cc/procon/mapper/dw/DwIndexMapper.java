package cc.procon.mapper.dw;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author procon
 * @since 2022-12-23
 */
@Mapper
public interface DwIndexMapper {
    /**
     * 根据指标id查询指标
     * @param ids id列表
     * @return 指标id列表
     */
    List<String> findByIndexIds(@Param("ids")List<String> ids);
}
