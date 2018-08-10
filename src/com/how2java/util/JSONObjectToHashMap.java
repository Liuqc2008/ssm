package com.how2java.util;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONObjectToHashMap {
	
	public static Map<String, Object> toHashMap(String jsonString) {
        Map<?, ?> hashMap = JSON.parseObject(jsonString, HashMap.class);
 
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for(Iterator<?> iter = hashMap.keySet().iterator(); iter.hasNext();){
            String key = (String)iter.next();
            if(hashMap.get(key) instanceof JSONArray){
                JSONArray jsonArray = (JSONArray)hashMap.get(key);
                List<?> list = handleJSONArray(jsonArray);
                resultMap.put(key, list);
            }else{
                resultMap.put(key, hashMap.get(key));
            }
        }
        return resultMap;
    }
	
	public static List<Map<String, Object>> handleJSONArray(JSONArray jsonArray){
        List list = new ArrayList();
	        for (Object object : jsonArray) {
	            JSONObject jsonObject = (JSONObject) object;
	            Map<String, Object> map = new HashMap<String, Object>();
	            for (Map.Entry entry : jsonObject.entrySet()) {
	                if(entry.getValue() instanceof  JSONArray){
	                    map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));
	                }else{
	                    map.put((String)entry.getKey(), entry.getValue());
	                }
	            }
	            list.add(map);
	        }
	        return list;
	    }
}
