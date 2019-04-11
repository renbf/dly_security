package com.project.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SMSsend {
	/**
	 * 短信接收并验证
	 */
	public class CheckCode  {
//		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String code = request.getParameter("code");
			// 验证验证码
			String sessionCode = request.getSession().getAttribute("code").toString();
			if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
				if (code.equalsIgnoreCase(sessionCode)) {
					response.getWriter().println("验证通过！");
				} else {
					response.getWriter().println("验证失败！");
				}
			} else {
				response.getWriter().println("验证失败！");
			}
		}
	}
	/**
	 * 短信发送
	 * @throws ClientException
	 */
	public static boolean SMSSend(String phone,String SMSCode) throws ClientException{
		//TODO: 测试环境不发送验证码正式环境放开
		//设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化ascClient需要的几个参数
		final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
		//替换成你的AK
		final String accessKeyId = "LTAItfXsdUMq2e7a";//你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = "XNOhdSM5Krq3ccduEN7Rnh7u1riFRW";//你的accessKeySecret，参考本文档步骤2
		//初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		//组装请求对象    使用post提交`
		IAcsClient acsClient = new DefaultAcsClient(profile);
		SendSmsRequest request = new SendSmsRequest();
		request.setMethod(MethodType.POST);
		//必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
		request.setPhoneNumbers(phone);
		//必填:短信签名-可在短信控制台中找到
		request.setSignName("吉麦科技");
		//必填:短信模板-可在短信控制台中找到
		request.setTemplateCode("SMS_148270046");
		//可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		//友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		request.setTemplateParam("{\"code\":\""+SMSCode+"\"}");
		//可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		//request.setSmsUpExtendCode("90997");
		//可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");
		//请求失败这里会抛ClientException异常
		System.out.println("======================="+ SMSCode +"============================");
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			System.out.println("短信验证码发送成功");
			//请求成功
//			resultJson.put("resultCode",Constants.SUCCESS);
//			resultJson.put("resultDesc",Constants.SUCCESS_DESC);
//			resultJson.put("SMSCode",SMSCode);
			/*return  sendSmsResponse.getCode();*/
			return true;
		}else{
			System.out.println("短信验证码发送失败");
			return false;
		}
	}
	
}