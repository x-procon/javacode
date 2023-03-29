package cc.procon.mysteel.sync.controller;

import cc.procon.mysteel.sync.service.SyncDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author procon
 * @since 2022-12-23
 */
@RestController
@RequestMapping("/sync")
public class SyncController {
    @Autowired
    private SyncDataService syncDataService;
    @RequestMapping("/index-frame")
    public void indexFrame(@RequestParam("pid") Integer pid){
        syncDataService.indexFrameDataSync(pid);
    }

    @RequestMapping("/index")
    public void indexFrame(){
        syncDataService.indexDataSync();
    }

}
