package com.how2java.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.util.JSONObjectToHashMap;
import com.how2java.util.WebUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void testAdd() {
		
		
		String jsonString = "{access_token=12_s53UZafuO-Ix1tegKY3h7muvF8iru5fiPR79vyW8QDf78WsZKL0nB63Ol7fjiTPcZ5r4dNVjtVJKTfMUrrxE6w, refresh_token=12_e4qUBqLePaM2kGveOWSPQaaOZjJyB3v5BC6r6lI-ob3Ezc-mHJ4Fy9hyIdUQikyQfvRnEMOD2YN97tT4JD0wyw, openid=oOaWMty6ZXxCEr967bKp9NUH5hSU, scope=snsapi_userinfo, expires_in=7200}";
		
		Map<String, Object> hashMap = JSONObjectToHashMap.toHashMap(jsonString);
		
		if(! hashMap.containsKey("openid"))
			System.out.print("获取openid失败，错误码：" + hashMap.get("errcode"));
		else{
			String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + hashMap.get("access_token") + "&openid=" + hashMap.get("openid") + "&lang=zh_CN";
			String result = WebUtil.httpsRequest(url, "", "");
		}
	}

	

}
