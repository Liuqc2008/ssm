package com.how2java.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.util.WeixinUtil;

import weixinapi.WeiXinApi;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class WeixinSendRedPackage {

	/*
	 * 微信发送现金红包接口
	 */
	@Test
	public void SendRedPackage() throws Exception {
		
		
		String orderCode = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()); 
		
		model.SendRedPack sendRedPack = new model.SendRedPack();
		
		sendRedPack.setNonce_str(WeixinUtil.returnUUID()); 		//随机字符串，不长于32位
		sendRedPack.setMch_billno(orderCode);				//商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z）最大 28字节
		sendRedPack.setMch_id("1491480322");				//微信支付分配的商户号   不长于32位
		sendRedPack.setWxappid("wx72bf195e57bcf526");		//"公众号appid",
		sendRedPack.setSend_name("感谢关注！！");			//商户名称   红包发送者名称   不长于32位
		sendRedPack.setRe_openid("oSU4Bv0UoseNDYG7FSVkbJmmO-Ds");	//接受红包的用户openid 
        sendRedPack.setTotal_amount(10);					//付款金额，单位分
        sendRedPack.setTotal_num(1);						//红包发放总人数 total_num=1
        sendRedPack.setWishing("萌萌哒");					//红包祝福语
        sendRedPack.setClient_ip("127.0.0.1");		//调用接口的机器Ip地址
        sendRedPack.setAct_name("桑博红包");			//活动名称
        sendRedPack.setRemark("桑博");				//备注信息
        sendRedPack.setScene_id("PRODUCT_1");		//发放红包使用场景，红包金额大于200或者小于1元时必传	String(32)

        WeiXinApi.SendCashRedPackage(sendRedPack);
	}
}
