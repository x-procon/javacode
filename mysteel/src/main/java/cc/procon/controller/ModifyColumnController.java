package cc.procon.controller;

import cc.procon.service.ModifyColumnService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 修改列
 *
 * @author procon
 * @since 2022-09-20
 */
@RestController
public class ModifyColumnController {

    @Autowired
    private ModifyColumnService modifyColumnService;

    @RequestMapping("/modifyTime")
    public void modifyColumn(@Param("tableName") String tableName){
        modifyColumnService.modifyTime(tableName);
    }

    @RequestMapping("/modifyPage")
    public void modifyPage(){
        modifyColumnService.mbDataPage();
    }


}
