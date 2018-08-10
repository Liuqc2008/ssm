package com.how2java.weixinservcie.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.how2java.util.JSONObjectToHashMap;
import com.how2java.util.WebUtil;
import com.how2java.weixinservcie.WeixinOauth2Service;

@Service
public class WeixinOauth2ServiceImpl implements WeixinOauth2Service{
	
	/**
	 * 
	 */
	public String GetCodeUrl(String Appid, String redirect_uri, String scope){
		return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STATE#wechat_redirect", Appid, redirect_uri, scope);
	}
	
	/**
	 * 返回数据格式：
	 * {country=冰岛, 
		province=, 
		city=, 
		openid=oOaWMty6ZXxCEr967bKp9NUH5hSU, 
		sex=1, 
		nickname=x, 
		headimgurl=http://thirdwx.qlogo.cn/mmopen/vi_32/4l1fGSUsSj8IuuUdbK3uQqMlCuxfPZSANW8ZvQ63A405j4L3h2m68C2sic8KSXafib7bPT67juwM8S1XgUv315icg/132, 
		language=zh_CN, 
		privilege=[]}
	 */
	public Map<String, Object> GetOpenId(String appid, String appsecret, String code){
		String token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appid + "&secret=" + appsecret + "&code=" + code + "&grant_type=authorization_code";
		
		String jsonString = WebUtil.httpsRequest(token_url, "GET", null);
		
		Map<String, Object> hashMap = JSONObjectToHashMap.toHashMap(jsonString);
		return hashMap;
	}
	
	/**
	 * 返回数据格式：{"access_token":"12_P6F4y9ISrzXmoqT2eVDVCvwEBBWOCtQCgPMtgk13pfkk5G2Rw2kcTcd34saLPMZzY4I1KlcagAQkwBEIVU6BgQ",
  					 "expires_in":7200,
  					 "refresh_token":"12_zVCxFgTNwM4mpN0OdMLO46l3mjvWoaI7MregGJg1W0kNHlQUcADxQhLjGJ-zClYBObcGDWA_h6WpftMPxtrXJQ",
  					 "openid":"oOaWMty6ZXxCEr967bKp9NUH5hSU",
  					 "scope":"snsapi_userinfo"}
	 */
	public Map<String, Object> GetUserInfo(String appid, String appsecret, String code){
		Map<String, Object> hashMap = null;
		
		Map<String, Object> openId = GetOpenId(appid, appsecret, code);
		if(! openId.containsKey("openid"))
			System.out.print("获取openid失败，错误码：" + openId.get("errcode"));
		else{
			String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + openId.get("access_token") + "&openid=" + openId.get("openid") + "&lang=zh_CN";
			String jsonString = WebUtil.httpsRequest(url, "GET", "");
			
			hashMap = JSONObjectToHashMap.toHashMap(jsonString);
		}
		
		return hashMap;
	}
	
	public Map<String, Object> GetUserInfo(String accessToken, String openId){
		Map<String, Object> hashMap = null;

		String url = String.format("https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=oOaWMty6ZXxCEr967bKp9NUH5hSU&lang=zh_CN", accessToken);
		String jsonString = WebUtil.httpsRequest(url, "GET", "");
		
		hashMap = JSONObjectToHashMap.toHashMap(jsonString);
		return hashMap;
	}
}
