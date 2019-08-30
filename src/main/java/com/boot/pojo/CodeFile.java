package com.boot.pojo;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/30 15:13
 * description:  CodeFile 文件内容
 * version:      V1.0
 * ******************************
 */
public class CodeFile {

    // uuid
    private String uuid;

    // fileName
    private String fileName;

    // fileType
    private String fileType;

    // path
    private String path;

    // content
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "CodeFile{" +
                "uuid='" + uuid + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", path='" + path + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
