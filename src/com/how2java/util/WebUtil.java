package com.how2java.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
 
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class WebUtil {
	
	/**
	 * 获取当前请求request
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
				.getRequestAttributes()).getRequest();
		
		return request;
	}	
	
	/**
	 * 获取当前请求session
	 * @return
	 */
	public static HttpSession getHttpSession(){
		return getHttpServletRequest().getSession();
	}
	
	/**
	 * @param urlparam 带分隔的url参数
	 * @return
	 */
	public static HashMap<String,String> GetRequestParam(String urlparam){
		HashMap<String,String> map = new HashMap<String,String>();
		String[] param =  urlparam.split("&");
		for(String keyvalue:param){
			String[] pair = keyvalue.split("=");
			if(pair.length==2){
				map.put(pair[0], pair[1]);
			}
	   }
	   return map;
	}
	
	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		  //conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			//BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			
			return buffer.toString();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return "";
	}
	
	public static byte[] DownloadPicture(String requestUrl) {
		byte[] result = null;
		try {
			URL url = new URL(requestUrl);
			url = new URL(requestUrl);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            result=output.toByteArray();
            dataInputStream.close();
            
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return result;
	}
}
