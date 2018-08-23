package com.how2java.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class WeixinUtil {
	public final static String js_api_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/**
     * 获取UUID
     * @return
     */
    public static String returnUUID() {
        return parseStrToMd5L32(UUID.randomUUID().toString());
    }

    /**
     * 获取md5
     * @param str
     * @return
     */
    public static String parseStrToMd5L32(String str) {
        return parseStrToMd5L32(str,"utf-8");
    }

    public static String parseStrToMd5L32(String str,String charset) {
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes(charset));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return reStr;
    }

}
