package cc.procon.controller;

import cc.procon.service.SMMIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 上海有色
 *
 * @author procon
 * @since 2022-10-12
 */
@RestController
@RequestMapping("/smm")
public class SMMController {

    @Autowired
    private SMMIndexService smmIndexService;

    @RequestMapping("/initData")
    public void initData(){
        smmIndexService.getAllSmmIndexData();
    }
}
