package com.project.util;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.project.util.wxpayutil.MyConfig;
import com.project.util.HttpsClientUtil;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;

/**
 *  微信支付
 *  2018-10-16
 * @author 张鹏浩
 *
 */
public class WXPayExample {
	/**
	 * 统一下单
	 * @return
	 */
	public static Map<String,String> unifiedOrder(Map<String, String> data ) {
			Map<String,String> resp = new HashMap<>();
			Map<String,String> map = new HashMap<>();
	        try {
	        	MyConfig config = new MyConfig();
	        	data.put("appid", config.getAppID());
	        	data.put("mch_id", config.getMchID());
	 	        data.put("nonce_str", WXPayUtil.generateNonceStr());
	 	       String xml = WXPayUtil.generateSignedXml(data, config.getKey());
	 	       String str = HttpsClientUtil.httpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder", 
	    				"POST", xml);
	 	      map = WXPayUtil.xmlToMap(str);
	 	       System.out.println("支付成功后:"+str);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return map;
	    }
	/**
	 * 微信回调
	 * @param
	 * @return
	 */
	public static Map<String, String>  queryOrder(String notifyData) {
		Map<String, String> map = new TreeMap<String,String>();
		try {
	        map = WXPayUtil.xmlToMap(notifyData);  // 转换成map
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	  /**
     * 给微信发送xml消息
     * @param return_code
     * @param return_msg
     * @return
     */
    public static String setXml(String return_code, String return_msg) {  
        SortedMap<String, String> parameters = new TreeMap<String, String>();  
        parameters.put("return_code", return_code);  
        parameters.put("return_msg", return_msg);  
        return "<xml><return_code><![CDATA[" + return_code + "]]>" +   
                "</return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";  
    }  
}
