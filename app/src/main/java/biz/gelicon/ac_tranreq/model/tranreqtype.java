package biz.gelicon.ac_tranreq.model;

public class tranreqtype {
    int id;
    String code;
    String name;
    String img;
    String color;
    String text;

    public tranreqtype(int id, String code, String name, String img, String color, String text) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.img = img;
        this.color = color;
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getColor() {
        return color;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}