package com.project.util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransToaccountTransferModel;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
/**
 * 支付宝支付工具类
 * 2018-10-16
 * @author 张鹏浩
 *
 */
public class AliPayUtil {
	
	/**
	 * 获取支付宝支付串
	 * @param model 支付宝实体参数
	 * @param notifyUrl 回调方法
	 * @return 支付串
	 */
	public static String aliPay(AlipayTradeAppPayModel model,String notifyUrl) {
//		model.setBody("我是测试数据");
//		model.setSubject("App支付测试Java");
//		model.setOutTradeNo(outtradeno);
//		model.setTimeoutExpress("30m");
//		model.setTotalAmount("0.01");
//		model.setProductCode("QUICK_MSECURITY_PAY");
		String orderStr="";
		try {
			// 实例化客户端
			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
					PayParameter.ALI_APP_ID, PayParameter.ALI_APP_PRIVATE_KEY, "json", "UTF-8", PayParameter.Ali_PUBLIC_KEY,
					"RSA2");
			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
			request.setBizModel(model);
			request.setNotifyUrl(notifyUrl);
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			System.out.println(response.getBody());// 就是orderString 可以直接给客户端请求，无需再做处理。
			if(response.isSuccess()) {
				System.err.println(response.getMsg());
				return response.getBody();
			}else {
				System.out.println(response.getSubMsg());
				return null;
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 获取支付宝支付串
	 * @param model 支付宝实体参数
	 * @param notifyUrl 回调方法
	 * @return 支付串
	 * @throws AlipayApiException 
	 */
	public static AlipayFundTransToaccountTransferResponse aliTransfer(AlipayFundTransToaccountTransferModel model) throws AlipayApiException {
			// 实例化客户端
			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",PayParameter.ALI_APP_ID,PayParameter.ALI_APP_PRIVATE_KEY,"json","UTF-8",PayParameter.ALI_ALIPAY_PUBLIC_KEY,"RSA2");
			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
			request.setBizModel(model);
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayFundTransToaccountTransferResponse  response = alipayClient.execute(request);
			return response;
	}
	
	
	/**
	 * 处理支付宝回调
	 * @param request
	 * @param response
	 * @return 支付成功还是失败
	 */
	public static Map<String,Object> aliNotice(HttpServletRequest request,HttpServletResponse response) {
		 Map<String,Object> map=new HashMap<String,Object>();
		try {
			//获取支付宝POST过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			    String name = (String) iter.next();
			    String[] values = (String[]) requestParams.get(name);
			    String valueStr = "";
			    for (int i = 0; i < values.length; i++) {
			        valueStr = (i == values.length - 1) ? valueStr + values[i]
			                    : valueStr + values[i] + ",";
			  	}
			    //乱码解决，这段代码在出现乱码时使用。
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
			//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
			 boolean flag = AlipaySignature.rsaCheckV1(params, PayParameter.ALI_ALIPAY_PUBLIC_KEY, "UTF-8","RSA2");
			 map.put("flag", flag);
			 map.put("data", params);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 将服务处理的结果返回给支付平台 
	 * 
	 * @param response
	 * @param str
	 * @throws IOException 
	 */
	public static void responseService(HttpServletResponse response,String str) throws IOException{
		System.out.println("response:"+response==null);
		response.getContentType();
		response.setHeader("contentType", "text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(str);
		pw.close();
	}
}
