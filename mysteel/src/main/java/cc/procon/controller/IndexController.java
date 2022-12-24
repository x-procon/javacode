package cc.procon.controller;

import cc.procon.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author procon
 * @since 2022-12-23
 */
@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/batchUpdate")
    public void batchUpdate(){
        indexService.updateIndexSort();
    }

}
