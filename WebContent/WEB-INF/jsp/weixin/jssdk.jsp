<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
  	<title>js_sdk</title>
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
  	<script type="text/javascript" src="/Resource/Script/jquery-3.3.1.min.js"></script>
  	<script type="text/javascript" src="/Resource/Script/layui/layui.js"></script>
	<link href="/Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
	
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	
	<script>
		wx.config({
		    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: "wx1d02f3d1411a96e3", // 必填，公众号的唯一标识
		    timestamp: "${sign['timestamp']}", 	// 必填，生成签名的时间戳
		    nonceStr: "${sign['nonceStr']}", // 必填，生成签名的随机串
		    signature: "${sign['signature']}",// 必填，签名
		    jsApiList: ['onMenuShareAppMessage',
		                'onMenuShareTimeline',
		                'chooseImage',
                		'scanQRCode'] // 必填，需要使用的JS接口列表
		});
		
		wx.ready(function(res) {
			wx.onMenuShareTimeline({
				title: '分享标题', // 分享标题
			    link: "http://313624981.tunnel.qydev.com/weixin/jssdk",
			    imgUrl: "http://313624981.tunnel.qydev.com/Resource/Themes/Image/201808101600.png", // 分享图标
			    success: function () {
			    	alert("分享成功！");
				},
			});
			
			wx.onMenuShareAppMessage({
	    		title: '分享标题', // 分享标题
		        desc: "分享描述", // 分享描述
		        link: "http://313624981.tunnel.qydev.com/weixin/jssdk",
		        imgUrl: "http://313624981.tunnel.qydev.com/Resource/Themes/Image/201808101600.png", // 分享图标
		        type: 'link', // 分享类型,music、video或link，不填默认为link
		        success: function () {
		        	// 用户点击了分享后执行的回调函数
		        	alert("分享成功！");
	        	},
		    	cancel: function (res) {
	                alert('已取消');
	            },
	            fail: function (res) {
	              alert(JSON.stringify(res));
	            }
		    });
		});
		
		
		 // 2. 分享接口
		  // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
	  	function ShareAppMessage() {
	  		wx.onMenuShareTimeline({
				title: '分享标题', // 分享标题
			    link: "http://313624981.tunnel.qydev.com/weixin/jssdk",
			    imgUrl: "http://313624981.tunnel.qydev.com/Resource/Themes/Image/201808101600.png", // 分享图标
			    success: function () {
			    	alert("分享成功！");
				},
			});
	  	};
		
	  	function ChooseImage() {
	  		wx.chooseImage({
	          	success: function (res) {
	            	
	            
	          	}
	        });
	  	}
	  	
	  	function ScanQRCode(){
	  		wx.scanQRCode({
	  			needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
	  			scanType: ["qrCode"], // 可以指定扫二维码还是一维码，默认二者都有
	  			success: function (res) {
	  				alert(res.resultStr); 
	  			}
  			});
	  	}	
	</script>
</head>
<body>
	${ sign['jsapi_ticket'] }
	<br/>
  	<button type="button" onclick="ShareAppMessage()">分享朋友</button>
  	<button type="button" onclick="ChooseImage()">手机照片</button>
  	<button type="button" onclick="ScanQRCode()">扫一扫</button>
  	<br/>
  	<img src="/Resource/Themes/Image/201808101600.png"/>
</body>
</html>

 
 