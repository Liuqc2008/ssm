package com.how2java.weixinutil;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.how2java.util.WebUtil;


public class AccessTokenUtil {
	public static String SessionAccessToken = "access_token";
	
	public static String GetTokenSession(String appID, String appSecret){
		String tokenSession = "";
		HttpSession session = WebUtil.getHttpSession();
		
		if(session.getAttribute(SessionAccessToken) == null){
			tokenSession = AddTokenSession(appID, appSecret);
		}else{
			tokenSession = session.getAttribute(SessionAccessToken).toString();
		}
			
		return tokenSession;
	}
	
	/*
	 * 数据格式
	 * {"access_token":"12_cAEfX_Ay0lrmMPJssRdv0ujGJ2uRU0hGVK8hQI73jGQXlNJ0CQIkkpnHFVPXWfpmz2Qm5Sy5KX0C_UociA2HnnWxTS3Rgstx9rIZcMhzRIkAKv24_I8DOQl_DbyM7mNbM8pcuhN-t4Ac4RUBFYSeABAYRL",
	 *  "expires_in":7200}
	 * */
	public static String AddTokenSession(String appID, String appSecret)
    {
		HttpSession session = WebUtil.getHttpSession();
		
		String accessToken = GetAccessToken(appID, appSecret);
		
		JSONObject jsonObject = JSONObject.parseObject(accessToken);
		
		session.setAttribute(SessionAccessToken, jsonObject.getString("access_token"));
		session.setMaxInactiveInterval(7200);
		
        return session.getAttribute(SessionAccessToken).toString();
    }
	
	/*
	 * 接受数据格式
	 * {"access_token":"12_2ITCbzLVAtV7wu0vlCE2mn5UoEm2RuM3LNPGbRTGnon70r42XQNApo0IAs3XSgQA_LJMn-tNlMuaSq9cHUUP3hgWWmqSOxjrj3hjb9neWGePslXwgNKi60RHvEHQeExDovHEKygiGpOjfOLjOCFfAAARFI",
	 * "expires_in":7200}
	 */
	public static String GetAccessToken(String appID, String appSecret){
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";// 全局accesstoken接口
		url = url.replace("APPID", appID).replace("APPSECRET", appSecret);
		String jsonObject = WebUtil.httpsRequest(url, "GET", null);
		
		return jsonObject;
	}
}
