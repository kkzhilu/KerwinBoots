package com.boot.bean;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/11 16:33
 * description:  TestBean
 * version:      V1.0
 * ******************************
 */
public class TestBean {

    private Integer id;

    private String name;

    private TestNode testNode;

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

    public TestNode getTestNode() {
        return testNode;
    }

    public void setTestNode(TestNode testNode) {
        this.testNode = testNode;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", testNode=" + testNode +
                '}';
    }
}
