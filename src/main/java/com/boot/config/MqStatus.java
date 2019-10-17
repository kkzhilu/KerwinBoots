package com.boot.config;

public enum MqStatus {

	/** 未设置 **/
	NOT_SET      (-2 , "未设置"),

	/** 异常重试 **/
	ERROR_AGAIN  (-1 , "异常重试"),

	/** 已提交 **/
	HAVA_COMMIT  (-1 , "已提交"),

	/** 进行中 **/
	DONEING      (1  , "进行中"),

	/** 已完成 **/
	DONE         (2  , "已完成"),

	/** 异常 **/
	ERROR        (3  , "异常"),
	;

    private int    status;
    private String descr;

    MqStatus(Integer status, String descr) {
        this.status = status;
        this.descr = descr;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
}
