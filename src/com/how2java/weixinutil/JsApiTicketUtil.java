package com.how2java.weixinutil;

import com.alibaba.fastjson.JSONObject;
import com.how2java.util.WebUtil;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.Formatter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;  

public class JsApiTicketUtil {
	
	public static void main(String[] args) {		
		String access_token = AccessTokenUtil.GetTokenSession("wx1d02f3d1411a96e3", "e649404687a1b4abe62063cb18095fd6");
		String jsapi_ticket = JsApiTicketUtil.GetJsApiTicket(access_token);

        // 注意 URL 一定要动态获取，不能 hardcode
        String url = "http://example.com";
        Map<String, String> ret = JsApiTicketUtil.sign(jsapi_ticket, url);
        for (Map.Entry entry : ret.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    };
	
	/*
	 * 接受数据格式
	 * {"access_token":"12_2ITCbzLVAtV7wu0vlCE2mn5UoEm2RuM3LNPGbRTGnon70r42XQNApo0IAs3XSgQA_LJMn-tNlMuaSq9cHUUP3hgWWmqSOxjrj3hjb9neWGePslXwgNKi60RHvEHQeExDovHEKygiGpOjfOLjOCFfAAARFI",
	 * "expires_in":7200}
	 */
	public static String GetJsApiTicket(String accessToken){
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";// 全局accesstoken接口
		url = url.replace("ACCESS_TOKEN", accessToken);
		String webString = WebUtil.httpsRequest(url, "GET", null);
		
		JSONObject jsonObject = JSONObject.parseObject(webString);
		return jsonObject.getString("ticket");
	}
	
	public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }
	
	private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
