package com.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * ******************************
 * author:       Kerwin
 * createTime:   2021/8/24 5:16
 * description:  ScriptDir
 * version:      V1.0
 * ******************************
 */
public class ScriptDir {

    @TableId
    private Long scriptDirId;

    @TableField(value = "eid")
    private Long eid;

    public Long getScriptDirId() {
        return scriptDirId;
    }

    public void setScriptDirId(Long scriptDirId) {
        this.scriptDirId = scriptDirId;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }
}
