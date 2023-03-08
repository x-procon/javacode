package cc.procon.controller;

import cc.procon.service.OdsDimensionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author procon
 * @since 2023-03-07
 */
@RestController
@RequestMapping("ods/dimension")
public class OdsDimensionController {

    @Autowired
    private OdsDimensionInfoService odsDimensionInfoService;

    @RequestMapping("/update")
    public void update(@RequestParam(value = "tableName") String tableName){
        odsDimensionInfoService.updateDimensionInfo(tableName);
    }
}
