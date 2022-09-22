package cc.procon.controller;

import cc.procon.service.ModifyColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 修改列
 *
 * @author procon
 * @since 2022-09-20
 */
@RestController("/test")
public class ModifyColumnController {

    @Autowired
    private ModifyColumnService modifyColumnService;

    @RequestMapping("/modifyColumn")
    public void modifyColumn(){
        modifyColumnService.modifyColumn();
    }
}
