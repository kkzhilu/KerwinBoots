package com.boot.pojo;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 11:12
 * description:  Student
 * version:      V1.0
 * ******************************
 */
public class Student {

    private Integer id;

    private String name;

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
