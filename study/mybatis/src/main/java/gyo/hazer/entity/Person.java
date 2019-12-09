package gyo.hazer.entity;

/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.entity
 * @ClassName: Person
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/9 22:27
 * @Version: 1.0
 */
public class Person {
    int id;
    int age;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
