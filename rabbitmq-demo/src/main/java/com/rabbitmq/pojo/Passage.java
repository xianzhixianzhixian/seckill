package com.rabbitmq.pojo;

public class Passage {

    private Integer id;
    private String content;

    public Passage() {
    }

    public Passage(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Passage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
