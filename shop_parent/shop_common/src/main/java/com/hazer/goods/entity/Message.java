package com.hazer.goods.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/*****
 * @Author: Hazer
 * @Description: entity:MQ消息封装
 ****/

@Data
public class Message implements Serializable{

    //执行的操作  1：增加，2：修改,3：删除
    private int code;

    //数据
    private Object content;

    //routeKey
    @JSONField(serialize = false)
    private String routeKey;

    //交换机
    @JSONField(serialize = false)
    private String exchange;

    public Message() {
    }

    public Message(int code, Object content) {
        this.code = code;
        this.content = content;
    }

    public Message(int code, Object content, String routeKey, String exchange) {
        this.code = code;
        this.content = content;
        this.routeKey = routeKey;
        this.exchange = exchange;
    }


}
