package com.project.util.aliyun;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Encoder;

/**
 * 人脸识别
 * 
 * @author rbf
 *
 */
public class AESDecode {
	private static final Logger log = LoggerFactory.getLogger(AESDecode.class);

	/*
	 * 计算MD5+BASE64
	 */
	public static String MD5Base64(String s) {
		if (s == null)
			return null;
		String encodeStr = "";
		byte[] utfBytes = s.getBytes();
		MessageDigest mdTemp;
		try {
			mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(utfBytes);
			byte[] md5Bytes = mdTemp.digest();
			BASE64Encoder b64Encoder = new BASE64Encoder();
			encodeStr = b64Encoder.encode(md5Bytes);
		} catch (Exception e) {
			throw new Error("Failed to generate MD5 : " + e.getMessage());
		}
		return encodeStr;
	}

	/*
	 * 计算 HMAC-SHA1
	 */
	public static String HMACSha1(String data, String key) {
		String result;
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());
			result = (new BASE64Encoder()).encode(rawHmac);
		} catch (Exception e) {
			throw new Error("Failed to generate HMAC : " + e.getMessage());
		}
		return result;
	}

	/*
	 * 等同于javaScript中的 new Date().toUTCString();
	 */
	public static String toGMTString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
		df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
		return df.format(date);
	}

	/*
	 * 发送POST请求
	 */
	public static FaceVerifyResponse sendPost(FaceVerifyParam faceVerifyParam) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		int statusCode = 200;
		try {
			String body = JSON.toJSONString(faceVerifyParam);
			URL realUrl = new URL(AliyunParameter.verifyurl);
			/*
			 * http header 参数
			 */
			String method = "POST";
			String accept = "application/json";
			String content_type = "application/json";
			String path = realUrl.getFile();
			String date = toGMTString(new Date());
			// 1.对body做MD5+BASE64加密
			String bodyMd5 = MD5Base64(body);
			String stringToSign = method + "\n" + accept + "\n" + bodyMd5 + "\n" + content_type + "\n" + date + "\n"
					+ path;
			// 2.计算 HMAC-SHA1
			String signature = HMACSha1(stringToSign, AliyunParameter.AccessKeySecret);
			// 3.得到 authorization header
			String authHeader = "Dataplus " + AliyunParameter.AccessKeyID + ":" + signature;
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", accept);
			conn.setRequestProperty("content-type", content_type);
			conn.setRequestProperty("date", date);
			conn.setRequestProperty("Authorization", authHeader);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(body);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			statusCode = ((HttpURLConnection) conn).getResponseCode();
			if (statusCode != 200) {
				in = new BufferedReader(new InputStreamReader(((HttpURLConnection) conn).getErrorStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			if (statusCode != 200) {
				throw new IOException("\nHttp StatusCode: " + statusCode + "\nErrorMessage: " + result);
			}
			FaceVerifyResponse faceVerifyResponse = null;
			if (StringUtils.isNotEmpty(result)) {
				faceVerifyResponse = JSON.parseObject(result, FaceVerifyResponse.class);
			}
			return faceVerifyResponse;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 将本地图片编码为base64
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String encodeImageToBase64(InputStream in) throws Exception {
		// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;
		// 读取图片字节数组
		try {
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("图片上传失败,请联系客服!");
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		String base64 = encoder.encode(data);
		return base64;// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 根据地址获得数据的输入流
	 * 
	 * @param strUrl 网络连接地址
	 * @return url的输入流
	 */
	public static InputStream getInputStreamByUrl(String strUrl) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(20 * 1000);
			final ByteArrayOutputStream output = new ByteArrayOutputStream();
			IOUtils.copy(conn.getInputStream(), output);
			return new ByteArrayInputStream(output.toByteArray());
		} catch (Exception e) {
			log.error(e + "");
		} finally {
			try {
				if (conn != null) {
					conn.disconnect();
				}
			} catch (Exception e) {
				log.error(e + "");
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		// 发送POST请求示例
		FaceVerifyParam faceVerifyParam = new FaceVerifyParam();
		faceVerifyParam.setType("0");
		faceVerifyParam.setImage_url_1(
				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556604725295&di=481574b1a4a31975e4380cca02911711&imgtype=0&src=http%3A%2F%2Fi2.hexunimg.cn%2F2014-04-21%2F164112790.jpg");
		faceVerifyParam.setImage_url_2(
				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556604725295&di=481574b1a4a31975e4380cca02911711&imgtype=0&src=http%3A%2F%2Fi2.hexunimg.cn%2F2014-04-21%2F164112790.jpg");
//        System.out.println(body);
		System.out.println("response body:" + sendPost(faceVerifyParam));
	}
}
