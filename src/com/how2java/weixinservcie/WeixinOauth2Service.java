package com.how2java.weixinservcie;

import java.util.Map;

public interface WeixinOauth2Service {
	
	String GetCodeUrl(String Appid, String redirect_uri, String scope);
	
	Map<String, Object> GetOpenId(String appid, String appsecret, String code);
	
	Map<String, Object> GetUserInfo(String appid, String appsecret, String code);
	
	Map<String, Object> GetUserInfo(String accessToken, String openId);
}
 