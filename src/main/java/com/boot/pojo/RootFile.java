package com.boot.pojo;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/30 15:10
 * description:  根目录工程文件
 * version:      V1.0
 * ******************************
 */
public class RootFile {

    // uuid
    private String uuid;

    // fileName
    private String fileName;

    // 描述文件
    private String desc;

    // 树形目录
    private String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RootFile{" +
                "uuid='" + uuid + '\'' +
                ", fileName='" + fileName + '\'' +
                ", desc='" + desc + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
