package com.hazer.entity;

/**
 * 内容
 * @author Hazer
 * @since  2020-07-20 15:56
 */
public class Content {
    private String img;
    private String name;
    private String price;

    public Content() {

    }

    public Content(String img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Content{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
