package com.how2java.weixinservcie.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.how2java.weixinservcie.JsSDKService;
import com.how2java.weixinutil.AccessTokenUtil;
import com.how2java.weixinutil.JsApiTicketUtil;

@Service
public class JsSDKServiceImpl implements JsSDKService {
	
	
	public Map<String, Object> GetConfig(String AppID, String AppSecret){
		Map<String, Object> hashMap = new HashMap<String, Object>();
		
		//String access_token = AccessTokenUtil.GetTokenSession(AppID, AppSecret);
		//String jsapi_ticket =JsApiTicketUtil.GetJsApiTicket(access_token);
		//String url = "http://example.com";
		
		
		return hashMap;
	}
	
	public Map<String, String> GetSign(String AppID, String AppSecret){
		String access_token = AccessTokenUtil.GetTokenSession(AppID, AppSecret);
		String jsapi_ticket = JsApiTicketUtil.GetJsApiTicket(access_token);

        String url = "http://313624981.tunnel.qydev.com/weixin/jssdk";
        Map<String, String> ret = JsApiTicketUtil.sign(jsapi_ticket, url);
        
        return ret;
	}
	
}
