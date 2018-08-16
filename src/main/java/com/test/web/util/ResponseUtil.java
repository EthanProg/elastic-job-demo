package com.test.web.util;

import com.alibaba.fastjson.JSONObject;

public class ResponseUtil {

	public static String returnSuccess(Object data) {
		Response response = new Response();
		response.setCode(ResultEnum.SUCCESS.getCode());
		response.setMsg(ResultEnum.SUCCESS.getMsg());
		response.setData(data);
		return JSONObject.toJSONString(response);
	}

	public static String returnResult(Object data, ResultEnum result) {
		Response response = new Response();
		response.setCode(result.getCode());
		response.setMsg(result.getMsg());
		response.setData(data);
		return JSONObject.toJSONString(response);
	}

	public static String returnResult(ResultEnum result) {
		Response response = new Response();
		response.setCode(result.getCode());
		response.setMsg(result.getMsg());
		return JSONObject.toJSONString(response);
	}

}
