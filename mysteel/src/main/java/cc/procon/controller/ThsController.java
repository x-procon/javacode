package cc.procon.controller;

import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping("/compensation")
    public void compensation(@RequestParam(value = "indexCode") String indexCode){
        String[] indexCodeArr = indexCode.split(",");
        for (int i = 0; i < indexCodeArr.length; i++) {
            log.info("总共：{}个指标需要补偿,当前补偿第{}个,指标编码：{}",indexCodeArr.length,i+1,indexCodeArr[i]);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("indexCode", indexCodeArr[i]);
            jsonObject.put("type",1);
            jsonObject.put("beginTime","2000-05-01");
            restTemplate.postForEntity("http://10.226.21.33/htf_api/damp_integrator/thsCompensation",jsonObject,Object.class);
        }


    }
}
