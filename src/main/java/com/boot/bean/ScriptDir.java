package com.boot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/12/30 10:20
 * description:  ScriptDir 脚本目录
 * version:      V1.0
 * ******************************
 */
@Data
public class ScriptDir implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * script_dir_id
     */
    private Integer scriptDirId;

    /**
     * eid
     */
    private Integer eid;

    /**
     * projectid
     */
    private Integer projectid;

    /**
     * parent_dir_id
     */
    private Integer parentDirId;

    /**
     * script_dir_name
     */
    private String scriptDirName;

    /**
     * script_dir_creator_userid
     */
    private Integer scriptDirCreatorUserid;

    /**
     * script_dir_updater_userid
     */
    private Integer scriptDirUpdaterUserid;

    /**
     * script_dir_status
     */
    private Integer scriptDirStatus;

    /**
     * script_dir_version
     */
    private Integer scriptDirVersion;

    /**
     * createtime
     */
    private Long createtime;

    /**
     * updatetime
     */
    private Long updatetime;

    /**
     * is_delete
     */
    private Integer whetherDelete;

    /**
     * dir_type
     */
    private Integer dirType;

    public ScriptDir() { }
}
