package com.how2java.weixinservcie.impl;


import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.how2java.util.WebUtil;
import com.how2java.weixinservcie.MenuService;
import com.how2java.weixinutil.AccessTokenUtil;


@Service
public class MenuServiceImpl implements MenuService {
	
	
	public String CreateMenu(String MenuJson, String AppID, String AppSecret){
		String setMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}";
		String access_token = AccessTokenUtil.GetTokenSession(AppID, AppSecret);
		
		setMenuUrl = setMenuUrl.replace("{0}", access_token);
		String jsonString = WebUtil.httpsRequest(setMenuUrl, "POST", MenuJson);
		
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		
		String msg = "";
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			
			if (0 == errorCode) {

				msg = "creat menu is OK!";
			} else {
				msg = "creat menu is errcode:{} errmsg:{}"+ errorCode+ errorMsg;
			}
		}
		
		return msg;
	}
	
	public String GetMenu(String AppID, String AppSecret){
		String setMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token={0}";
		String access_token = AccessTokenUtil.GetTokenSession(AppID, AppSecret);
		setMenuUrl = setMenuUrl.replace("{0}", access_token);
		
		String jsonString = WebUtil.httpsRequest(setMenuUrl, "POST", null);
        
        return jsonString;
	}

	public String DeleteMenu(String AppID, String AppSecret){
		String setMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={0}";
		String access_token = AccessTokenUtil.GetTokenSession(AppID, AppSecret);
		setMenuUrl = setMenuUrl.replace("{0}", access_token);
		
		String jsonString = WebUtil.httpsRequest(setMenuUrl, "POST", null);
		
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		
		String msg = "";
		if (null != jsonObject) {
			int errorCode = jsonObject.getIntValue("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			
			if (0 == errorCode) {
				msg = "creat menu is OK!";
			} else {
				msg = "creat menu is errcode:{} errmsg:{}"+ errorCode+ errorMsg;
			}
		}
		
		return msg;
	}
}
