package com.how2java.weixinservcie;

public interface MenuService {

	String CreateMenu(String MenuJson, String AppID, String AppSecret);
	
	String GetMenu(String AppID, String AppSecret);
	
	String DeleteMenu(String AppID, String AppSecret);
}
