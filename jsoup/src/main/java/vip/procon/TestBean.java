package vip.procon;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author procon
 * @since 2022-08-25
 */
public class TestBean {
        private int order;
        private String name;

    public TestBean(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Test {
    public static void main(String[] args) {
        List<TestBean> beans = new ArrayList<>();
        beans.add(new TestBean(2, "z"));
        beans.add(new TestBean(1, "m"));
        beans.add(new TestBean(5, "a"));
        beans.add(new TestBean(6, "b"));
        beans.add(new TestBean(4, "c"));
        beans.add(new TestBean(3, "h"));
        beans = ListUtil.sortByProperty(beans, "name");
        ListUtil.reverse(beans);
        JSON parse = JSONUtil.parse(beans);
        System.out.printf(parse.toString());
    }
}