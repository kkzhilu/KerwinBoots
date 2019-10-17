package com.boot.pojo;

import java.io.Serializable;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 15:41
 * description:  DbMqDemo
 * version:      V1.0
 * ******************************
 */
public class DbMqDemo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uuid
     */
    private String uuid;

    /**
     * execnums
     */
    private Integer execnums;

    /**
     * description
     */
    private String description;

    /**
     * publishtime
     */
    private Long publishtime;

    /**
     * status
     */
    private Integer status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Long publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExecnums() {
        return execnums;
    }

    public void setExecnums(Integer execnums) {
        this.execnums = execnums;
    }

    @Override
    public String toString() {
        return "DbMqDemo{" +
                "uuid='" + uuid + '\'' +
                ", execnums=" + execnums +
                ", description='" + description + '\'' +
                ", publishtime=" + publishtime +
                ", status=" + status +
                '}';
    }
}
