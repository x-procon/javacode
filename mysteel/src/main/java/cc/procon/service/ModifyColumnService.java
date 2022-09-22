package cc.procon.service;

import cc.procon.mapper.ModifyColumnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author procon
 * @since 2022-09-20
 */
@Service
public class ModifyColumnService {

    @Autowired
    private ModifyColumnMapper modifyColumnMapper;

    public void modifyColumn(){

        List<String> tableNameList = modifyColumnMapper.queryTableName();
        for(String tableName : tableNameList){
            //更新表字段默认值
            modifyColumnMapper.upDateDataTime(tableName);

        }
    }

}
