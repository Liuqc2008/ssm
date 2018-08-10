package com.how2java.weixinservcie;

import java.util.Map;

public interface JsSDKService {
	Map<String, Object> GetConfig(String AppID, String AppSecret);
	
	Map<String, String> GetSign(String AppID, String AppSecret);
}
