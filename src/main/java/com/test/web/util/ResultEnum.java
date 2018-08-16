package com.test.web.util;

public enum ResultEnum {

	SUCCESS("100000", "操作成功"), FAIL_EXCEPTION("100001", "后台异常"), PARAM_NULL("100002", "参数不能为空"), PARAM_INVALID("100003", "参数校验不通过");

	private String code;

	private String msg;

	private ResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
