package com.mvc.kgdemo.domain;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * jpa自动生成表
 */

@Entity
@javax.persistence.Table(name = "t_book")
public class Book {

    /**
     * PS：@GeneratedValue注解的strategy属性提供四种值：
     –AUTO： 主键由程序控制，是默认选项，不设置即此项。
     –IDENTITY：主键由数据库自动生成，即采用数据库ID自增长的方式，Oracle不支持这种方式。
     –SEQUENCE：通过数据库的序列产生主键，通过@SequenceGenerator 注解指定序列名，mysql不支持这种方式。
     –TABLE：通过特定的数据库表产生主键，使用该策略可以使应用更易于数据库移植。
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(length=100)
    private String name;

    @Column(length=50)
    private String author;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}
