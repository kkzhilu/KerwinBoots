package com.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/12/7 10:41
 * description:  CodeFile lombok插件进行初始化
 * version:      V1.0
 * ******************************
 */
@Data
public class CodeFile {

    @TableField
    private String uuid;

    @TableField(value = "fileName")
    private String fileName;

    @TableField(value = "fileType")
    private String fileType;

    private String path;

    private String content;
}
