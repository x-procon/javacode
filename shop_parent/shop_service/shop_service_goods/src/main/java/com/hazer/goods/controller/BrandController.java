package com.hazer.goods.controller;

/**
 * @ClassName: BrandController
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-05 23:14
 **/

import com.hazer.goods.entity.Result;
import com.hazer.goods.entity.StatusCode;
import com.hazer.goods.pojo.Brand;
import com.hazer.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;

    /**
     * method:
     * description: 方法描述
     * @author Hazer
     * @date  23:37
     * @param
     * @return
     */
    @GetMapping("/findAll")
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return  new Result<List<Brand>>(true, StatusCode.OK,"查询成功",brandList);
    }
}
