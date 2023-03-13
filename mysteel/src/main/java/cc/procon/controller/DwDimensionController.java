package cc.procon.controller;

import cc.procon.service.DwDimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author procon
 * @since 2023-03-07
 */
@RestController
@RequestMapping("dw/dimension")
public class DwDimensionController {

    @Autowired
    private DwDimensionService dwDimensionService;

    @RequestMapping("/update")
    public void update(@RequestParam(value = "tableName") String tableName){
        dwDimensionService.updateDimensionInfo(tableName);
    }
}
