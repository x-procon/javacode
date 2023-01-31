package cc.procon.controller;

import cc.procon.service.DimDeriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author procon
 * @since 2023-01-18
 */
@RestController
public class DimDeriveController {
    @Autowired
    private DimDeriveService dimDeriveService;
    @RequestMapping("/dimDerive")
    public void mergeInto(@RequestParam("tableName") String tableName, @RequestParam("deriveId") String deriveId){
        dimDeriveService.mergeInto(tableName,deriveId);
    }
}
