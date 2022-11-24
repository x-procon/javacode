package cc.procon.controller;

import cc.procon.service.ThsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author procon
 * @since 2022-11-23
 */
@Slf4j
@RestController
@RequestMapping("/ths")
public class ThsController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ThsService thsService;

    @RequestMapping("/compensation")
    public void compensation(@RequestParam(value = "start") String start,@RequestParam(value = "end") String end){
        thsService.compensationRangeIndexFromIndex(201,500);


    }
}
