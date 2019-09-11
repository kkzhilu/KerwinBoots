package com.boot.bean;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/11 16:34
 * description:  TestNode
 * version:      V1.0
 * ******************************
 */
public class TestNode {

    private String node;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "TestNode{" +
                "node='" + node + '\'' +
                '}';
    }
}
