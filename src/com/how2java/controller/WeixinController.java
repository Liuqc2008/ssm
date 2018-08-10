package com.how2java.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.util.WebUtil;
import com.how2java.weixinservcie.MenuService;
import com.how2java.weixinservcie.WeixinOauth2Service;
import com.how2java.weixinutil.AccessTokenUtil;

@Controller
@RequestMapping("weixin")
public class WeixinController {
	public final static String AppID = "wx1d02f3d1411a96e3";
	public final static String AppSecret = "e649404687a1b4abe62063cb18095fd6";
	
	@Autowired
	WeixinOauth2Service weixinOauth2Service;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping("login")
	public ModelAndView listCategory() throws UnsupportedEncodingException{
		ModelAndView mav = new ModelAndView();
		
		String str = "http://313624981.tunnel.qydev.com/weixin/Oauth";
		String codeUrl = weixinOauth2Service.GetCodeUrl("wx1d02f3d1411a96e3", URLEncoder.encode(str, "UTF-8"), "snsapi_userinfo");
		mav.addObject("cs", codeUrl);
		mav.setViewName("jsp/weixin/login");
		return mav;
	}

	/*
	 * 微信授权回调页面
	 */
	@RequestMapping("Oauth")
	public ModelAndView Oauth(){
		HttpServletRequest request = WebUtil.getHttpServletRequest();
		
		ModelAndView mav = new ModelAndView();
		HashMap<String,String> param = WebUtil.GetRequestParam(request.getQueryString());
			
		Map<String, Object>  userinfo = weixinOauth2Service.GetUserInfo(AppID, AppSecret, param.get("code").toString());
		
		mav.addObject("country", userinfo.get("country"));
		mav.addObject("province", userinfo.get("province"));
		mav.addObject("city", userinfo.get("city"));
		mav.addObject("sex", userinfo.get("sex"));
		mav.addObject("nickname", userinfo.get("nickname"));
		mav.addObject("headimgurl", userinfo.get("headimgurl"));
		mav.addObject("language", userinfo.get("language"));
		mav.addObject("openid", userinfo.get("openid"));
		mav.addObject("privilege", userinfo.get("privilege"));
		mav.setViewName("jsp/weixin/oauth");
		return mav;
	}
	
	/*
	 * 通过openid获取用户信息
	 */
	@RequestMapping("userinfo")
	public ModelAndView UserInfo(){
		ModelAndView mav = new ModelAndView();

		Map<String, Object> userinfo = weixinOauth2Service.GetUserInfo(AccessTokenUtil.GetTokenSession(AppID, AppSecret), "oOaWMty6ZXxCEr967bKp9NUH5hSU");
		
		mav.addObject("country", userinfo.get("country"));
		mav.addObject("province", userinfo.get("province"));
		mav.addObject("city", userinfo.get("city"));
		mav.addObject("sex", userinfo.get("sex"));
		mav.addObject("nickname", userinfo.get("nickname"));
		mav.addObject("headimgurl", userinfo.get("headimgurl"));
		mav.addObject("language", userinfo.get("language"));
		mav.addObject("openid", userinfo.get("openid"));
		mav.addObject("privilege", userinfo.get("privilege"));
		mav.setViewName("jsp/weixin/userinfo");
		return mav;
	}
	
	@RequestMapping("jssdk")
	public ModelAndView jssdk(){
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("jsp/weixin/jssdk");
		return mav;
	}
	
	@RequestMapping("menu")
	public ModelAndView menu(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("jsp/weixin/menu");
		return mav;
	}
	
	@RequestMapping(value="CreateMenu")
	@ResponseBody
	public String CreateMenu(String data) {
		String result = menuService.CreateMenu(data, AppID, AppSecret);
		
		return result;
	}
	
	@RequestMapping(value="GetMenu")
	@ResponseBody
	public String GetMenu() {
		String result = menuService.GetMenu(AppID, AppSecret);
		
		return result;
	}
	
	@RequestMapping(value="DeleteMenu")
	@ResponseBody
	public String DeleteMenu() {
		String result = menuService.DeleteMenu(AppID, AppSecret);
		
		return result;
	}
}
