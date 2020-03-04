package com.hazer.gyo.hazer.springboot.entity;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.springboot.entity
 * @ClassName: Person
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/23 22:15
 * @Version: 1.0
 */
@Component
//@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:person.properties"})
@Validated
public class Person {
    @Email
    private String name;

    private int age;
    private List<String> list;
    private String[] array;
    private Map<String,Object> maps;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", array=" + Arrays.toString(array) +
                ", maps=" + maps +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }
}
